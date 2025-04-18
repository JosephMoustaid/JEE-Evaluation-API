package spring.charityapp.apispringcharityapp.dto;

import java.util.Date;

public record DonDTO(
        int id ,
        String nomCampagne ,
        String nomDonateur ,
        Float montant,
        Date date
) {
}
