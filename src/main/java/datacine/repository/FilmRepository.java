package datacine.repository;

import datacine.domain.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

    Boolean deleteById_film(int id);
}
