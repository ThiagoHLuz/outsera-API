package com.film.outseraapi.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AwardsIntervalDTO {

    private List<ProducerPrizesDTO> min = new ArrayList<>();

    private List<ProducerPrizesDTO> max = new ArrayList<>();

    public AwardsIntervalDTO() {}

    public AwardsIntervalDTO(LinkedList<ProducerPrizesDTO> lista) {
        this.min.add(lista.getFirst());
        this.max.add(lista.getLast());
    }

    public List<ProducerPrizesDTO> getMin() {
        return min;
    }

    public void setMin(List<ProducerPrizesDTO> min) {
        this.min = min;
    }

    public List<ProducerPrizesDTO> getMax() {
        return max;
    }

    public void setMax(List<ProducerPrizesDTO> max) {
        this.max = max;
    }

    public void addMin(ProducerPrizesDTO min) {
        this.getMin().add(min);
    }

    public void addMax(ProducerPrizesDTO max) {
        this.getMax().add(max);
    }
}
