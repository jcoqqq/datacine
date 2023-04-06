package datacine.repository;

import datacine.domain.Realisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RealisateurRepository extends CrudRepository<Realisateur, Integer> {

    Boolean deleteRealisateurById_realisateur(int id);
}
