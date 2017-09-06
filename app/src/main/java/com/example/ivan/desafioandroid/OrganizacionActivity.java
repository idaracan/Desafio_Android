package com.example.ivan.desafioandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OrganizacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizacion);

        final TextView nombre = (TextView) findViewById(R.id.nombreOrg);
        final TextView direccion = (TextView) findViewById(R.id.DireccionOrg);
        final TextView telefono = (TextView) findViewById(R.id.TelefonoOrg);
        Button guardar = (Button) findViewById(R.id.botonOrg);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().isEmpty()
                        || direccion.getText().toString().isEmpty()
                        || telefono.getText().toString().isEmpty())
                {
                    Toast.makeText(OrganizacionActivity.this,"Rellene todos los campos",Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(OrganizacionActivity.this,"Datos Guardados",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
