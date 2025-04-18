package spring.charityapp.apispringcharityapp.repositories;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.charityapp.apispringcharityapp.models.Campagne;

@Repository
public interface CampagneRepository extends JpaRepository<Campagne, Integer> {

    Campagne findById(int id );

}
