package fr.aston.guide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.aston.guide.models.Restaurant;

public class ListingActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private ListView listViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        textViewTitle = findViewById(R.id.textViewTitle);
        listViewData = findViewById(R.id.listViewData);

        //si un paramettre a été envoyer
        //getIntent().getExtrat() permet de recuperé les parametre envoyer
        if(getIntent().getExtras() != null){
            //recupere le boolean recu
            boolean isRestaurant = getIntent().getExtras().getBoolean("isRestaurant");

            if(isRestaurant){
                textViewTitle.setText("Les Restaurants");
                List<Restaurant> restaurantList = new ArrayList<>();
                restaurantList.add(new Restaurant("KFC",
                        "traditionnel",
                        "info@kfc.fr",
                        "0123423242",
                        "http://www.kfc.fr",
                        "https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/KFC_logo.svg/1200px-KFC_logo.svg.png"
                ));
                restaurantList.add(new Restaurant("Mac Do",
                        "Fast Food",
                        "info@kfc.fr",
                        "0123423242",
                        "https://www.mcdonalds.fr/",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Mcdonalds-90s-logo.svg/220px-Mcdonalds-90s-logo.svg.png"
                ));

            }else{
                textViewTitle.setText("Les Hôtels");
            }
        }
    }
}
