package app.inovatecmm.mystop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class IniciarsecionActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsecion);

        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.txt_correo);
        password = findViewById(R.id.text_contrasena);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        /*if(currentUser != null){
            reload();
        }*/
    }

public void iniciar(View view){
    mAuth.signInWithEmailAndPassword(correo.getText().toString(), password.getText().toString())
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(getApplicationContext(),"inicio de secion correcto",Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();

                        Intent i = new Intent(getApplicationContext(),Dentro.class);
                        startActivity(i);

                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
}


}