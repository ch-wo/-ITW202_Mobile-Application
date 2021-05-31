package edu.gcit.todo_22;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //base url for book API
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    //parameter for search string
    private static final String QUERY_PARAM = "q";
    //parameter that limit the search result
    private static final String MAX_RESULTS = "maxResults";

    private static final String PRINT_TYPE = "printType";

    static String getBookInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;

        try {
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS,"10")
                    .appendQueryParameter(PRINT_TYPE,"books")
                    .build();

            URL requestURL = new URL(builtURI.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //getting the data from connection
            //get the inputstream
            InputStream inputStream = urlConnection.getInputStream();
            //converted to buffer reader
            reader = new BufferedReader(new InputStreamReader(inputStream));
            //stringBuilder to hold the incoming response
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line);
                builder.append("\n");
            }
            if (builder.length() == 0){
                return null;
            }
            //converting object to a string
            bookJSONString = builder.toString();

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(urlConnection != null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
               }
            }
        }
        Log.d(LOG_TAG, bookJSONString);
        return bookJSONString;
    }
}
