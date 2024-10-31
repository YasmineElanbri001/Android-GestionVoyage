package dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import model.User;

@Dao
public interface UserDao {

    @Insert
    public void insert(User user);

    @Query("SELECT * FROM user WHERE email LIKE :email AND " +
            "password LIKE :pwd")
    User existe(String email, String pwd);
}
