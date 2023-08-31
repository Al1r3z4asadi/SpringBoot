package de.c24.finacc.klt.Core.DomainService;


import de.c24.finacc.klt.Core.IAdapter.IExtenralForexCall;
import de.c24.finacc.klt.Persistance.RedisRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import de.c24.finacc.klt.Core.DomainObject.Currency;



@AllArgsConstructor
@Service
@Slf4j
public class CurrencyDomainService {
    private final IExtenralForexCall _forexcall;
    private final RedisRepository _redis ;


    private HashSet<Currency> GetListFromApi(){
        HashSet<Currency> data = _forexcall.getCurrencies() ;
        return  data ;
    }
    public BigDecimal convertCurrency(BigDecimal amount, BigDecimal exchangeRate) {
        return amount.multiply(exchangeRate);
    }

    public HashSet<Currency> getCurrencies() {
        return  this.GetListFromApi() ;
    }
}
