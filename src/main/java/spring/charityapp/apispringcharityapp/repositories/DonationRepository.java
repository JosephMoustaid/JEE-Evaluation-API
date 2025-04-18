package spring.charityapp.apispringcharityapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.charityapp.apispringcharityapp.models.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
}
