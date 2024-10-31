package baseDonnee;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UtilisateurDBHelper extends SQLiteOpenHelper {

    private static final String nom_database = "Utilisateurs.db";
    public static final String nom_table="Utilisateur";
    public static final String nom_col_login="Nom_Utilisateur";
    public static final String nom_col_mp="motDePasse";
    public UtilisateurDBHelper(Context context) {
        super(context, nom_database, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create TABLE "+nom_table+" ("+nom_col_login+" Text primary key ,"+ nom_col_mp+" Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+nom_table);
        onCreate(db);
    }

    }
