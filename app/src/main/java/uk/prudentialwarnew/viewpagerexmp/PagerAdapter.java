package uk.prudentialwarnew.viewpagerexmp;

/**
 * Created by user on 8/13/2016.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
public class PagerAdapter extends FragmentPagerAdapter {
    Context context;

    public PagerAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        context = ctx;
    }

    private Fragment f = null;

    @Override
    public Fragment getItem(int position) { // Returns Fragment based on position
        switch (position) {
            case 0:
                f = new FragmentPageOne();
                break;
            case 1:
                f = new FragmentPageTwo();
                break;
            case 2:
                f = new FragmentPage3();
                break;
            case 3:
                f = new FragmentPage4();
                break;
            case 4:
                f = new FragmentPage5();
                break;
            case 5:
                f = new FragmentPage6();
                break;
        }
        return f;
    }

    @Override
    public int getCount() { // Return the number of pages
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) { // Set the tab text
        if (position == 0) {
            return "fragment 1";
        }
        if (position == 1) {
            return "fragment 2";
        }
        if (position == 2) {
            return "fragment 3";
        }
        if (position == 3) {
            return "fragment 4";
        }
        if (position == 4) {
            return "fragment 5";
        }
        if (position == 5) {
            return "fragment 6";
        }

        return getPageTitle(position);
    }
}
