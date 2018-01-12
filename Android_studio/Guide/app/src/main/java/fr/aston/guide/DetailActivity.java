package fr.aston.guide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import fr.aston.guide.models.Hotel;
import fr.aston.guide.models.Restaurant;

public class DetailActivity extends AppCompatActivity {

    private TextView textViewDetailTitle;
    private TextView textViewDetailCategory;
    private Button buttonDetailTel;
    private Button buttonDetailEmail;
    private Button butttonDetailSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewDetailTitle = findViewById(R.id.textViewDetailTitle);
        textViewDetailCategory = findViewById(R.id.textViewDetailCategory);
        buttonDetailTel = findViewById(R.id.buttonDetailTel);
        buttonDetailEmail = findViewById(R.id.buttonDetailEmail);
        butttonDetailSite = findViewById(R.id.buttonDetailSite);

        if(getIntent().getExtras() != null){
            //recuperation des donnée envoyé par listing activity en type simple
            String title = getIntent().getExtras().getString("name");
            String categorie = getIntent().getExtras().getString("categorie");
            Boolean isRestaurant = getIntent().getExtras().getBoolean("isRestaurant");

            //récuperation des donnée envoyé par listing activity en object
            if(isRestaurant){
                Restaurant item = (Restaurant) getIntent().getExtras().get("object");
                textViewDetailTitle.setText(item.getName());
                textViewDetailCategory.setText(item.getCategory());
                buttonDetailTel.setText(item.getPhone());
                buttonDetailEmail.setText(item.getEmail());
                butttonDetailSite.setText(item.getUrl());
            }
            else{
                Hotel item = (Hotel) getIntent().getExtras().get("object");
                textViewDetailTitle.setText(item.getName());
                textViewDetailCategory.setText(item.getCategory());
                buttonDetailTel.setText(item.getPhone());
                buttonDetailEmail.setText(item.getEmail());
                butttonDetailSite.setText(item.getUrl());
            }


        }

    }
}
