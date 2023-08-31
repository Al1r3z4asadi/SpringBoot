package de.c24.finacc.klt.ApplicationService;

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
        return _domainService.getCurrencies() ;
    }
}
