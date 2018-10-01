import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.chandigarhguide.AttractionsFragment;
import com.example.android.chandigarhguide.EventsFragment;
import com.example.android.chandigarhguide.PlacesFragment;
import com.example.android.chandigarhguide.RestaurentsFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"Attractions", "Restaurents", "PPlaces", "Events"};
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionsFragment();
        } else if (position == 1) {
            return new RestaurentsFragment();
        } else if (position == 2) {
            return new PlacesFragment();
        } else {
            return new EventsFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}