package repo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.emsi.applicationgv.R;
import java.util.ArrayList;
import java.util.List;

import model.Vol;

public class RechercheVoyageActivity extends AppCompatActivity {
         EditText destinationEditText;
         EditText dateEditText;
         Button searchButton;

         ListView resultat;

         VolRepo volRepo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recherche_voyage);

            destinationEditText = findViewById(R.id.destinationEditText);
            dateEditText = findViewById(R.id.dateEditText);
            searchButton = findViewById(R.id.searchButton);
            resultat = findViewById(R.id.listvols);

            volRepo = new VolRepo(this.getApplicationContext());

            new Thread(() -> {
                volRepo.initialiser();
                volRepo.addVol(new Vol("Royal Air Maroc", "00A1", "Casablanca","Canada","12:00","21:00","13/05/2024"));
                volRepo.addVol(new Vol("Royal Air Maroc", "00A2", "Casablanca","USA","13:00","21:00","13/05/2024"));
                volRepo.addVol(new Vol("Royal Air Maroc", "00A3", "Casablanca","France","09:00","00:00","13/05/2024"));
                volRepo.addVol(new Vol("Air Arabia Maroc", "00A4", "Marrakech","Suisse","10:00","16:00","13/05/2024"));
                volRepo.addVol(new Vol("Air Arabia Maroc", "00A5", "Marrakech","Canada","12:00","23:00","13/05/2024"));
                volRepo.addVol(new Vol("Air Arabia Maroc", "00A6", "Marrakech","USA","12:00","21:00","13/05/2024"));
                volRepo.addVol(new Vol("Air Arabia Maroc", "00A7", "Marrakech","France","11:00","21:00","13/05/2024"));
                volRepo.addVol(new Vol("Dalia Air", "00A8", "Fes","Canada","12:00","18:00","13/05/2024"));
                volRepo.addVol(new Vol("Dalia Air", "00A9", "Fes","USA","12:00","21:00","13/05/2024"));
                volRepo.addVol(new Vol("Dalia Air", "00B1", "Fes","Suisse","12:00","21:00","13/05/2024"));
            }).start();

            searchButton.setOnClickListener(v -> {
                String destination = destinationEditText.getText().toString();
                String date = dateEditText.getText().toString();

                new Thread(() -> {
                    List<Vol> listVol = volRepo.vol_existe(destination, date);
                    runOnUiThread(() -> {
                        if (listVol.isEmpty()) {
                            Toast.makeText(this, "Aucun vol trouvé pour ces critères.", Toast.LENGTH_SHORT).show();
                        } else {
                            ArrayList<Vol> volList = new ArrayList<>(listVol);
                            VolAdapter adapter = new VolAdapter(this, volList);
                            resultat.setAdapter(adapter);
                        }
                    });
                }).start();
            });
        }

    public void back(View view) {
        finish();
    }
    }


