package spring.charityapp.apispringcharityapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter @Setter @NoArgsConstructor
@Entity  // Add this annotation
@Table(name="donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Many To One
    @ManyToOne
    @JoinColumn(name = "campagne_id")
    private Campagne campagne;

    @Column(name="nom_donateur")
    private String nomDonateur;

    @Column(name="montant")
    private Float montant;

    @Column(name="date")
    private Date date;

    public Donation(Campagne compagne , String nomDonateur, Float montant, Date date) {
        this.campagne = compagne;
        this.nomDonateur = nomDonateur;
        this.montant = montant;
        this.date = date;
    }
}
