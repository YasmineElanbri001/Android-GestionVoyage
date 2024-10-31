package model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Vol {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String compagnieAerienne;
    private String numeroVol;
    private String depart;
    private String arrivee;
    private String heureDepart;
    private String heureArrivee;

    private String date;

    public Vol(String compagnieAerienne, String numeroVol, String depart, String arrivee, String heureDepart, String heureArrivee, String date) {
        this.compagnieAerienne = compagnieAerienne;
        this.numeroVol = numeroVol;
        this.depart = depart;
        this.arrivee = arrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompagnieAerienne() {
        return compagnieAerienne;
    }

    public void setCompagnieAerienne(String compagnieAerienne) {
        this.compagnieAerienne = compagnieAerienne;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public String getDate() {return  date;}

    public void setDate(String date) { this.date = date;}

}


