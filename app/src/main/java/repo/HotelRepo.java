package repo;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import dao.AppDatabase;
import dao.HotelDao;
import model.Hotel;

public class HotelRepo {
    private AppDatabase appDatabase;
    private HotelDao hotelDao;

    public HotelRepo(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "hotels").build();
        hotelDao = appDatabase.hotelDao();
    }

    public void addHotel(Hotel hotel) {
        hotelDao.insert(hotel);
    }

    public List<Hotel> hotel_existe(String ville, int etoiles){
        return hotelDao.getHotels(ville,etoiles);
    }

    public void initialiser(){
        hotelDao.initialise();
    }

}
