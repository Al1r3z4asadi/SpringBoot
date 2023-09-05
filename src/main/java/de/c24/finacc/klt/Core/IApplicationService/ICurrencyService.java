package de.c24.finacc.klt.Core.IApplicationService;
import de.c24.finacc.klt.API.rest.Models.Request.ConvertRequest;
import de.c24.finacc.klt.API.rest.Models.Response.ConvertResponse;
import de.c24.finacc.klt.Core.DomainObject.Currency;



import java.util.HashMap;
import java.util.HashSet;

public interface ICurrencyService {
    HashSet<Currency> getList();
    ConvertResponse convert(ConvertRequest convertRequest);
}
