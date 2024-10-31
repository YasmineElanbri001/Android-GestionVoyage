package dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import model.Hotel;
import model.Reservation;
import model.User;
import model.Vol;

@Database(entities = {User.class, Hotel.class, Vol.class, Reservation.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract HotelDao hotelDao();

    public abstract VolDao volDao();

    public abstract ReservationDao reservationDao();
}