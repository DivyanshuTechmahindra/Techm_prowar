package uk.prudentialwarnew.viewpagerexmp;

/**
 * Created by user on 8/13/2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import uk.prudentialwarnew.R;

public class FragmentPageTwo extends Fragment {
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment2, container, false);
        return v;
    }

    TextView txText;

}