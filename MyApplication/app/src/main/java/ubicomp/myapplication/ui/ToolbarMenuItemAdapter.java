package ubicomp.myapplication.ui;

import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ubicomp.myapplication.MainActivity;
import ubicomp.myapplication.R;

/**
 *  ToolbarMenuItemAdapter is used to handle the page switching between test, result, event and
 *  ranking pages. The click listener of each button on toolbar is also in this class.
 *
 * Created by kelvindk on 16/6/6.
 */
public class ToolbarMenuItemAdapter {

    public static void inflate(final MainActivity mainActivity, int menuID, Menu menu) {

        if(menu == null)
            return;
        menu.clear();
        switch (menuID) {
            case R.menu.menu_test:

                mainActivity.getMenuInflater().inflate(R.menu.menu_test, menu);

                MenuItem itemActionSettings = menu.findItem(R.id.action_settings);
                MenuItemCompat.getActionView(itemActionSettings).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mainActivity, "action_settings", Toast.LENGTH_SHORT).show();
                        // Listener of action Settings button
                    }
                });
                break;
            case R.menu.menu_event:
                mainActivity.getMenuInflater().inflate(R.menu.menu_event, menu);

                MenuItem actionAddEvent = menu.findItem(R.id.action_add_event);
                MenuItemCompat.getActionView(actionAddEvent).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mainActivity, "action_add_event", Toast.LENGTH_SHORT).show();
                        // Listener of action Add button
                    }
                });

                MenuItem actionRemind = menu.findItem(R.id.action_remind);
                MenuItemCompat.getActionView(actionRemind).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Listener of action Remind button
                        TextView remindBadgeText = (TextView) mainActivity.findViewById(R.id.menu_remind_badge);
                        remindBadgeText.setText(""+(Integer.parseInt(remindBadgeText.getText().toString())+1));
                        Toast.makeText(mainActivity, "action_remind "+remindBadgeText.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }


    }
}
