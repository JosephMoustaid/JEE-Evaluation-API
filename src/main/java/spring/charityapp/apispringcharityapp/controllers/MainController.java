package spring.charityapp.apispringcharityapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.charityapp.apispringcharityapp.dto.DonDTO;
import spring.charityapp.apispringcharityapp.models.Campagne;
import spring.charityapp.apispringcharityapp.models.Donation;
import spring.charityapp.apispringcharityapp.services.ServiceCampagne;
import spring.charityapp.apispringcharityapp.services.ServiceDonation;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

    private final ServiceCampagne serviceCampagne;
    private final ServiceDonation serviceDonation;

    public MainController(ServiceCampagne serviceCampagne, ServiceDonation serviceDonation) {
        this.serviceCampagne = serviceCampagne;
        this.serviceDonation = serviceDonation;
    }

    @GetMapping("/campagnes/actives")
    public ResponseEntity<?> getActiveCampagnes() {
        return ResponseEntity.ok()
                .body(Map.of(
                        "status", "success",
                        "message", "campagnes retrieved successfully",
                        "data", serviceCampagne.getAllActiveCampagnes()
                ));
    }

    @PostMapping("/campagnes/{id}/dons")
    public DonDTO saveDon(
            @PathVariable int id,
            @RequestBody DonDTO donDTO) {

        // 1. Find the campagne by ID
        Campagne campagne = serviceCampagne.findById(id);

        // 2. Create and save the donation
        Donation donation = new Donation(
                campagne,
                donDTO.nomDonateur(),
                donDTO.montant(),
                new Date()
        );

        // 3. Save the donation
        Donation savedDonation = serviceDonation.saveDon(donation);
        // 4. Return the saved donation as DTO
        return serviceDonation.mapDonationToDTO(savedDonation);
    }



}