package fr.aston.guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void showRestaurant(View view) {
        Intent intenRestaurant = new Intent(HomeActivity.this, ListingActivity.class);
        //permet d'envoyer des donnée sous la forme d'une cléf
        intenRestaurant.putExtra("isRestaurant",true);
        startActivity(intenRestaurant);
    }

    public void showHotel(View view) {
        Intent intenRestaurant = new Intent(HomeActivity.this, ListingActivity.class);
        intenRestaurant.putExtra("isRestaurant",false);
        startActivity(intenRestaurant);
    }
}
