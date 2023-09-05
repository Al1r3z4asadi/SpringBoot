package de.c24.finacc.klt.DomainServiceTest;

import de.c24.finacc.klt.Core.Common.utilize.Convertor;
import de.c24.finacc.klt.Core.DomainObject.Currency;
import de.c24.finacc.klt.Core.DomainService.CurrencyDomainService;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CurrencyDomainServiceTest {

    @Test
    public void ConverterShouldConvertCorrectly(){
        Currency Jpy = new Currency("JPY" , new BigDecimal(50)) ;
        var EuroJPY = new BigDecimal(128.522545) ;
        var EuroXOF = new BigDecimal(651.300911) ;
        var JPYXOF = Convertor.Convert(Jpy , EuroJPY , EuroXOF) ;
        assertThat(JPYXOF).isEqualTo(new BigDecimal("253.380153") ) ;
    }

}
