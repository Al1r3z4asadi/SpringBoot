package de.c24.finacc.klt.Adpaters.Models;

import de.c24.finacc.klt.Core.DomainObject.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class ExchangeRatesDTO {
    private String base;
    private HashMap<String, BigDecimal> rates;
    public static  HashSet<Currency> ToEntity(HashMap<String , BigDecimal> rates){
        var result =  rates.entrySet()
                .stream()
                .map(entry -> new Currency(entry.getKey(), entry.getValue()))
                .collect(Collectors.toSet());
        return (HashSet<Currency>) result;
    }

}
