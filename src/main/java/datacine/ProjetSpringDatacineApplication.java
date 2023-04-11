package datacine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;


@SpringBootApplication(scanBasePackages = {"datacine"})
@EnableJdbcRepositories
public class ProjetSpringDatacineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringDatacineApplication.class, args);

    }


    /*@Bean
    CommandLineRunner runner(RealisateurRepository realisateurRepository,
                             ActeurRepository acteurRepository,
                             AvisRepository avisRepository,
                             FilmRepository filmRepository) {
        return args -> {
            repository.save(new Adherent(null,"A","B",29));
            repository.save(new Adherent(null,"C","D",29));
            repository.save(new Adherent(null,"E","F",29));
        };
    }

    private String[] returnLigneCsv(String path) {
        try {
            Reader reader = new FileReader(path);
        }
        catch (Exception ignore) {}

    }*/
}
