package com.exchangerate.jasonapiexam.ui;

import com.exchangerate.jasonapiexam.application.ExchangeRateService;
import com.exchangerate.jasonapiexam.dto.ExchangeRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/api/exchangeRates")
public class ExchangeRateRestController {

    private ExchangeRateService exchangeRateService;

    public ExchangeRateRestController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public ResponseEntity<?> getExchangeRate(@RequestParam String currency) {
        try {
            return ResponseEntity.ok(exchangeRateService.getExchangeRateByCurrency(currency));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/receivedAmount")
    public ResponseEntity<?> getRemittanceAmount(@ModelAttribute @Valid ExchangeRate exchangeRateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            return ResponseEntity.ok(exchangeRateService.getRemittanceAmount(exchangeRateDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
