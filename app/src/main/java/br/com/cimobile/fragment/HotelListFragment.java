package br.com.cimobile.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saturnino on 28/04/2016.
 */
public class HotelListFragment extends ListFragment {

    List<Hotel> mHotels;
    ArrayAdapter<Hotel> mAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mHotels = carregarHotels();

        mAdapter = new ArrayAdapter<Hotel>(getActivity(),android.R.layout.simple_list_item_1,mHotels);
        setListAdapter(mAdapter);
    }

    private List<Hotel> carregarHotels() {
        List<Hotel> hotels = new ArrayList<>();

        hotels.add(new Hotel("New Beach Hotel","Av. Boa Viagem",4.5f));
        hotels.add(new Hotel("Recife Hotel","Av. Boa Viagem",4.0f));
        hotels.add(new Hotel("Canario Hotel","Rua dos Navegantes",3.0f));
        hotels.add(new Hotel("Byanca Beach Hotel","Rua Mamanguape",3.0f));
        hotels.add(new Hotel("Canario Hotel","Rua dos Navegantes",4.0f));
        hotels.add(new Hotel("Grand Hotel Dor","Av. Bernardo",3.5f));
        hotels.add(new Hotel("Hotel Cool","Av. Conselheiro Aguiar",3.5f));
        hotels.add(new Hotel("Hotel Infinito","Rua Ribeiro d Brito",3.5f));
        hotels.add(new Hotel("Hotel Tulipa","Av. Boa Viagem",3.5f));

        return hotels;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();

        if(activity instanceof AoClicarNoHotel)
        {
            Hotel hotel =(Hotel) l.getItemAtPosition(position);
            AoClicarNoHotel listener = (AoClicarNoHotel) activity;
            listener.clicouNoHotel(hotel);
        }


    }

    public interface AoClicarNoHotel{
        void clicouNoHotel(Hotel hotel);
    }
}
