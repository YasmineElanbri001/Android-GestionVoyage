package repo;

import android.content.Context;

import androidx.room.Room;
import dao.AppDatabase;
import dao.ReservationDao;
import model.Reservation;

public class ReservationRepo {
    private AppDatabase appDatabase;
    private ReservationDao reservationDao;

    public ReservationRepo(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "reservations").build();
        reservationDao = appDatabase.reservationDao();
    }

    public void addReservation(Reservation reservation) {
        reservationDao.insert(reservation);
    }

}
