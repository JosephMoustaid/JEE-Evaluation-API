package spring.charityapp.apispringcharityapp.dto;

import java.util.Date;

public record DonDTO(
        String nomCampagne ,
        String nomDonateur ,
        Float montant,
        Date date
) {
}
