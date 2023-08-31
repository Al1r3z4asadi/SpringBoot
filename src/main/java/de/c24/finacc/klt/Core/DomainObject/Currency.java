package de.c24.finacc.klt.Core.DomainObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@RedisHash("Currency")
@Data
@AllArgsConstructor
public class Currency {
    @Id
    private String Name ;
    private BigDecimal Amount ;
}
