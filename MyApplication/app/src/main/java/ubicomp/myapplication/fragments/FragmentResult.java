package ubicomp.myapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ubicomp.myapplication.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentResult extends Fragment {

    public FragmentResult() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Ket", "onCreate fragment_result");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Ket", "onCreateView fragment_result");
        return inflater.inflate(R.layout.fragment_result, container, false);
    }
}
