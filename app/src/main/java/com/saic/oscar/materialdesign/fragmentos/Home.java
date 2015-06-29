package com.saic.oscar.materialdesign.fragmentos;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.saic.oscar.materialdesign.R;


public class Home extends Fragment {

    public Home(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FloatingActionButton derecha = (FloatingActionButton)getActivity().findViewById(R.id.pink);
        derecha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Boton flotante", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
