package datacine.repository;

import datacine.domain.Avis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepository extends CrudRepository<Avis, Integer> {
}
