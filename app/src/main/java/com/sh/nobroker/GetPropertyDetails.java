package com.sh.nobroker;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.sh.nobroker.net.NetworkIO;


/**
 * Created by shanaulhaque on 13/05/17.
 */

public class GetPropertyDetails extends AsyncTask<String, Void, Void> {

    private static final String TAG = GetPropertyDetails.class.getSimpleName();

    private IAsyncTask iAsyncTask;

    public GetPropertyDetails(IAsyncTask iAsynckTask){
        this.iAsyncTask = iAsynckTask;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(String... url) {
        NetworkIO sh = new NetworkIO();


        String jsonStr = sh.makeServiceCall(url[0]);

        Log.i(TAG, "Response from url: " + jsonStr);

        ParsePropertyDetail propertyDetail = new ParsePropertyDetail();
        propertyDetail.parse(jsonStr,iAsyncTask.getActivity());

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        iAsyncTask.postExecute();
    }

}
