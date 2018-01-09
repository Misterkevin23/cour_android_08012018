package fr.aston.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //afficher le template associé.
        setContentView(R.layout.activity_main);

        Log.e("toto", "message");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("state", "passage dans onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("state", "passage dans le OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("state", "passage dans le onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("state", "passage dans le onStop");
    }

    //tue le processus de la page dans le cas où on quitte la page
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("state", "passage dans le onDestroy");
    }
}
