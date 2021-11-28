package com.exchangerate.jasonapiexam.ui;

import com.exchangerate.jasonapiexam.application.ExchangeRateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private ExchangeRateService exchangeRateService;

    HomeController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("exchangeRate", exchangeRateService.getExchangeRateByCurrency("KRW"));
        return "index";
    }
}
