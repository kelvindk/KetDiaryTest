package ubicomp.myapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ubicomp.myapplication.R;
import ubicomp.myapplication.ui.FragmentSwitcher;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentRanking extends Fragment {

    FragmentSwitcher fragmentSwitcher = null;

    public FragmentRanking(FragmentSwitcher fragmentSwitcher) {
        this.fragmentSwitcher = fragmentSwitcher;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Ket", "onCreate fragment_ranking");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Ket", "onCreateView fragment_ranking");
        fragmentSwitcher.setFragmentOnlyDowndropTab(FragmentSwitcher.FRAGMENT_RANKING);
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }
}
