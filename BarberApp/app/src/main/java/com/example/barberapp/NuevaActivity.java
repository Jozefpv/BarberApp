package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.barberapp.db.DbContactos;
import com.google.android.material.textfield.TextInputLayout;

public class NuevaActivity extends AppCompatActivity {
    private TextInputLayout campoCorreo;
    private TextInputLayout campoTelefono;
    private TextInputLayout campoNombre;
    private Button btnGuarda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);


        campoNombre = (TextInputLayout) findViewById(R.id.nombreControl);
        campoTelefono = (TextInputLayout) findViewById(R.id.telefonoControl);
        campoCorreo = (TextInputLayout) findViewById(R.id.correoControl);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(esCorreoValido(campoCorreo.getEditText().getText().toString()) && esNombreValido(campoNombre.getEditText().getText().toString()) && esTelefonoValido(campoTelefono.getEditText().getText().toString())) {

                    DbContactos dbContactos = new DbContactos(NuevaActivity.this);
                    long id = dbContactos.insertarContacto(campoNombre.getEditText().getText().toString(), campoTelefono.getEditText().getText().toString(), campoCorreo.getEditText().getText().toString());

                    if (id > 0) {
                        Toast.makeText(NuevaActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                        Intent intent = new Intent(view.getContext(), ReservasActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(NuevaActivity.this, "ERROR AL GUARDAR EL REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(NuevaActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean esNombreValido(String nombre){
        if (nombre.length()<1 || nombre.length()>20) {
            campoNombre.setError("Error al introducir el nombre");
            return false;
        } else {
            campoNombre.setError(null);
        }
        return true;
    }

    private boolean esCorreoValido(String correo) {
        // Patrón para validar el correo electrónico
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            campoCorreo.setError("Error al introducir el correo");
            return false;
        } else {
            campoCorreo.setError(null);
        }
        return true;
    }

    private boolean esTelefonoValido(String telefono){
        if (telefono.length()<9 || telefono.length()>9) {
            campoTelefono.setError("Error al introducir el telefono");
            return false;
        } else {
            campoTelefono.setError(null);
        }
        return true;
    }

    private void limpiar() {
        campoNombre.getEditText().setText("");
        campoTelefono.getEditText().setText("");
        campoCorreo.getEditText().setText("");
    }
}
