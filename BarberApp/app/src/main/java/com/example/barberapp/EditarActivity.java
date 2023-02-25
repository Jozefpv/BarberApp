package com.example.barberapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.barberapp.db.DbContactos;
import com.example.barberapp.entidades.Contactos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class EditarActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuarda;
    FloatingActionButton fabEditar, fabEliminar;
    boolean correcto = false;
    Contactos contacto;
    int id = 0;
    private TextInputLayout campoCorreo;
    private TextInputLayout campoTelefono;
    private TextInputLayout campoNombre;




    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        //txtNombre = findViewById(R.id.txtNombre);
        campoNombre = (TextInputLayout) findViewById(R.id.nombreControl);
        //txtTelefono = findViewById(R.id.txtTelefono);
        campoTelefono = (TextInputLayout) findViewById(R.id.telefonoControl);
        //txtCorreo = findViewById(R.id.txtCorreoElectronico);
        campoCorreo = (TextInputLayout) findViewById(R.id.correoControl);
        btnGuarda = findViewById(R.id.btnGuarda);
        fabEditar = findViewById(R.id.fabEditar);
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        fabEliminar.setVisibility(View.INVISIBLE);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        final DbContactos dbContactos = new DbContactos(EditarActivity.this);
        contacto = dbContactos.verContacto(id);

        if (contacto != null) {
            //txtNombre.setText(contacto.getNombre());
            campoNombre.getEditText().setText(contacto.getNombre());
            //txtTelefono.setText(contacto.getTelefono());
            campoTelefono.getEditText().setText(contacto.getTelefono());

            //txtCorreo.setText(contacto.getCorreo_electornico());
            campoCorreo.getEditText().setText(contacto.getCorreo_electornico());
        }

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esCorreoValido(campoCorreo.getEditText().getText().toString()) && esNombreValido(campoNombre.getEditText().getText().toString()) && esTelefonoValido(campoTelefono.getEditText().getText().toString()))  {
                    correcto = dbContactos.editarContacto(id, campoNombre.getEditText().getText().toString(), campoTelefono.getEditText().getText().toString(), campoCorreo.getEditText().getText().toString() );

                    if(correcto){
                        Toast.makeText(EditarActivity.this, "Registro modificado", Toast.LENGTH_LONG).show();
                        lista();
                    } else {
                        Toast.makeText(EditarActivity.this, "Registro erróneo", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EditarActivity.this, "Rellene los campos correctamente", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void lista(){
        Intent intent = new Intent(this, ReservasActivity.class);
        startActivity(intent);
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


}
