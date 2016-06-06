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
        Log.d("Ket", "fragment0  isAdded "+ fragments[0].isAdded());
        fragmentTransaction.add(fragments[1], "FragmentResult");
        fragmentTransaction.add(fragments[2], "FragmentEvent");
        fragmentTransaction.add(fragments[3], "FragmentRanking");
        fragmentTransaction.replace(R.id.fragment_container, fragments[3]);
        fragmentTransaction.replace(R.id.fragment_container, fragments[2]);
        fragmentTransaction.replace(R.id.fragment_container, fragments[1]);
        fragmentTransaction.replace(R.id.fragment_container, fragments[0]);
        fragmentTransaction.commit();

    }



    // Switch the fragment.
    public void setFragment(int fragmentToSwitch, String callerClassName) {
        // Update which fragment we stay.
        this.currentFragment = fragmentToSwitch;

        // Bind tab and downdrop selection,
        // i.e., they will change together when one of them is selected.
        tabLayoutWrapper.setTabSelected(fragmentToSwitch);
        toolbarMenuItemWrapper.setSpinnerSelection(fragmentToSwitch);


//        for(int i=0; i<fragments.length; i++) {
//            Log.d("Ket", i+" "+fragments[i].isAdded()+" "+fragments[i].isHidden()+" "+fragments[i].isInLayout());
//        }

        // Switch fragment to selected page.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragments[fragmentToSwitch]);
        fragmentTransaction.commit();

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



    }
}
