package repo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.emsi.applicationgv.R;

public class HomeActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_home);

            TextView bienvenue = findViewById(R.id.user);
            Button searchHotel = findViewById(R.id.searchHotel);
            Button searchVol = findViewById(R.id.searchVoyage);

            Intent intent = getIntent();
            if (intent != null && intent.hasExtra("user")) {
                String msg = "Bienvenue " + intent.getStringExtra("user");
                bienvenue.setText(msg);
            }


            searchVol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent volIntent = new Intent(HomeActivity.this, RechercheVoyageActivity.class);
                    startActivity(volIntent);
                }
            });

            TextView btnDeconnexion = findViewById(R.id.deconnecte);
            btnDeconnexion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }

        public void searchHotel(View view) {
            Intent hotelIntent = new Intent(HomeActivity.this, SearchHotelActivity.class);
            startActivity(hotelIntent);
        }
}

