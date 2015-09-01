package com.example.kylehirschfelder.ship;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mayank on 8/10/15.
 */

public class JSONParser {
    static InputStream iStream = null;
    static JSONArray jarray = null;
    static String json = "";

    public JSONParser() {
    }

    public JSONArray getJSONFromUrl(String url) throws IOException {
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            HttpEntity entity = null;
            if (statusCode == 200) {
                entity = response.getEntity();
            }

            InputStream content = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Parse String to JSON object
        try
        {
            jarray = new JSONArray( builder.toString());
        }
        catch (JSONException e) { Log.e("JSON Parser", "Error parsing data " + e.toString()); }
        // return JSON Object
        return jarray; }

}
    // Parse String to JSON object try { jarray = new JSONArray( builder.toString()); } catch (JSONException e) { Log.e("JSON Parser", "Error parsing data " + e.toString()); } // return JSON Object return jarray; } }



