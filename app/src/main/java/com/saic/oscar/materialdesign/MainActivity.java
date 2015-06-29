package com.saic.oscar.materialdesign;

import android.app.FragmentManager;
import android.content.res.TypedArray;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.saic.oscar.materialdesign.fragmentos.Home;
import com.saic.oscar.materialdesign.fragmentos.Perfil;

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
* Checar el archivo activity_main, toolbar, sombra
* */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout navDrawerLayout;
    private ListView navList;
    private String[] titulos;
    private ArrayList<ItemObject> navItms;
    private TypedArray navIcons;
    NavigationAdapter navAdapter;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        navDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        navList = (ListView) findViewById(R.id.lista);
        //declaramos el header
        View header = getLayoutInflater().inflate(R.layout.header,null);
        navList.addHeaderView(header);

        navDrawerLayout.setDrawerListener(newToggle());


        navIcons = getResources().obtainTypedArray(R.array.navigation_iconos);
        titulos = getResources().getStringArray(R.array.nav_options);
        navItms = new ArrayList<ItemObject>();

        for(int i=0;i<=7;i++)
            navItms.add(new ItemObject(titulos[i],navIcons.getResourceId(i,-1)));

        navAdapter = new NavigationAdapter(this,navItms);
        navList.setAdapter(navAdapter);
        navList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostrarFragmentPos(position);
            }

        });

        mostrarFragmentPos(1);
    }

    private ActionBarDrawerToggle newToggle(){
        return new ActionBarDrawerToggle(this,/*contexto donde se encuentra el navDrawer*/
                navDrawerLayout,              /*Drawer que linkearemos a la barra de acciones*/
                toolbar,
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

    private void mostrarFragmentPos(int position){
        Fragment fragment = null;

        switch (position){
            case 1:
                fragment = new Home();
                break;
            case 2:
                fragment = new Perfil();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Opción "+titulos[position-1]+" no disponible",Toast.LENGTH_SHORT).show();
                fragment = new Home();
                position=1;
                break;
        }

        if(fragment!=null){
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();

            navList.setItemChecked(position, true);
            navList.setSelection(position);

            setTitle(titulos[position - 1]);

            navDrawerLayout.closeDrawer(navList);
        }else{
            Log.e("Error","Mostrar fragment"+position);
        }

    }
}
