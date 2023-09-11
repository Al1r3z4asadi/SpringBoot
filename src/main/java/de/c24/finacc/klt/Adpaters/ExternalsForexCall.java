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
    public HashMap<String , BigDecimal> getCurrencies() {
        String forex = this.createUrl(forexUrl) ;
        System.out.println(forex);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = this._rest.getForEntity(forex, String.class).getBody() ;
            System.out.println("json is " ) ;
            System.out.println(json);

            var info = objectMapper.readValue(json, ExchangeRatesDTO.class);
            return info.getRates() ;
        }catch (Exception ex){
            System.out.println("fucking exceptin happens");
            //TODO: For now just a silent catch
	    ex.printStackTrace() ;
            // » Log for the adapter layer
        }
        return new  HashMap<String , BigDecimal>() ;
    }
}
