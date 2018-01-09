package fr.aston.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCelsius, editTextFahrenheit;
    private Button buttonSave;
    private ListView listViewTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius =findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        buttonSave = findViewById(R.id.buttonSave);
        listViewTemperature = findViewById(R.id.listViewTemperature);

        //editTextCelsius.setText("100");
        //ecouteur du champ Celsius
        editTextCelsius.addTextChangedListener(new TextWatcher() {
            //region before et onText (methode obligatoire)
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            //endregion
            @Override
            public void afterTextChanged(Editable editable) {
                String valeur = editable.toString(); // récuperation de la valeur
                if(!valeur.isEmpty() && TemperatureConverter.isNumeric(valeur) && editTextCelsius.isFocused()){
                    String resultat = TemperatureConverter.fahrenheitFromCelcius(Double.valueOf(valeur));
                    editTextFahrenheit.setText(resultat);  //mise a jour Fahrenheit
                }

            }
        });

        //ecouteur du champ Fahrenheit
        editTextFahrenheit.addTextChangedListener(new TextWatcher() {
            //region before et onText (methode obligatoire)
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            //endregion
            @Override
            public void afterTextChanged(Editable editable) {
                String valeur = editable.toString(); // récuperation de la valeur
                if(!valeur.isEmpty() && TemperatureConverter.isNumeric(valeur) && editTextFahrenheit.isFocused()){
                    String resultat = TemperatureConverter.celsiusFromFahrenheit(Double.valueOf(valeur));
                    editTextCelsius.setText(resultat);  //mise a jour Celsius
                }

            }
        });

    }
}
