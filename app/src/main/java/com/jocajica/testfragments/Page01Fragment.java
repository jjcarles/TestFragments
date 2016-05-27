package com.jocajica.testfragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by jcarles on 27/04/2016.
 */
public class Page01Fragment extends Fragment {

    public static final String TAG = "Page01Fragment";

    private TextView textView;
    private Button button;

    private FragmentIterationListener mCallback;

    public static Page01Fragment newInstance(Bundle arguments) {
        Page01Fragment f = new Page01Fragment();
        if (arguments != null) {
            f.setArguments(arguments);
        }
        return f;
    }

    public Page01Fragment() {
    }

    //El fragment se ha adjuntado al Activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mCallback = (FragmentIterationListener) activity;
        }catch(Exception ex){
            Log.e(TAG, "El Activity debe implementar la interfaz FragmentIterationListener");
        }
    }

    //El Fragment ha sido creado
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //El Fragment va a cargar su layout, el cual debemos especificar
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v =  inflater.inflate(R.layout.fragment_page01, container, false);
        if(v != null){
            textView = (TextView) v.findViewById(R.id.mytextview);
            button = (Button) v.findViewById(R.id.mybutton);
        }
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.OnFragmentIterationListener();
            }
        });

        textView.setText("Hola mundo");
        if(savedInstanceState !=null){
            textView.setText(savedInstanceState.getString("helloWorld"));
        }
    }

    //La vista ha sido creada y cualquier configuración guardada está cargada
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    //El Activity que contiene el Fragment ha terminado su creación
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true); //Indicamos que este Fragment tiene su propio menu de opciones
    }

    //El Fragment ha sido quitado de su Activity y ya no está disponible
    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

}
