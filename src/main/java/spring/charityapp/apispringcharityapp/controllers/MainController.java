package spring.charityapp.apispringcharityapp.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class MainController {
// GET /api/campagnes/actives → Liste des campagnes actives (projection)

    @GetMapping("/campagnes/{id}/dons")
    public String getDonationsByCampagne(

    ){
        return "Donations";
    }
// POST /api/campagnes/{id}/dons → Enregistrer un don (reçoit unDonDTO)
}
