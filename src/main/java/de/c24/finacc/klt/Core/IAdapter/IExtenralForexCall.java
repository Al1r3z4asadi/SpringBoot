package de.c24.finacc.klt.Core.IAdapter;

import de.c24.finacc.klt.Core.DomainObject.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface IExtenralForexCall {
    HashMap<String , BigDecimal> getCurrencies();
}
