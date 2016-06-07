package ubicomp.myapplication.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ubicomp.myapplication.R;
import ubicomp.myapplication.ui.FragmentSwitcher;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentTest extends Fragment {
    FragmentSwitcher fragmentSwitcher = null;

    public FragmentTest(FragmentSwitcher fragmentSwitcher) {
        this.fragmentSwitcher = fragmentSwitcher;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Ket", "onCreate fragment_test");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Ket", "onCreateView fragment_test");
        fragmentSwitcher.setFragmentOnlyDowndropTab(FragmentSwitcher.FRAGMENT_TEST);
        return inflater.inflate(R.layout.fragment_test, container, false);
    }
}
