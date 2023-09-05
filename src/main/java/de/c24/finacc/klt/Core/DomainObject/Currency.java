package de.c24.finacc.klt.Core.DomainObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Currency {

    private String Name ;
    private BigDecimal Amount ;
    public static HashSet<Currency> ToEntity(HashMap<String , BigDecimal> rates){
        var result =  rates.entrySet()
                .stream()
                .map(entry -> new Currency(entry.getKey(), entry.getValue()))
                .collect(Collectors.toSet());
        return (HashSet<Currency>) result;
    }
}
