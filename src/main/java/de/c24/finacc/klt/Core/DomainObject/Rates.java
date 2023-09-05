package de.c24.finacc.klt.Core.DomainObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.util.HashMap;

@RedisHash("Rates")
@Data

public class Rates {
    @Id
    private String key = "rates";
    private HashMap<String, BigDecimal> rates;

    public Rates() {

    }

    public Rates(HashMap<String, BigDecimal> data) {
        rates = data ;
    }
}
