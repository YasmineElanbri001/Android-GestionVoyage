package dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import model.Vol;

@Dao
public interface VolDao {

    @Insert
    public void insert(Vol vol);

    @Query("SELECT * FROM vol WHERE arrivee LIKE :destination AND date LIKE :date")
    List<Vol> getVols(String destination, String date);

    @Query("DELETE FROM vol")
    public void initialise();

}
