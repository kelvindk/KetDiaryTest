package ubicomp.myapplication.ui;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import ubicomp.myapplication.MainActivity;
import ubicomp.myapplication.R;
import ubicomp.myapplication.fragments.FragmentEvent;
import ubicomp.myapplication.fragments.FragmentRanking;
import ubicomp.myapplication.fragments.FragmentResult;
import ubicomp.myapplication.fragments.FragmentTest;

/**
 * This class aggregate all manipulation of fragment switch.
 * Created by kelvindk on 16/6/6.
 */
public class FragmentSwitcher {
    public final static int FRAGMENT_TEST = 0;
    public final static int FRAGMENT_RESULT = 1;
    public final static int FRAGMENT_EVENT = 2;
    public final static int FRAGMENT_RANKING = 3;

    MainActivity mainActivity = null;
    TabLayoutWrapper tabLayoutWrapper = null;
    ToolbarMenuItemWrapper toolbarMenuItemWrapper = null;

    FragmentManager fragmentManager = null;
    Fragment[] fragments = {new FragmentTest(), new FragmentResult(),
            new FragmentEvent(), new FragmentRanking()};
    int currentFragment = 0;

    // Constructor received the references for fragment switch.
    public FragmentSwitcher(MainActivity mainActivity,
                            ToolbarMenuItemWrapper toolbarMenuItemWrapper,
                            TabLayoutWrapper tabLayoutWrapper) {
        this.mainActivity = mainActivity;
        this.tabLayoutWrapper = tabLayoutWrapper;
        this.toolbarMenuItemWrapper = toolbarMenuItemWrapper;

        fragmentManager = this.mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragments[0], "FragmentTest");
        fragmentTransaction.add(fragments[1], "FragmentResult");
        fragmentTransaction.add(fragments[2], "FragmentEvent");
        fragmentTransaction.add(fragments[3], "FragmentRanking");



//
//        Log.d("Ket", "fragment is empty "+ fragmentTransaction.isEmpty());
    }

    // Switch the fragment.
    public void setFragment(int fragmentToSwitch) {
        // Update which fragment we stay.
        this.currentFragment = fragmentToSwitch;

        // Bind tab and downdrop selection,
        // i.e., they will change together when one of them is selected.
        tabLayoutWrapper.setTabSelected(fragmentToSwitch);
        toolbarMenuItemWrapper.setSpinnerSelection(fragmentToSwitch);


        switch (fragmentToSwitch) {
            case FRAGMENT_TEST:
                toolbarMenuItemWrapper.inflate(this.mainActivity, R.menu.menu_test);
                break;
            case FRAGMENT_RESULT:
                toolbarMenuItemWrapper.inflate(this.mainActivity, R.menu.menu_result);
                break;
            case FRAGMENT_EVENT:
                toolbarMenuItemWrapper.inflate(this.mainActivity, R.menu.menu_event);
                // Refresh badge count of menu item on toolbar.
                toolbarMenuItemWrapper.refreshRemindBadgeCount();

                break;
            case FRAGMENT_RANKING:
                toolbarMenuItemWrapper.inflate(this.mainActivity, R.menu.menu_ranking);
                break;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragments[fragmentToSwitch]);
        fragmentTransaction.commit();
    }
}
