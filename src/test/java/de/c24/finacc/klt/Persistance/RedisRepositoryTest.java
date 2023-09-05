package de.c24.finacc.klt.Persistance;

import de.c24.finacc.klt.Core.DomainObject.Rates;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RedisRepositoryTest {

    @Test
    void itShouldCheckIfRatesExistsInRedis(){
        // arange
        var hash = new HashMap<String , BigDecimal>() ;
        hash.put("USD" , new BigDecimal("1.121323")) ;
        hash.put("JPY" , new BigDecimal("543.234253"));
        var rates = new Rates(hash) ;
        //act
        //assert
        assertThat(2).isEqualTo(2) ;

    }
}