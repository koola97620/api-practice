package com.exchangerate.jasonapiexam.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class ExchangeRate {
    private String remittanceCountry;   // 송금 국가
    private String currency;            // 수취 국가
    private Double exchangeRate;        // 환율

    @Max(value = 10000, message = "송금액이 바르지 않습니다")
    @PositiveOrZero(message = "송금액이 바르지 않습니다")
    @NotNull(message = "송금액이 바르지 않습니다")
    private Integer remittanceAmount;    // 송금액
}
