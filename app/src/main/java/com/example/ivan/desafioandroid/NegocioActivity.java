package com.example.ivan.desafioandroid;


import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NegocioActivity extends AppCompatActivity implements View.OnClickListener {
    TextView nombre, descripcion, organizacion, persona,
        valor;
    EditText textoFecha;
    Spinner estados;
    Button guardar, fecha;
    private int dia,mes,anno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negocio);
        nombre = (TextView) findViewById(R.id.nombreNegocio);
        descripcion = (TextView) findViewById(R.id.DescripcionNegocio);
        organizacion = (TextView) findViewById(R.id.orgNegocio);
        persona = (TextView) findViewById(R.id.PersonaNegocio);
        valor = (TextView) findViewById(R.id.ValorNegocio);
        textoFecha =(EditText) findViewById(R.id.FechaCierre);
        estados = (Spinner) findViewById(R.id.spinnerEstados);
        ArrayAdapter<CharSequence> estados_arr = ArrayAdapter.createFromResource
                (this, R.array.EstadosNegocio,android.R.layout.simple_spinner_item);
        estados.setAdapter(estados_arr);

        guardar = (Button) findViewById(R.id.botonNegocio);
        guardar.setOnClickListener(this);
        fecha = (Button) findViewById(R.id.buttonFecha);
        fecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == guardar)
        {
            if (nombre.getText().toString().isEmpty() ||
                    descripcion.getText().toString().isEmpty() ||
                    organizacion.getText().toString().isEmpty() ||
                    persona.getText().toString().isEmpty() ||
                    valor.getText().toString().isEmpty() ||
                    estados.getSelectedItem().toString().isEmpty() ||
                    textoFecha.getText().toString().isEmpty())
            {
                Toast.makeText(NegocioActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(NegocioActivity.this, "Listo!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v == fecha)
        {
            Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anno = calendar.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    textoFecha.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                }
            },dia,mes,anno);
            datePickerDialog.updateDate(anno,mes,dia);
            datePickerDialog.show();
        }
    }
}
