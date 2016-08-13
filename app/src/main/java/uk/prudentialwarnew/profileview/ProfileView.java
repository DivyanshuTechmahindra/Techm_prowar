package uk.prudentialwarnew.profileview;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import uk.prudentialwarnew.R;
import uk.prudentialwarnew.utils.floatingActionButtons.FloatingActionButton;
import uk.prudentialwarnew.utils.floatingActionButtons.FloatingActionsMenu;

/**
 * Created by user on 8/12/2016.
 */
public class ProfileView extends AppCompatActivity  implements AppBarLayout.OnOffsetChangedListener{
    public static FloatingActionsMenu menuMultipleActions;
    ImageView iv_connect;
    RelativeLayout rl_blurview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        rl_blurview = (RelativeLayout)findViewById(R.id.rl_blurview);
        rl_blurview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(menuMultipleActions.isExpanded()){
                    rl_blurview.setVisibility(View.GONE);
                    menuMultipleActions.collapse();
                }else{
                    rl_blurview.setVisibility(View.VISIBLE);
                    menuMultipleActions.expand();
                }
            }
        });
        iv_connect = (ImageView)findViewById(R.id.iv_connect) ;
        iv_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(menuMultipleActions.isExpanded()){
                    rl_blurview.setVisibility(View.GONE);
                    menuMultipleActions.collapse();
                }else{
                    rl_blurview.setVisibility(View.VISIBLE);
                    menuMultipleActions.expand();
                }
            }
        });
        setupToolbar();

        setupViewPager();

        setupCollapsingToolbar();

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(ProfileView.this);

        //##############################################################

        menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                rl_blurview.setVisibility(View.VISIBLE);
            }

            @Override
            public void onMenuCollapsed() {
                rl_blurview.setVisibility(View.GONE);
            }
        });
//        menuMultipleActions.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(menuMultipleActions.isExpanded()){
//                    rl_blurview.setVisibility(View.GONE);
//                    menuMultipleActions.collapse();
//                }else{
//                    rl_blurview.setVisibility(View.VISIBLE);
//                    menuMultipleActions.expand();
//                }
//
//            }
//        });



        final View action_screen_share = findViewById(R.id.action_screen_share);
        action_screen_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent postLoadDashBoardIntent = new Intent(CalandarSample.this, CustomerActivity.class);
//                CalandarSample.this.startActivity(postLoadDashBoardIntent);


                menuMultipleActions.collapse();
                rl_blurview.setVisibility(View.GONE);
            }
        });
        final View action_virtual_meeting = findViewById(R.id.action_virtual_meeting);
        action_virtual_meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, AnotherBarActivity.class);
//                CalandarSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
                rl_blurview.setVisibility(View.GONE);
            }
        });


        final FloatingActionButton action_chat = (FloatingActionButton) findViewById(R.id.action_chat);
        action_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, CustomerListActivityMain.class);
//                CalandarSampleSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
                rl_blurview.setVisibility(View.GONE);
            }
        });


        final FloatingActionButton action_mail = (FloatingActionButton) findViewById(R.id.action_mail);
        action_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, CustomerListActivityMain.class);
//                CalandarSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
                rl_blurview.setVisibility(View.GONE);
            }
        });


        final FloatingActionButton action_call = (FloatingActionButton) findViewById(R.id.action_call);
        action_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent postTruckIntent = new Intent(CalandarSample.this, CustomerListActivityMain.class);
//                CalandarSample.this.startActivity(postTruckIntent);
                menuMultipleActions.collapse();
                rl_blurview.setVisibility(View.GONE);
            }
        });
        //##############################################################
    }


    private void setupCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.collapse_toolbar);

        collapsingToolbar.setTitleEnabled(false);
       // collapsingToolbar.setTitle("Goodman Lucile");

    }

    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Fragment_portfolio(), "PORTFOLIO");
        adapter.addFrag(new Fragment_Notes(), "NOTES");
        adapter.addFrag(new Fragment_profileview(), "PROFILE");
        adapter.addFrag(new TabFragment(), "SOCIAL");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0)
        {
            // Collapsed
            getSupportActionBar().setTitle("");
        }

        else
        {
            // Not collapsed

            getSupportActionBar().setTitle("Goodman Lucile");
        }
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

