package com.example.ejemplodemenu.ui.traductor;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejemplodemenu.R;

public class TraductorFragment extends Fragment {

    private TraductorViewModel mViewModel;


    public static TraductorFragment newInstance() {
        return new TraductorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel= new ViewModelProvider(this).get(TraductorViewModel.class);
        View vista= inflater.inflate(R.layout.traductor_fragment, container, false);
        Button btTraducir = vista.findViewById(R.id.btTraducir);
        EditText etTraducir = vista.findViewById(R.id.etPalabra);

        btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.hacerTraduccion(etTraducir.getText().toString());
            }
        });
        mViewModel.getPalTrad().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Bundle palabraTraducida = new Bundle();
                palabraTraducida.putString("traduccion", s);
                Navigation.findNavController(vista).navigate(R.id.traduccionFragment, palabraTraducida);
            }
        });
        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TraductorViewModel.class);
        // TODO: Use the ViewModel
    }
     public void inicializarVista(){


     }

}