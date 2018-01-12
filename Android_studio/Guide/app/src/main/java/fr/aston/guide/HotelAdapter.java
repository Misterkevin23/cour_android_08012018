package fr.aston.guide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.aston.guide.models.Hotel;
import fr.aston.guide.models.Restaurant;

/**
 * Created by kevin on 12/01/2018.
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {

    private int resId;

    public HotelAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);

        resId = resource; //R.layout.item_restaurant
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resId, null);
        }

        //recuperation des deux textView
        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textViewCategory = convertView.findViewById(R.id.textViewCategory);

        //déclaration d'un object restaurant contenant les information du restaurant
        Hotel item=getItem(position);

        textViewTitle.setText(item.getName());
        textViewCategory.setText(item.getCategory());
        return convertView;
    }
}
