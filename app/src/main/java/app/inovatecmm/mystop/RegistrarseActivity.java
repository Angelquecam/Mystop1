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

public class RegistrarseActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText password;
    private EditText validarpassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.correo);
        password = findViewById(R.id.contrasena);
        validarpassword = findViewById(R.id.validarcontrasena);

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
public void registro(View view) {
    if (password.getText().toString().equals(validarpassword.getText().toString())) {
        mAuth.createUserWithEmailAndPassword(correo.getText().toString(),password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"cuenta registrada correctamente",Toast.LENGTH_SHORT).show();
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent i=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Falla al crear la cuenta",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }else{
        Toast.makeText(this,"las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
    }
}


}
