package de.c24.finacc.klt.Adpaters;

import de.c24.finacc.klt.Adpaters.Models.ExchangeRatesDTO;
import de.c24.finacc.klt.Core.DomainObject.Currency;
import de.c24.finacc.klt.Core.IAdapter.IExtenralForexCall;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class ExternalsForexCall implements IExtenralForexCall {
    private final RestTemplate _rest;
    @Value("${external.currencies.base-url}")
    private String baseUrl;
    @Value("${external.currencies.forex}")
    private String forexUrl  ;

    public ExternalsForexCall(RestTemplate restTemplate) {
        this._rest = restTemplate;
    }

    private String createUrl(String Url){
        StringBuilder c = new StringBuilder() ;
        c.append(baseUrl) ; c.append(Url) ;
        return c.toString() ;
    }

    @Override
    public HashSet<Currency> getCurrencies() {
        String forex = this.createUrl(forexUrl) ;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = this._rest.getForEntity(forex, String.class).getBody() ;
            var info = objectMapper.readValue(json, ExchangeRatesDTO.class);
            return ExchangeRatesDTO.ToEntity(info.getRates()) ;
        }catch (Exception ex){
            //TODO: For now just a silent catch
        }
        return new  HashSet<Currency>() ;
    }
}
