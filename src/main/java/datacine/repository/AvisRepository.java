package datacine.repository;

import datacine.domain.Avis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AvisRepository extends CrudRepository<Avis, Integer> {

    Boolean deleteAvisById_avis(int id);
}
