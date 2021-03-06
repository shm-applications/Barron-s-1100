package fightingpit.barrons1100;

/**
 * Created by AG on 08-Oct-15.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class QuizFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.quiz_main_fragment, container, false);

        SharedPreferences aSharedPref = getActivity().getSharedPreferences("AppSettings", Context.MODE_PRIVATE);
        String aIsAppPurchased = aSharedPref.getString("is_app_purchased", "");
        if("y".equals(aIsAppPurchased)){
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_qmf_fragment_holder, new PurchasedQuizFragment())
                    .commit();
        }else{
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_qmf_fragment_holder, new BuyAppFragment(),"BuyFragment")
                    .commit();
        }
        return rootView;
    }
}

