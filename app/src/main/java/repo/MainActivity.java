package repo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.emsi.applicationgv.R;
import com.google.android.material.textfield.TextInputEditText;

import model.User;

public class MainActivity extends AppCompatActivity {

    String userEmail;
    TextInputEditText useremail;
    String mot_de_passe;
    TextInputEditText pwd;

    UserRepo userRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        useremail = findViewById(R.id.userEmail);
        pwd = findViewById(R.id.mot_de_passe);

        userRepo = new UserRepo(this.getApplicationContext());

    }

    public void inscrire(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void seConnecter(View view) {
        userEmail = useremail.getText() != null ? useremail.getText().toString() : "";
        mot_de_passe = pwd.getText() != null ? pwd.getText().toString() : "";
        if(userEmail.isEmpty() || mot_de_passe.isEmpty()){
            Toast.makeText(this, "Veuillez saisir le nom d'utilisateur et le mot de passe !", Toast.LENGTH_SHORT).show();
        }else{
            new Thread(() -> {
                User user = userRepo.user_existe(userEmail,mot_de_passe);
                runOnUiThread(() -> {
                    if (user == null) {
                        Toast.makeText(this.getApplicationContext(), "Informations incorrectes", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("user", user.getNom());
                        startActivity(intent);
                    }
                });
            }).start();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        useremail.setText("");
        pwd.setText("");

        useremail.clearFocus();
        pwd.clearFocus();
    }

}



