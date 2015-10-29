package fightingpit.barrons1100;

/**
 * Created by AG on 08-Oct-15.
 */

import android.content.Context;
import android.os.Parcelable;
import android.support.v13.app.FragmentPagerAdapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private String mTabName = new String();
    private Integer mPrimaryItemId = 0;
    private Context mContext;

    public TabsPagerAdapter(FragmentManager fm, Context iContext) {
        super(fm);
        mContext=iContext;

    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new WordListFragment();
            case 1:
                return new FlashCardsFragment();
            case 2:
                return new QuizFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

    @Override
    public int getItemPosition(Object object) {
        if(object.getClass().getSimpleName().equals(mTabName)){
            return POSITION_UNCHANGED;
        }
        else {
            return POSITION_NONE;
        }
    }

    public void setTabName(String iTabName){
        mTabName = iTabName;
    }


    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mPrimaryItemId = position;
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
        if(mPrimaryItemId == 1 && ((MainActivity) mContext).isuView()) {
            Log.d("ABG", "Selected 1");
            ((MainActivity) mContext).setuView(false);
            ((MainActivity) mContext).updateTabs("FlashCardsFragment");
        }
        else if(mPrimaryItemId == 0 && ((MainActivity) mContext).isuView()) {
            Log.d("ABG", "Selected 0");
            ((MainActivity) mContext).setuView(false);
            ((MainActivity) mContext).updateTabs("WordListFragment");
        }
        else if(mPrimaryItemId == 2 && ((MainActivity) mContext).isuView()) {
            Log.d("ABG", "Selected 2");
            ((MainActivity) mContext).setuView(false);
            ((MainActivity) mContext).updateTabs("QuizFragment");
        }
    }

}