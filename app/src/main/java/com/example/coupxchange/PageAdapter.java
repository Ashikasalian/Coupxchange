package com.example.coupxchange;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageAdapter extends FragmentStateAdapter {

    private String[] titles=new String[]{"Free","Recommended"};
    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new freetab1();
            case 1:
                return new rtab2();
        }
        return new rtab2();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
