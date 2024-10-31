package repo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.emsi.applicationgv.R;
import com.google.android.material.textfield.TextInputEditText;

import model.User;



public class RegisterActivity extends AppCompatActivity {

    String userName;
    TextInputEditText username;
    String userEmail;
    TextInputEditText useremail;
    String mot_de_passe;
    TextInputEditText pwd;

    TextView back;

    UserRepo userRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.userName);
        useremail = findViewById(R.id.userEmail);
        pwd = findViewById(R.id.mot_de_passe);

        back = findViewById(R.id.back);

        userRepo = new UserRepo(this.getApplicationContext());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void creerUser(View view) {
        userName = username.getText() != null ? username.getText().toString() : "";
        userEmail = useremail.getText() != null ? useremail.getText().toString() : "";
        mot_de_passe = pwd.getText() != null ? pwd.getText().toString() : "";
        if(userEmail.isEmpty() || mot_de_passe.isEmpty() || userName.isEmpty()){
            Toast.makeText(this, "Veuillez saisir toutes les informations !", Toast.LENGTH_SHORT).show();
        }else{
            User user = new User(userName,userEmail,mot_de_passe);
            new Thread(() -> {
                userRepo.addUser(user);

                // Affiche un message de succès sur le thread principal
                runOnUiThread(() -> {
                    Toast.makeText(this.getApplicationContext(), "Utilisateur ajouté avec succès", Toast.LENGTH_SHORT).show();
                });
            }).start();

            Intent intent = new Intent( RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }


}