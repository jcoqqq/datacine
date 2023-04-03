package datacine.repository;

import datacine.domain.Acteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActeurRepository extends CrudRepository<Acteur, Integer> {

    @Override
    Optional<Acteur> findById(Integer integer);
}
