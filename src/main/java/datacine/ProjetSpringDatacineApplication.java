package datacine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"datacine"})
public class ProjetSpringDatacineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringDatacineApplication.class, args);

    }

}
