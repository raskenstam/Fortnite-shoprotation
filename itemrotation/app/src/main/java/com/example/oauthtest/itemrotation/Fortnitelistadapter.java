package com.example.oauthtest.itemrotation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
//list for fortnite dailys
public class Fortnitelistadapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itempic;


    public Fortnitelistadapter(Activity context, String[] itempic) {
        super(context, R.layout.fortnitelist, itempic);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itempic=itempic;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.fortnitelist, null,true);


        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView4);



        try
        {

            Picasso.get().load(itempic[position]).into(imageView);//statements that may cause an exception
        }
        catch (Exception e){

        }

        return rowView;

    };
}
