package dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import model.Reservation;

@Dao
public interface ReservationDao {

    @Insert
    public void insert(Reservation reservation);

}
