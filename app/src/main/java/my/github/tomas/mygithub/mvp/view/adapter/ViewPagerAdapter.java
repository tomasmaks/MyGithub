package my.github.tomas.mygithub.mvp.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import my.github.tomas.mygithub.mvp.view.fragment.RepositoriesFragment;

/**
 * Created by Tomas on 24/10/2016.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new RepositoriesFragment();
                break;
        }
        return frag;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Repositories";
                break;
        }
        return title;
    }
}
