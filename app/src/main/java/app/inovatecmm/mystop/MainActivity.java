package app.inovatecmm.mystop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Auth = FirebaseAuth.getInstance();
        if (Auth.getCurrentUser()!=null){
            Toast.makeText(this,"Usuario Logeado",Toast.LENGTH_SHORT).show();
            Intent i= new Intent(this, Dentro.class);
            startActivity(i);
        }

    }
    public void irRegistro(View view){
        Intent i= new Intent(this, RegistrarseActivity.class);
        startActivity(i);
    }

    public void irIniciosecion(View view){
        Intent i =new Intent(this, IniciarsecionActivity.class);
        startActivity(i);
    }
}