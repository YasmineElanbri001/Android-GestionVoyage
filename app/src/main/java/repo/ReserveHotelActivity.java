package repo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.emsi.applicationgv.R;


import model.Reservation;

public class ReserveHotelActivity extends AppCompatActivity {

    TextView reservation;
    EditText date, nbJours;
    Spinner roomType;

    String nomHotel;

    ReservationRepo reservationRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reserve_hotel);

        reservation = findViewById(R.id.titre_reservation);
        date = findViewById(R.id.date);
        nbJours = findViewById(R.id.nbjours);
        roomType = findViewById(R.id.roomType);

        reservationRepo = new ReservationRepo(this.getApplicationContext());

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nomHotel")) {
            nomHotel = intent.getStringExtra("nomHotel");
            String msg = "Réservation : " + nomHotel;
            reservation.setText(msg);
        }

    }

    public void Reserver(View view){
        if(date.getText().toString().isEmpty() || nbJours.getText().toString().isEmpty()){
            Toast.makeText(this, "Veuillez saisir toutes les informations !", Toast.LENGTH_SHORT).show();
        }else{
            Reservation reservation = new Reservation(nomHotel,date.getText().toString(),Integer.parseInt(nbJours.getText().toString()),roomType.getSelectedItem().toString());
            new Thread(() -> {
                reservationRepo.addReservation(reservation);

                // Affiche un message de succès sur le thread principal
                runOnUiThread(() -> {
                    Toast.makeText(this.getApplicationContext(), "Reservation effectué avec succès - MERCI", Toast.LENGTH_SHORT).show();
                });
            }).start();
        }
    }
    public void back(View view) {
        finish();
    }
}