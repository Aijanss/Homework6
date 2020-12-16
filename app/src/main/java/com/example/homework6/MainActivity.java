package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements ButtonFragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragment=(Fragment2)getSupportFragmentManager().findFragmentById(R.id.fragment2);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new Fragment3());
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }
    @Override
    public void onHide() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        }



    @Override
    public void onShow() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        }

    @Override
    public void text(String text) {
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment2,Fragment2.newInstance(text,""));
        fragmentTransaction.commit();


    }
}


