package com.example.ejemplodemenu.ui.traductor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TraductorViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<String> palTrad;

    public LiveData<String> getPalTrad() {
        if(palTrad==null) {
            palTrad= new MutableLiveData<>();

        }
        return palTrad;
    }

    public void hacerTraduccion(String palEsp){
        //hola-->hello // casa->house
        if(palEsp.equalsIgnoreCase("hola")){
            palTrad.setValue("hello");
        } else if(palEsp.equalsIgnoreCase("casa")){
            palTrad.setValue("house");
        } else{
            palTrad.setValue("No se encuentra");
        }

    }

}