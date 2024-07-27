package com.film.outseraapi.service;

import com.film.outseraapi.dto.AwardsIntervalDTO;
import com.film.outseraapi.dto.ProducerPrizesDTO;
import com.film.outseraapi.entity.Movie;
import com.film.outseraapi.entity.MovieProducer;
import com.film.outseraapi.entity.Producer;
import com.film.outseraapi.repository.MovieProducerRepository;
import com.film.outseraapi.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private MovieProducerRepository movieProducerRepository;

    public void saveProducers(Movie movie, String producers) {
        for (String strProducer : producers.split(",|\\ and ")) {
            Producer producer = new Producer(strProducer);

            Example<Producer> example = Example.of(producer);

            if (producerRepository.exists(example)) {
                producer = producerRepository.findByName(strProducer.trim());
            } else {
                producer = producerRepository.save(producer);
            }

            movieProducerRepository.save(new MovieProducer(movie, producer));
        }
    }

    public AwardsIntervalDTO getMaxAndMinPrizes() {
        List<MovieProducer> mpList = movieProducerRepository.findByMovieWinnerOrderByProducerId(true);

        AwardsIntervalDTO dto = new AwardsIntervalDTO();
        dto.setMin(findMinInterval(mpList));
        dto.setMax(findMaxInterval(mpList));

        return dto;
    }

    private List<ProducerPrizesDTO> findMinInterval(List<MovieProducer> mpList) {
        Map<String, List<Integer>> producerWins = new HashMap<>();

        for (MovieProducer mp : mpList) {
            producerWins.computeIfAbsent(mp.getProducer().getName(), k -> new ArrayList<>())
                    .add(mp.getMovie().getYear());
        }

        List<ProducerPrizesDTO> listMinIntervals = new ArrayList<>();
        int minInterval = Integer.MAX_VALUE;

        for (Map.Entry<String, List<Integer>> entry : producerWins.entrySet()) {
            String producer = entry.getKey();
            List<Integer> years = entry.getValue();

            Collections.sort(years);

            for (int i = 0; i < years.size() - 1; i++) {
                int interval = years.get(i + 1) - years.get(i);
                if (interval < minInterval) {
                    minInterval = interval;
                    listMinIntervals.clear();
                    listMinIntervals.add(new ProducerPrizesDTO(producer, interval, years.get(i), years.get(i + 1)));
                } else if (interval == minInterval) {
                    listMinIntervals.add(new ProducerPrizesDTO(producer, interval, years.get(i), years.get(i + 1)));
                }
            }
        }
        return listMinIntervals;
    }

    private List<ProducerPrizesDTO> findMaxInterval(List<MovieProducer> mpList) {
        Map<String, List<Integer>> producerWins = new HashMap<>();

        for (MovieProducer mp : mpList) {
            producerWins.computeIfAbsent(mp.getProducer().getName(), k -> new ArrayList<>())
                    .add(mp.getMovie().getYear());
        }

        List<ProducerPrizesDTO> listMaxIntervals = new ArrayList<>();
        int maxInterval = Integer.MIN_VALUE;

        for (Map.Entry<String, List<Integer>> entry : producerWins.entrySet()) {
            String producer = entry.getKey();
            List<Integer> years = entry.getValue();

            Collections.sort(years);

            for (int i = 0; i < years.size() - 1; i++) {
                int interval = years.get(i + 1) - years.get(i);
                if (interval > maxInterval) {
                    maxInterval = interval;
                    listMaxIntervals.clear();
                    listMaxIntervals.add(new ProducerPrizesDTO(producer, interval, years.get(i), years.get(i + 1)));
                } else if (interval == maxInterval) {
                    listMaxIntervals.add(new ProducerPrizesDTO(producer, interval, years.get(i), years.get(i + 1)));
                }
            }
        }
        return listMaxIntervals;
    }
}
