package com.example.ivan.desafioandroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ActividadesActivity extends AppCompatActivity implements View.OnClickListener {
    Button hora, guardar, fecha;
    private int dia,mes,anno,horadia,minutos;
    EditText horadeldia,textoFecha;
    TextView descripcion, tipo, organizacion,
            persona, negocio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        descripcion = (TextView) findViewById(R.id.NombreActividad);
        tipo = (TextView) findViewById(R.id.tipoActividad);
        organizacion = (TextView) findViewById(R.id.orgActividad);
        persona = (TextView) findViewById(R.id.personaActividad);
        negocio = (TextView) findViewById(R.id.NegocioActividad);
        horadeldia = (EditText) findViewById(R.id.textoHora);
        textoFecha = (EditText) findViewById(R.id.textoFecha);
        hora = (Button) findViewById(R.id.timepicker);
        hora.setOnClickListener(this);
        guardar = (Button) findViewById(R.id.botonActividad);
        guardar.setOnClickListener(this);
        fecha = (Button) findViewById(R.id.datepicker);
        fecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == hora) {
            final Calendar calendar = Calendar.getInstance();
            horadia = calendar.get(Calendar.HOUR_OF_DAY);
            minutos = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    horadeldia.setText(hourOfDay + ":" + minute);
                }
            }, horadia, minutos, false);
            timePickerDialog.show();
        }else if (v == fecha){
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anno = calendar.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    textoFecha.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                }
            },dia,mes,anno);
            datePickerDialog.show();
        }else if (v == guardar) {
            if (descripcion.getText().toString().isEmpty() ||
                    tipo.getText().toString().isEmpty() ||
                    organizacion.getText().toString().isEmpty() ||
                    persona.getText().toString().isEmpty() ||
                    negocio.getText().toString().isEmpty() ||
                    horadeldia.getText().toString().isEmpty() ||
                    textoFecha.getText().toString().isEmpty())
            {
                Toast.makeText(ActividadesActivity.this,"Rellene todos los campos",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(ActividadesActivity.this,"Listo!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
