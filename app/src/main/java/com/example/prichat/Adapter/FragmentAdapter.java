package com.example.prichat.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.prichat.Fragment.ChatsFragment;
import com.example.prichat.Fragment.StatusFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChatsFragment();
            case 1:
                return new StatusFragment();
            default:
                return new ChatsFragment();
        }
    }

    @Override
    public int getCount() {
        return 2 ;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position==0){
            title = "CHATS" ;
        }
        if(position==1){
            title = "STATUS" ;
        }

        return title;
    }
}
