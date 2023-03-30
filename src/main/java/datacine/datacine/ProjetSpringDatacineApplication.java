package datacine.datacine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjetSpringDatacineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringDatacineApplication.class, args);

    }

}
