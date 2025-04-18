package spring.charityapp.apispringcharityapp.services;

import org.springframework.stereotype.Service;
import spring.charityapp.apispringcharityapp.models.Campagne;
import spring.charityapp.apispringcharityapp.repositories.CampagneRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCampagne {
    private final CampagneRepository campagneRepository;

    public ServiceCampagne(CampagneRepository campagneRepository) {
        this.campagneRepository = campagneRepository;
    }

    //récupérer les campagnes actives
    public List<Campagne> getAllActiveCampagnes(){
        List <Campagne> allCampagnes = campagneRepository.findAll();
        List<Campagne> activeCampagnes = new ArrayList<>();
        for(Campagne campagne : allCampagnes){
            if(campagne.isActive()){
                allCampagnes.add(campagne);
            }
        }

        return activeCampagnes;
    }

}
