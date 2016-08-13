package uk.prudentialwarnew.CustomerListMain.ParserCustomerListMain;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import uk.prudentialwarnew.CustomerListMain.adapter.models.DataModel_CustomerList;
import uk.prudentialwarnew.CustomerListMain.fragments.FragmentsCustomerList;


/**
 * Created by user on 8/10/2016.
 */
public class ParserCustomerList {
    public static DataModel_CustomerList schema;
    Activity mActivity;
    public ParserCustomerList(Activity activity) {
        super();
        this.mActivity = activity;
        String url;
        if(FragmentsCustomerList.condition == true){
            url="https://dl.dropboxusercontent.com/u/41588641/search.json";
        }
        else{
            url="https://dl.dropboxusercontent.com/u/41588641/customers.json";
        }

        POSTForFetchingDATA(url);

        // TODO Auto-generated constructor stub
    }


    private String POSTForFetchingDATA(String urlValue) {
        try{

            URL url = new URL(urlValue);



            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // conn.setRequestProperty("Content-Type", "application/multipart/form-data");

            //conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                Log.d("ERROR::::CODE", "http response code is " + conn.getResponseCode());
                return null;
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0;)
                sb.append((char)c);
            String response = sb.toString();
            System.out.println("Response Truck status::::"+response);
            getGSONResult (response);

        }
        catch (UnknownHostException e) {
            // TODO: handle exception
            e.printStackTrace();
        }catch (Exception e) {

            e.printStackTrace();
        }
        // 11. return result
        return "";
    }

    private void getGSONResult(String result)
    {
        Gson gson = new GsonBuilder().create();
        schema = gson.fromJson(result, DataModel_CustomerList.class);

        String val = schema.getList().get(0).getName().getFirst();
        System.out.println("NAME:"+val);


    }
}
