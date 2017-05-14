package com.sh.nobroker;

import android.app.Activity;

/**
 * Created by shanaulhaque on 13/05/17.
 */

public interface IAsyncTask {

    Activity getActivity();

    void postExecute();

}
