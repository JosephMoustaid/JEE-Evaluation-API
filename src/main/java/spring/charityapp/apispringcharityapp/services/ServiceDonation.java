package spring.charityapp.apispringcharityapp.services;

import org.springframework.stereotype.Service;
import spring.charityapp.apispringcharityapp.dto.DonDTO;
import spring.charityapp.apispringcharityapp.models.Donation;
import spring.charityapp.apispringcharityapp.repositories.DonationRepository;

@Service
public class ServiceDonation {

    private final DonationRepository donationRepository ;

    public ServiceDonation(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    //▪ ServiceDon : enregistrer un don, transformer une entité en DonDTO

    public Donation saveDon(Donation don){

        return  donationRepository.save(don);
    }

    public DonDTO mapDonationToDTO(Donation don){
        return new DonDTO(
            don.getCampagne().getNom() ,
            don.getNomDonateur() ,
            don.getMontant() ,
            don.getDate()
        );
    }
}
