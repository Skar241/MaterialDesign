package com.saic.oscar.materialdesign;

import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/*//Notas
* Material Design en api lv14+
* para buscar librerias compatibles con android studio se va a  Gradle Please.  y posteriormente se
* agrega en build.gradle(Module:app)
* paso 1:agregamos las librerias necesarias
* paso 2: creamos color.xml en donde declaramos los colores que usaremos para material design
* paso 3: los agregamos en styles.xml
* (opcional) podemos ir a http://www.materialpalette.com/
* y generar el material design, posteriormente descargamos como xml, lo abrimos y copiamos los colores
* en el archivo color.xml
* utilizamos la propiedad onclick para que se active el boton flotante
* */
public class MainActivity extends ActionBarActivity {

    private DrawerLayout navDrawerLayout;
    private ListView navList;
    private String[] titulos;
    private ArrayList<ItemObject> navItms;
    private TypedArray navIcons;
    NavigationAdapter navAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        navList = (ListView) findViewById(R.id.lista);
        //declaramos el header
        View header = getLayoutInflater().inflate(R.layout.header,null);
        navList.addHeaderView(header);

        navDrawerLayout.setDrawerListener(newToggle());
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        navIcons = getResources().obtainTypedArray(R.array.navigation_iconos);
        titulos = getResources().getStringArray(R.array.nav_options);
        navItms = new ArrayList<ItemObject>();

        for(int i=0;i<=6;i++)
            navItms.add(new ItemObject(titulos[i],navIcons.getResourceId(i,-1)));

        navAdapter = new NavigationAdapter(this,navItms);
        navList.setAdapter(navAdapter);
    }

    private ActionBarDrawerToggle newToggle(){
        return new ActionBarDrawerToggle(this,/*contexto donde se encuentra el navDrawer*/
                navDrawerLayout,              /*Drawer que linkearemos a la barra de acciones*/
                /*Falta toolbar*/
                R.string.app_name,            /*Descripcion al abrir open drawer*/
                R.string.hello_world          /*Descripcion al cerrar open drawer*/
        ){
            public void onDrawerClosed(View view){
                Log.e("Cerrado completo","aa");
            }

            public void onDrawerOpened(View drawerView){
                Log.e("Apertura completa","aa");
            }
        };
    }

}
