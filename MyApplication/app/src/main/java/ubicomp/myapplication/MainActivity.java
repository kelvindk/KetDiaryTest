package ubicomp.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import ubicomp.myapplication.ui.FragmentSwitcher;
import ubicomp.myapplication.ui.TabLayoutWrapper;
import ubicomp.myapplication.ui.ToolbarMenuItemWrapper;

public class MainActivity extends AppCompatActivity {


    // The wrapper to handle toolbar.
    ToolbarMenuItemWrapper toolbarMenuItemWrapper = null;
    // The wrapper to handle tab layout.
    TabLayoutWrapper tabLayoutWrapper = null;
    // The class to manipulate fragment switch, all switching should use this class.
    FragmentSwitcher fragmentSwitcher = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // New the wrapper of toolbar UI.
        toolbarMenuItemWrapper = new ToolbarMenuItemWrapper(this);
        // New the wrapper of tabs UI.
        tabLayoutWrapper = new TabLayoutWrapper(this);
        // New the object of handling fragment switch.
        fragmentSwitcher = new FragmentSwitcher(this, toolbarMenuItemWrapper, tabLayoutWrapper);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Pass the reference of Menu object to ToolbarMenuItemWrapper when ready
        this.toolbarMenuItemWrapper.setMenu(menu);

        return true;
    }

    // To pass the call for fragment switch to FragmentSwitcher.
    public void setFragment(int fragmentToSwitch) {
        this.fragmentSwitcher.setFragment(fragmentToSwitch);
    }

}
