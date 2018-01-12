package fr.aston.guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.aston.guide.models.Hotel;
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
            final boolean isRestaurant = getIntent().getExtras().getBoolean("isRestaurant");

            if(isRestaurant){
                textViewTitle.setText("Les Restaurants");
                //final permet de dire qu'une variable n'est pas modifiable
                final List<Restaurant> restaurantList = new ArrayList<>();
                restaurantList.add(new Restaurant("KFC",
                        "traditionnel",
                        "info@macdo.fr",
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
                restaurantList.add(new Restaurant("Burger king",
                        "Fast Food",
                        "info@burgerking.fr",
                        "0123423242",
                        "https://www.burgerking.fr/",
                        "https://pbs.twimg.com/profile_images/936003791312191488/gcvNpwi2_400x400.jpg"
                ));

                //permet d'afficher les ligne
               listViewData.setAdapter(new RestaurantAdapter(ListingActivity.this, R.layout.item_restaurant, restaurantList));

               //onCLick valable que pour les liste
               listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                       //instenciation d'un object contenant la valeur du titre (donnée allant de listingActivity a detailActivity)
                       Intent intent = new Intent(ListingActivity.this, DetailActivity.class);

                       //envoyer des types simple
                       intent.putExtra("name", restaurantList.get(position).getName());
                       intent.putExtra("category", restaurantList.get(position).getCategory());

                      //envoyer un object en ajoutant "implement Serialize" dans l'object
                       intent.putExtra("object", restaurantList.get(position));
                       intent.putExtra("isRestaurant", isRestaurant);

                       startActivity(intent);
                   }
               });

            }else{
                textViewTitle.setText("Les Hôtels");
                final List<Hotel> hotelList = new ArrayList<>();
                hotelList.add(new Hotel("Novotel",
                        "traditionnel",
                        "info@macdo.fr",
                        "0123423242",
                        "http://www.kfc.fr",
                        "https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/KFC_logo.svg/1200px-KFC_logo.svg.png"
                ));
                hotelList.add(new Hotel("Formule1",
                        "Fast Food",
                        "info@kfc.fr",
                        "0123423242",
                        "https://www.mcdonalds.fr/",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Mcdonalds-90s-logo.svg/220px-Mcdonalds-90s-logo.svg.png"
                ));
                hotelList.add(new Hotel("Burger king",
                        "Fast Food",
                        "info@burgerking.fr",
                        "0123423242",
                        "https://www.burgerking.fr/",
                        "https://pbs.twimg.com/profile_images/936003791312191488/gcvNpwi2_400x400.jpg"
                ));

                //permet d'afficher les ligne
                listViewData.setAdapter(new HotelAdapter(ListingActivity.this, R.layout.item_hotel, hotelList));

                //onCLick valable que pour les liste
                listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        //instenciation d'un object contenant la valeur du titre (donnée allant de listingActivity a detailActivity)
                        Intent intent = new Intent(ListingActivity.this, DetailActivity.class);

                        //envoyer un object en ajoutant "implement Serialize" dans l'object
                        intent.putExtra("object", hotelList.get(position));
                        intent.putExtra("isRestaurant", isRestaurant);

                        startActivity(intent);
                    }
                });

            }
        }
    }

}
