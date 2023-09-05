package de.c24.finacc.klt.Core.DomainService;

import de.c24.finacc.klt.Core.Common.utilize.Convertor;
import de.c24.finacc.klt.Core.DomainObject.Rates;
import de.c24.finacc.klt.Core.IAdapter.IExtenralForexCall;
import de.c24.finacc.klt.Persistance.RedisRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import de.c24.finacc.klt.Core.DomainObject.Currency;


@AllArgsConstructor
@Service
@Slf4j
public class CurrencyDomainService {
    private final IExtenralForexCall _forexcall;
    private final RedisRepository _redis ;
    private HashMap<String , BigDecimal> GetListFromApi(){
        HashMap<String , BigDecimal> data = _forexcall.getCurrencies() ;
        return  data ;
    }
    public BigDecimal convertCurrency(HashMap<String , BigDecimal> allCurrencies , Currency from , String to) {
        var fromAmount = allCurrencies.get(from.getName()) ;
        var toAmount = allCurrencies.get(to) ;
        return Convertor.Convert(from , fromAmount , toAmount) ;
    }
    public  HashMap<String , BigDecimal> getCurrencies() {
        Optional<Rates> rates = null;
        try {
            rates = _redis.findById("rates") ;
        }catch (Exception ex){
            //silent catch
            // if redis was not available log and warn but continue working
            return this.GetListFromApi();
        }
        if(!rates.isPresent()) {
            var data = this.GetListFromApi();
            var rate = new Rates(data) ;
            _redis.save(rate) ;
            return data ;
        }
        return rates.get().getRates();
    }
}
