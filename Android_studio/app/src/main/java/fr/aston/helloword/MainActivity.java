package fr.aston.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //afficher le template associé
        setContentView(R.layout.activity_main);

        Log.e("toto", "message");
    }
}
