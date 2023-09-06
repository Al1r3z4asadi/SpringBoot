package de.c24.finacc.klt.API.web.controller.DTOs;

import de.c24.finacc.klt.API.rest.Models.Response.ConvertResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConversionFormDTO {
    private BigDecimal amountFrom;
    private String currencyFrom;
    private BigDecimal amountTo;
    private String currencyTo;

    public static ConversionFormDTO ToForm(ConvertResponse to) {
        ConversionFormDTO form = new ConversionFormDTO() ;
        form.amountFrom = to.getFromAmount() ;
        form.amountTo = to.getToAmount() ;
        form.currencyFrom = to.getFromName() ;
        form.currencyTo = to.getToName() ;
        return form ;
    }
}
