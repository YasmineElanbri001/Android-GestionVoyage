package repo;

import android.content.Context;
import androidx.room.Room;
import java.util.List;
import dao.AppDatabase;
import dao.VolDao;
import model.Vol;

public class VolRepo {
    private AppDatabase appDatabase;
    private VolDao volDao;

    public VolRepo(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "vols").build();
        volDao = appDatabase.volDao();
    }

    public void addVol(Vol vol) {
        volDao.insert(vol);
    }

    public List<Vol> vol_existe(String destination, String date){
        return volDao.getVols(destination, date);
    }

    public void initialiser(){
        volDao.initialise();
    }

}
