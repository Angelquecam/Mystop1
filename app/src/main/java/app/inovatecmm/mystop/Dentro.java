package app.inovatecmm.mystop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Dentro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentro);
    }

    public void cerrarsecion(View view){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this,"se cerro la secion correctamente",Toast.LENGTH_SHORT).show();

        Intent i = new Intent (this, MainActivity.class);
        startActivity(i);
    }
}