package com.jocajica.testfragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity implements FragmentIterationListener{

    Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle onSaveInstanceState){
        super.onCreate(onSaveInstanceState);

        String id = "IdQueNecesitaMyFragment";
        Bundle arguments = new Bundle();
        arguments.putString("id", id);

        Page01Fragment fragment = Page01Fragment.newInstance(arguments);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(android.R.id.content, fragment, Page01Fragment.TAG);
        ft.commit();
        mCurrentFragment = fragment;
    }

    @Override
    public void OnFragmentIterationListener() {
        String id = "IdQueNecesitaMyFragment";
        Bundle arguments = new Bundle();
        arguments.putString("id", id);

        if (mCurrentFragment instanceof Page01Fragment) {
            Page02Fragment fragment = Page02Fragment.newInstance(arguments);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(android.R.id.content, fragment, Page02Fragment.TAG);
            ft.commit();
            mCurrentFragment = fragment;
        }
        else if (mCurrentFragment instanceof Page02Fragment) {
            Page01Fragment fragment = Page01Fragment.newInstance(arguments);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(android.R.id.content, fragment, Page01Fragment.TAG);
            ft.commit();
            mCurrentFragment = fragment;
        }
    }
}
