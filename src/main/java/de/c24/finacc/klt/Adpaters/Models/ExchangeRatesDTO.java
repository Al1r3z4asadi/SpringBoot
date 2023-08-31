package de.c24.finacc.klt.Adpaters.Models;

import de.c24.finacc.klt.Core.DomainObject.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Data
public class ExchangeRatesDTO {
    private String base;
    private HashMap<String, BigDecimal> rates;
    public static  HashSet<Currency> ToEntity(HashMap<String , BigDecimal> rates){
        HashSet<Currency> data = new HashSet<Currency>() ;
        for (Map.Entry<String, BigDecimal> entry : rates.entrySet()) {
            String key = entry.getKey();
            BigDecimal value = entry.getValue();
            data.add(new Currency(key , value)) ;
        }
        return data ;
    }

}
