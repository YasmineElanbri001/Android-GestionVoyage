package repo;

import android.content.Context;
import androidx.room.Room;
import dao.AppDatabase;
import dao.UserDao;
import model.User;

public class UserRepo {
    private AppDatabase appDatabase;
    private UserDao userDao;

    public UserRepo(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "utilisateurs").build();
        userDao = appDatabase.userDao();
    }

    public void addUser(User user) {
        userDao.insert(user);
    }

    public User user_existe(String email, String pwd){
        return userDao.existe(email,pwd);
    }

}
