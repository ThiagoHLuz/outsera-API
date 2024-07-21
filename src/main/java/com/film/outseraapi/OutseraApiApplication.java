package com.film.outseraapi;

import com.film.outseraapi.entity.Movie;
import com.film.outseraapi.repository.MovieRepository;
import com.film.outseraapi.service.ProducerService;
import com.film.outseraapi.service.StudioService;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@SpringBootApplication
public class OutseraApiApplication implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private StudioService studioService;

	@Autowired
	private ProducerService producerService;


	public static void main(String[] args) {
		SpringApplication.run(OutseraApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("movielist.csv");
		Reader reader = new InputStreamReader(inputStream);

		CSVReader csvReader = new CSVReaderBuilder(reader)
				.withCSVParser(new CSVParserBuilder()
						.withSeparator(';')
						.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
						.build())
				.withSkipLines(1)
				.build();

		List<String[]> records = csvReader.readAll();

		for (String[] record : records) {
			String year = record[0];
			String title = record[1];
			String studios = record[2];
			String producers = record[3];
			String winner = record[4];

			Movie movie = movieRepository.save(new Movie(Integer.valueOf(year), title, winner));

			studioService.saveStudios(movie, studios);
			producerService.saveProducers(movie, producers);
		}

		csvReader.close();
	}
}
