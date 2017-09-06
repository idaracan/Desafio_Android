package com.example.ivan.desafioandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PersonasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        final TextView nombre = (TextView) findViewById(R.id.nombrePersona);
        final TextView telefono = (TextView) findViewById(R.id.telPersona);
        final TextView correo = (TextView) findViewById(R.id.mailPersona);
        Button guardar = (Button) findViewById(R.id.botonPersona);

        guardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (nombre.getText().toString().isEmpty() || telefono.getText().toString().isEmpty()
                        || correo.getText().toString().isEmpty())
                {
                    Toast.makeText(PersonasActivity.this,"Rellene todos los campos",Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(PersonasActivity.this,"Datos Guardados",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
