package dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import model.Hotel;

@Dao
public interface HotelDao {

    @Insert
    public void insert(Hotel hotel);

    @Query("SELECT * FROM hotel WHERE city LIKE :ville AND " + "stars LIKE :etoiles")
    List<Hotel> getHotels(String ville, int etoiles);

    @Query("DELETE FROM hotel")
    public void initialise();

}
