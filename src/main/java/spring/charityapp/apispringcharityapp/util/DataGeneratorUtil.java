package spring.charityapp.apispringcharityapp.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import spring.charityapp.apispringcharityapp.models.Campagne;
import spring.charityapp.apispringcharityapp.models.Donation;
import spring.charityapp.apispringcharityapp.repositories.CampagneRepository;
import spring.charityapp.apispringcharityapp.repositories.DonationRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class DataGeneratorUtil {

    private final CampagneRepository campagneRepository;
    private final DonationRepository donationRepository;
    private static final Random random = new Random();

    public DataGeneratorUtil(CampagneRepository campagneRepository,
                                   DonationRepository donationRepository) {
        this.campagneRepository = campagneRepository;
        this.donationRepository = donationRepository;
    }

    @PostConstruct
    public void init() {
        if (shouldGenerateData()) {
            generateTestData();
        }
    }

    private boolean shouldGenerateData() {
        // Only generate data if no campaigns exist (safety check)
        return campagneRepository.count() == 0;
    }

    public void generateTestData() {
        // 1. Create sample campaigns with PostgreSQL-friendly data
        List<Campagne> campagnes = Arrays.asList(
                createCampagne("Aide aux sans-abris", 10000.0f, 30, 30),
                createCampagne("Éducation pour tous", 50000.0f, 15, 60),
                createCampagne("Protection des animaux", 20000.0f, 10, 20)
        );

        campagneRepository.saveAll(campagnes);

        // 2. Generate donations with realistic distributions
        List<String> donorNames = Arrays.asList(
                "Jean Dupont", "Marie Martin", "Pierre Durand",
                "Sophie Lambert", "Lucie Petit", "Thomas Moreau"
        );

        for (int i = 0; i < 50; i++) {
            donationRepository.save(createRandomDonation(
                    campagnes.get(random.nextInt(campagnes.size())), donorNames.get(random.nextInt(donorNames.size()))
            ));
        }
    }

    private Campagne createCampagne(String name, float target, int daysPast, int daysFuture) {
        return new Campagne(
                name,
                target,
                toDate(LocalDate.now().minusDays(daysPast)),
                toDate(LocalDate.now().plusDays(daysFuture))
        );
    }

    private Donation createRandomDonation(Campagne campagne, String donorName) {
        return new Donation(
                campagne,
                donorName,
                5.0f + random.nextFloat() * 495, // €5-500 range
                toDate(LocalDate.now().minusDays(random.nextInt(30)))
        );
    }

    private Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}