package fr.aston.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCelsius, editTextFahrenheit;
    private Button buttonSave;
    private ListView listViewTemperature;

    //liste de string
    private List<String> stringList = new ArrayList<>();

    //ArrayAdapter permet de faire une correspondance entre la view  adaptable
    private ArrayAdapter<String> adapter;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.actionDelete:
                //TODO :effacer les 2 champs Celsuis/Fahrenheit
                editTextCelsius.setText("");
                //Autre façon de cleaner
                //editTextFahrenheit.getText().clear();
                editTextFahrenheit.setText("");
                //TODO : effacer les données de la listViewTemperature
                //Fonctionne mais pas propre
                //stringList.clear();
                //adapter.notifyDataSetChanged();

                //OU Ma methode pas propre
                //stringList.removeAll(stringList);
                //adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,stringList);
                //listViewTemperature.setAdapter(adapter);
                //adapter.notifyDataSetChanged(); //raffaichissement

                //OU Plus propre
                adapter.clear();




                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //declaration de la zone de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Utilise le fichier xml mon_menu pour l'envoyer dans la zone de menu prevu a cette effet
        getMenuInflater().inflate(R.menu.mon_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

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

        //ajout d'un ecouteur sur le bouton de sauvegarder
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ajouter des données dans la liste
                stringList.add(editTextCelsius.getText().toString()+"°C est égal à "+editTextFahrenheit.getText().toString()+"°F");

                adapter.notifyDataSetChanged(); //raffaichissement
            }
        });

        //Affichage de la ListViewTemperature
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,stringList);
        listViewTemperature.setAdapter(adapter);

        //Effacer les donnée en faisant un long click sur la donnée
        listViewTemperature.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO : effacer la ligne cliqué
                stringList.remove(i); //effacement de la donnée
                adapter.notifyDataSetChanged();//raffraichissement

                return false;
            }
        });


        //String[] items={editTextCelsius.getText().toString()+" = "+ editTextFahrenheit.getText().toString()};
        //listViewTemperature.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items));

    }
}
