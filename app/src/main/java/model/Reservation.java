package model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Reservation {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public Reservation(String hotel, String date, int nbJours, String type_chambre) {
        this.date = date;
        this.nbJours = nbJours;
        this.type_chambre = type_chambre;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getNbJours() {
        return nbJours;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    private String date;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    private int nbJours;
    private String type_chambre;

    private String hotel;

}
