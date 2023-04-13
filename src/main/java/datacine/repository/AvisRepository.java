package datacine.repository;

import datacine.domain.AvisFilm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepository extends CrudRepository<AvisFilm, Integer> {

    //Boolean deleteById(int id);
}
