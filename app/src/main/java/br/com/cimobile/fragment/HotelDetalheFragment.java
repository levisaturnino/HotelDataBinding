package br.com.cimobile.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.cimobile.fragment.databinding.FragmentDetalheHotelBinding;

/**
 * Created by saturnino on 28/04/2016.
 */
public class HotelDetalheFragment extends Fragment {

    public static final  String   TAG_DETALHE = "taDetalhe";
    private static final String EXTRA_HOTEL = "hotel";

    Hotel mHotel;
    FragmentDetalheHotelBinding binding;

    public static HotelDetalheFragment novaIntancia(Hotel hotel)
    {
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_HOTEL,hotel);

        HotelDetalheFragment fragment = new HotelDetalheFragment();
        fragment.setArguments(parametros);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHotel = (Hotel) getArguments().getSerializable(EXTRA_HOTEL);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detalhe_hotel,container,false);
        View view = binding.getRoot();

        if(mHotel != null)
        {
            binding.setHotel(mHotel);
        }

        return view;
    }
}
