package com.saic.oscar.materialdesign;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Antonio on 27/06/2015.
 */
public class NavigationAdapter extends BaseAdapter {
    private Activity activity;
    ArrayList<ItemObject> arrayItms;

    public NavigationAdapter (Activity activity,ArrayList<ItemObject>arrayItms){
        super();
        this.activity=activity;
        this.arrayItms=arrayItms;
    }

    @Override
    public int getCount() {
        return arrayItms.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayItms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class Fila{
        TextView tituloItm;
        ImageView icono;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fila view;
        LayoutInflater inflator = activity.getLayoutInflater();
        if(convertView==null){
            view = new Fila();

            ItemObject itm = arrayItms.get(position);
            convertView = inflator.inflate(R.layout.itm,null);

            view.tituloItm = (TextView) convertView.findViewById(R.id.title_item);
            view.tituloItm.setText(itm.getTitulo());

            view.icono = (ImageView) convertView.findViewById(R.id.icon);
            view.icono.setImageResource(itm.getIcono());

        }
        else{
            view = (Fila) convertView.getTag();
        }

        return convertView;
    }

}
