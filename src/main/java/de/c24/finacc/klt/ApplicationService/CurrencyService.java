package de.c24.finacc.klt.ApplicationService;

import de.c24.finacc.klt.API.rest.Models.Request.ConvertRequest;
import de.c24.finacc.klt.API.rest.Models.Response.ConvertResponse;
import de.c24.finacc.klt.Core.DomainService.CurrencyDomainService;
import de.c24.finacc.klt.Core.IApplicationService.ICurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import de.c24.finacc.klt.Core.DomainObject.Currency;


import java.util.HashSet;

@Service
@AllArgsConstructor
public class CurrencyService implements ICurrencyService {

    private final CurrencyDomainService _domainService ;
    @Override
    public HashSet<Currency> getList() {
        return   Currency.ToEntity(_domainService.getCurrencies() );
    }

    @Override
    public ConvertResponse convert(ConvertRequest convertRequest) {
        var allCurrencies = _domainService.getCurrencies() ;
        Currency from = new Currency(convertRequest.getFromName(), convertRequest.getFromAmount()) ;
        var result = _domainService.convertCurrency(allCurrencies , from , convertRequest.getToName()) ;
        return ConvertResponse.toResponse(new Currency(from.getName() , from.getAmount()) ,
                                    new Currency(convertRequest.getToName() , result)) ;
    }
}
