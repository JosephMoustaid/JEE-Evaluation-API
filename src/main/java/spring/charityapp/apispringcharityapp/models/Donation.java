package spring.charityapp.apispringcharityapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String nomDonateur;

    @Column(name="montant")
    @DecimalMin(value = "0.50", message = "Le montant minimum est 0.50€")
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
