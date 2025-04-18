package spring.charityapp.apispringcharityapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "campagne")
public class Campagne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nom")
    private String nom;

    @Column(name="montant_objectif")
    private Float objectifMontant ;

    @Column(name="date_debut")
    private Date dateDebut ;

    @Column(name="date_fin")
    private Date dateFin ;

    public Campagne(String nom, Float objectifMontant, Date dateDebut, Date dateFin){
        this.nom = nom;
        this.objectifMontant = objectifMontant;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public boolean isActive(){
        Date current = new Date();
        if( current.after(dateDebut)  && current.before(dateFin)){
            return true;
        }
        return false;
    }
}
