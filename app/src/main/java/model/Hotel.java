package model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Hotel {

        @PrimaryKey(autoGenerate = true)
        private int id;
        private String name;
        private String city;

        private int stars;


    public Hotel(String name, String city, int stars) {
        this.name = name;
        this.city = city;
        this.stars = stars;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getStars() {
        return stars;
    }

}


