package com.film.outseraapi.controller;

import com.film.outseraapi.dto.AwardsIntervalDTO;
import com.film.outseraapi.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/awards-interval")
    public ResponseEntity<AwardsIntervalDTO> getAwardsInterval() {
        AwardsIntervalDTO awardsIntervaldto = producerService.getMaxAndMinPrizes();

        HttpStatus status = HttpStatus.OK;
        if ( awardsIntervaldto.getMax().isEmpty() && awardsIntervaldto.getMin().isEmpty() ) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(awardsIntervaldto, status);
    }
}
