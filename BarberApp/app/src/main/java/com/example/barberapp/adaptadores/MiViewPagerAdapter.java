package com.example.barberapp.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.barberapp.fragmentos.Fragmento1;
import com.example.barberapp.fragmentos.Fragmento2;
import com.example.barberapp.fragmentos.Fragmento3;
import com.example.barberapp.fragmentos.Fragmento4;

public class MiViewPagerAdapter extends FragmentStateAdapter {
    public MiViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Fragmento1();
            case 1:
                return new Fragmento2();
            case 2:
                return new Fragmento3();
            case 3:
                return new Fragmento4();
            default:
                return new Fragmento1();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
