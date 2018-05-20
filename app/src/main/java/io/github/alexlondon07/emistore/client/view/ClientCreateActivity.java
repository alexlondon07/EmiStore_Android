package io.github.alexlondon07.emistore.client.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import io.github.alexlondon07.emistore.R;

public class ClientCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_create);

        loadView();

    }

    private void loadView() {

        loadSpinners();
    }

    /**
     * Funcion para cargar los Spinner de los campos Ciudades y Estados del Cliente
     */
    private void loadSpinners() {

        //Cities
        Spinner spinner = findViewById(R.id.cities_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Enables
        Spinner spinnerEnables = findViewById(R.id.enables_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.enables_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEnables.setAdapter(adapter2);
    }
}
