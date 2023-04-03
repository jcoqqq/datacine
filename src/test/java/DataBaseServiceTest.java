import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import datacine.repository.ActeurRepository;
import datacine.service.DataBaseService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

class DataBaseServiceTest {

    private DataBaseService dataBaseService;

    ActeurRepository acteurRepository;

    @BeforeEach
    void init() {
        acteurRepository = mock(ActeurRepository.class);

        dataBaseService = new DataBaseService(acteurRepository);
    }

    @Test
    void shouldRemplirActeur() {
        Boolean bo = dataBaseService.addActeur();

        assertThat(dataBaseService.addActeur()).isTrue();
    }
}
