package ribeiro.anderson.atividade2_sin3anmca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Anderson on 19/03/2018.
 */

public class DetalhePaisFragment extends Fragment {


    public DetalhePaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe_pais, container, false);
    }

}
