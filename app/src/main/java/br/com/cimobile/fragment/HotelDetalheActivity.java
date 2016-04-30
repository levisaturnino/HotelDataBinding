package br.com.cimobile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class HotelDetalheActivity extends AppCompatActivity {

    public static final String  EXTRA_HOTEL = "hotel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detalhe);

        if(savedInstanceState == null)
        {
            Intent intent = getIntent();
            Hotel hotel = (Hotel) intent.getSerializableExtra(EXTRA_HOTEL);

            HotelDetalheFragment fragment = HotelDetalheFragment.novaIntancia(hotel);

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.detalhes,fragment,HotelDetalheFragment.TAG_DETALHE);
            ft.commit();
        }
    }
}
