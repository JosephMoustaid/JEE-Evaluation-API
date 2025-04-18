package spring.charityapp.apispringcharityapp.services;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import spring.charityapp.apispringcharityapp.models.Campagne;
import spring.charityapp.apispringcharityapp.projections.CampagneResume;
import spring.charityapp.apispringcharityapp.repositories.CampagneRepository;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ServiceCampagneTest {

    @Mock
    private CampagneRepository campagneRepository;

    @InjectMocks
    private ServiceCampagne serviceCampagne;

    @Test
    void testGetActiveCampagnesResume() {


        // Test
        List<Campagne> result = serviceCampagne.getAllActiveCampagnes();

        // Verify
        assertEquals(1, result.size());
        assertEquals("Test", result.get(0).getNom());
    }
}