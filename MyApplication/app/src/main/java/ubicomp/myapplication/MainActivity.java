package ubicomp.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import ubicomp.myapplication.ui.ToolbarMenuItemAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static int SPINNER_TEST = 0;
    public final static int SPINNER_RESULT = 1;
    public final static int SPINNER_EVENT = 2;
    public final static int SPINNER_RANKING = 3;

    public final static int NUMBER_OF_TABS = 4;

    private Menu menu = null;
    private TabLayout.Tab[] tabLayoutTabs = new TabLayout.Tab[NUMBER_OF_TABS];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enable toolbar on main activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Get the spinner on the toolbar
        Spinner spinner_toolbar = (Spinner) findViewById(R.id.spinner_toolbar);
        spinner_toolbar.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> spinner_content_adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, R.layout.spinner_layout);
        spinner_content_adapter.setDropDownViewResource(R.layout.spinner_layout);
        // Apply the adapter to the spinner
        spinner_toolbar.setAdapter(spinner_content_adapter);
        // Disable the App title on toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Create a TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_main_tabs);

        tabLayoutTabs[0] = tabLayout.newTab().setCustomView(R.layout.tab_icon_text_test);
        tabLayout.addTab(tabLayoutTabs[0]);
        tabLayoutTabs[1] = tabLayout.newTab().setCustomView(R.layout.tab_icon_text_result);
        tabLayout.addTab(tabLayoutTabs[1]);
        tabLayoutTabs[2] = tabLayout.newTab().setCustomView(R.layout.tab_icon_text_event);
        tabLayout.addTab(tabLayoutTabs[2]);
        tabLayoutTabs[3] = tabLayout.newTab().setCustomView(R.layout.tab_icon_text_ranking);
        tabLayout.addTab(tabLayoutTabs[3]);



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;

        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch(pos) {
            case SPINNER_TEST:
                Toast.makeText(this, "pos 0", Toast.LENGTH_SHORT).show();
                // Inflate the menu; this adds items to the action bar if it is present.
                ToolbarMenuItemAdapter.inflate(this, R.menu.menu_test, this.menu);
                break;
            case SPINNER_RESULT:
                Toast.makeText(this, "pos 1", Toast.LENGTH_SHORT).show();
                break;
            case SPINNER_EVENT:
                Toast.makeText(this, "pos 2", Toast.LENGTH_SHORT).show();
                ToolbarMenuItemAdapter.inflate(this, R.menu.menu_event, this.menu);
                break;
            case SPINNER_RANKING:
                Toast.makeText(this, "pos 3", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
