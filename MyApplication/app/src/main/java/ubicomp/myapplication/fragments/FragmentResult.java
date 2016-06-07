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
public class FragmentResult extends Fragment {
    FragmentSwitcher fragmentSwitcher = null;

    public FragmentResult(FragmentSwitcher fragmentSwitcher) {
        this.fragmentSwitcher = fragmentSwitcher;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Ket", "onCreate fragment_result");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Ket", "onCreateView fragment_result");
        fragmentSwitcher.setFragmentOnlyDowndropTab(FragmentSwitcher.FRAGMENT_RESULT);
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.d("Ket", "onPause fragment_result");
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.d("Ket", "onStop fragment_result");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onStop();
//        Log.d("Ket", "onDestroy® fragment_result");
//    }
}
