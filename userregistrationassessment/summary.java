package com.example.ac_ma.userregistrationassessment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;

public class summary extends FragmentActivity {

    int code;
    Bitmap picture;
    byte[] inBytes;
    String reply;
    private TextView mDataText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView textView = findViewById(R.id.email);
        textView.setText(startRegistration.getEmail());

        textView = findViewById(R.id.name);
        textView.setText(nameZipcodeHeight.getName());

        textView = findViewById(R.id.zipcode);
        textView.setText(nameZipcodeHeight.getZipcode());

        textView = findViewById(R.id.height);
        textView.setText(nameZipcodeHeight.getHeight());

        textView = findViewById(R.id.gender);
        textView.setText(genderDOB.getGender());

        textView = findViewById(R.id.dob);
        textView.setText(genderDOB.getDob());

        textView = findViewById(R.id.interest);
        textView.setText(interestAge.getInterest());

        textView = findViewById(R.id.minAge);
        textView.setText(interestAge.getMinAge());

        textView = findViewById(R.id.maxAge);
        textView.setText(interestAge.getMaxAge());

        textView = findViewById(R.id.race);
        textView.setText(raceReligion.getRace());

        textView = findViewById(R.id.religion);
        textView.setText(raceReligion.getReligion());

        ImageView imageView = findViewById(R.id.profilePic);
        imageView.setImageBitmap(profilePicture.getPicture());

        mDataText = (TextView) findViewById(R.id.response);
    }

    public void submit(View view) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", startRegistration.getEmail());
        jsonObject.put("password", createPassword.getPassword());

        jsonObject.put("name", nameZipcodeHeight.getName());
        jsonObject.put("zipcode", nameZipcodeHeight.getZipcode());
        jsonObject.put("height", nameZipcodeHeight.getHeight());

        jsonObject.put("gender", genderDOB.getGender());
        jsonObject.put("dob", genderDOB.getDob());

        jsonObject.put("interest", interestAge.getInterest());
        jsonObject.put("minAge", interestAge.getMinAge());
        jsonObject.put("maxAge", interestAge.getMaxAge());

        jsonObject.put("race", raceReligion.getRace());
        jsonObject.put("religion", raceReligion.getReligion());

        picture = profilePicture.getPicture();
        inBytes = jsonObject.toString().getBytes("utf-8");

        new uploadFiles().execute(jsonObject);


    }

    private class uploadFiles extends AsyncTask <JSONObject, Integer, String> {
        protected String doInBackground(JSONObject... data) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("https://external.dev.pheramor.com/");
                urlConnection = (HttpURLConnection) url.openConnection();
                inBytes = data.toString().getBytes("utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                urlConnection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
                urlConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                urlConnection.setRequestProperty("Cache-Control", "max-age=0");
                urlConnection.setRequestProperty("Connection", "keep-alive");
                urlConnection.setRequestProperty("Host", "external.dev.pheramor.com");
                urlConnection.setRequestProperty("Referer", "https://jobs.pheramor.com/assessment/Android");
                urlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setChunkedStreamingMode(0);
                urlConnection.setUseCaches(false);

                try {
                    OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                    out.write(inBytes);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(picture.getByteCount());
                    picture.copyPixelsToBuffer(byteBuffer);
                    byte[] temp = byteBuffer.array();
                    out.write(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reply = urlConnection.getResponseMessage();
                code = urlConnection.getResponseCode();
                mDataText = (TextView) findViewById(R.id.response);
                mDataText.setText(reply);

                //InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                //in.read(response);
            } finally {
                urlConnection.disconnect();
                showDialog(code);
                return reply;
            }

        }

        /*protected void onProgressUpdate(Integer... progress) {
            setProgressPercent(progress[0]);
        }*/

        protected void onPostExecute(int result) {
            showDialog(result);
        }
    }
}
