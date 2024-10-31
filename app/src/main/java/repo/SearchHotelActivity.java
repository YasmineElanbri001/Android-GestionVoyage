package repo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.emsi.applicationgv.R;
import java.util.ArrayList;
import java.util.List;

import model.Hotel;

public class SearchHotelActivity extends AppCompatActivity {

    ArrayList<Hotel> hotelList;
    EditText ville;
    Spinner starts;

    HotelRepo hotelRepo;
    ListView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_hotel);

        ville = findViewById(R.id.ville);
        starts = findViewById(R.id.spinnerRoomStart);
        resultat = findViewById(R.id.listhotels);

        hotelRepo = new HotelRepo(this.getApplicationContext());

        new Thread(() -> {
            hotelRepo.initialiser();
            hotelRepo.addHotel(new Hotel("Hôtel A", "Marrakech", 4));
            hotelRepo.addHotel(new Hotel("Hôtel B", "Marrakech", 5));
            hotelRepo.addHotel(new Hotel("Hôtel C", "Rabat", 3));
            hotelRepo.addHotel(new Hotel("Hôtel D", "Casablanca", 4));
            hotelRepo.addHotel(new Hotel("Hôtel E", "Meknes", 4));
            hotelRepo.addHotel(new Hotel("Hôtel F", "Rabat", 3));
            hotelRepo.addHotel(new Hotel("Hôtel G", "Tanger", 2));
            hotelRepo.addHotel(new Hotel("Hôtel H", "Rabat", 3));
            hotelRepo.addHotel(new Hotel("Hôtel I", "Oujda", 4));
            hotelRepo.addHotel(new Hotel("Hôtel J", "Oujda", 5));
        }).start();
    }

    public void back(View view) {
        finish();
    }

    public void searchHotels(View view) {
        String city = ville.getText().toString();
        String stars = starts.getSelectedItem().toString();

        new Thread(() -> {
            List<Hotel> listHotel = hotelRepo.hotel_existe(city,Integer.parseInt(stars));
            runOnUiThread(() -> {
                if (listHotel.isEmpty()) {
                    Toast.makeText(this, "Aucun hôtel trouvé pour ces critères.", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayList<Hotel> hotelList = new ArrayList<>(listHotel);
                    HotelAdapter adapter = new HotelAdapter(this, hotelList);
                    resultat.setAdapter(adapter);
                }
            });
        }).start();
    }
}