package de.c24.finacc.klt.Core.IApplicationService;
import de.c24.finacc.klt.Core.DomainObject.Currency;



import java.util.HashMap;
import java.util.HashSet;

public interface ICurrencyService {
    HashSet<Currency> getList();
}
