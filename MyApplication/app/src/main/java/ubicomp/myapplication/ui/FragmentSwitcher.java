package ubicomp.myapplication.ui;

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

    // FragmentManager is used to manage fragment.
    FragmentManager fragmentManager = null;
    Fragment[] fragments = new Fragment[4];
    int currentFragment = 0;

    // Constructor received the references for fragment switch.
    public FragmentSwitcher(MainActivity mainActivity,
                            ToolbarMenuItemWrapper toolbarMenuItemWrapper,
                            TabLayoutWrapper tabLayoutWrapper) {
        this.mainActivity = mainActivity;
        this.tabLayoutWrapper = tabLayoutWrapper;
        this.toolbarMenuItemWrapper = toolbarMenuItemWrapper;

        // Create four fragment.
        fragments[0] = new FragmentTest(this);
        fragments[1] = new FragmentResult(this);
        fragments[2] = new FragmentEvent(this);
        fragments[3] = new FragmentRanking(this);

        fragmentManager = this.mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragments[0], ""+FRAGMENT_TEST);
        fragmentTransaction.add(R.id.fragment_container, fragments[1], ""+FRAGMENT_RESULT);
        fragmentTransaction.add(R.id.fragment_container, fragments[2], ""+FRAGMENT_EVENT);
        fragmentTransaction.add(R.id.fragment_container, fragments[3], ""+FRAGMENT_RANKING);

        // Show FragmentTest a first page.
        fragmentTransaction.replace(R.id.fragment_container, fragments[0]);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void setFragmentOnlyDowndropTab(int fragmentToSwitch) {
        tabLayoutWrapper.setTabSelected(fragmentToSwitch);
        toolbarMenuItemWrapper.setSpinnerSelection(fragmentToSwitch);
    }


    // Switch the fragment.
    public void setFragment(int fragmentToSwitch) {

        // Return if attempt to go the same fragment.
        if(fragmentToSwitch == this.currentFragment)
            return;

        // Switch fragment to selected page.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.hide(fragments[this.currentFragment]);
//        if(!fragments[fragmentToSwitch].isAdded())
//            fragmentTransaction.add(R.id.fragment_container, fragments[fragmentToSwitch], ""+fragmentToSwitch);
//        fragmentTransaction.show(fragments[fragmentToSwitch]);
        fragmentTransaction.replace(R.id.fragment_container, fragments[fragmentToSwitch]);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        // Bind tab and downdrop selection,
        // i.e., they will change together when one of them is selected.
        tabLayoutWrapper.setTabSelected(fragmentToSwitch);
        toolbarMenuItemWrapper.setSpinnerSelection(fragmentToSwitch);


//        for(int i=0; i<fragments.length; i++) {
//            Log.d("Ket", i+" "+fragments[i].isAdded()+" "+fragments[i].isHidden()+" "+fragments[i].isInLayout());
//        }

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


        // Update which fragment we stay.
        this.currentFragment = fragmentToSwitch;

    }
}
