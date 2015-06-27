package com.saic.oscar.materialdesign;

/**
 * Created by Antonio on 26/06/2015.
 */
public class ItemObject {
    private String titulo;
    private int icono;

    public ItemObject(String titulo,int icono){
        this.titulo=titulo;
        this.icono=icono;
    }

    public String getTitulo(){

        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public int getIcono(){
        return icono;
    }

    public void setIcono(int icono){
        this.icono=icono;
    }
}
