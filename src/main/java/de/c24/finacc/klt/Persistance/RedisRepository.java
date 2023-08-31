package de.c24.finacc.klt.Persistance;

import de.c24.finacc.klt.Core.DomainObject.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RedisRepository extends  CrudRepository<Currency, String> {
}
