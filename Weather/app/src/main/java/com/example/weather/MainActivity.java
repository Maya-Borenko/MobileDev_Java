package com.example.weather;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ArrayList<JSONObject> days = new ArrayList<>();
    int current_index = 0;
    int daysNum = 0;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();}
    class DownloadFileFromURL extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            String result = "ok";
            try {
                URL url = new URL("https://worldweather.wmo.int/ru/json/206_ru.xml");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                File file = new File(getCacheDir(), "moscow_weather.json");
                FileOutputStream outputStream = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);}
                inputStream.close();
                outputStream.close();}
            catch (IOException e) { try {
                    result = "response code: " + ((connection != null) ? connection.getResponseCode() : -1);
                } catch (IOException ex) {
                    result = "response code:" + (-1);}}
            return result;}
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!Objects.equals(s, "ok")) {
                showError(s);}}}
    private void updateFile() throws IOException {
        DownloadFileFromURL downloadFileFromURL = new DownloadFileFromURL();
        downloadFileFromURL.execute();}
    private void showError(String message) {
        binding.WeatherLayout.setVisibility(View.INVISIBLE);
        binding.NavigationButtonLayout.setVisibility(View.INVISIBLE);}
    private void init() {
        try {updateFile();}
        catch (IOException e) {
            showError(e.getMessage());
            return;}
        FileInputStream inputStream;
        try {inputStream = new FileInputStream(new File(getCacheDir(), "moscow_weather.json"));}
        catch (FileNotFoundException e) {
            showError(e.getMessage());
            return;}
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);}
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONObject city = jsonObject.getJSONObject("city");
            JSONObject forecast = city.getJSONObject("forecast");
            JSONArray forecastDay = forecast.getJSONArray("forecastDay");
            binding.city.setText(city.getString("cityName"));
            daysNum = forecast.length();
            for (int i = 0; i < daysNum; i++) {
                days.add(forecastDay.getJSONObject(i));
                Log.d("WeatherApp", days.get(i).toString());}
            setInfo(days.get(0));
        } catch (IOException | JSONException e) {throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();}
                if (inputStream != null) {
                    inputStream.close();}
            } catch (IOException e) {
                e.printStackTrace();}}}
    public void back(View v) {
        current_index--;
        if (current_index == 0)
            binding.backButton.setEnabled(false);
        if (!binding.forwardButton.isEnabled())
            binding.forwardButton.setEnabled(true);
        setInfo(days.get(current_index));}
    public void forward(View v) {
        current_index++;
        if (current_index == daysNum - 1)
            binding.forwardButton.setEnabled(false);
        if (!binding.backButton.isEnabled())
            binding.backButton.setEnabled(true);
        setInfo(days.get(current_index));}
    private int getIcon(int weatherIcon)
    {
        switch (weatherIcon) {
            case 101:
            case 102:
            case 103:
            case 104:
                return R.drawable.sanddust;
            case 201:
            case 202:
            case 203:
            case 204:
                return R.drawable.storm;
            case 301:
                return R.drawable.hail;
            case 401:
            case 402:
            case 403:
            case 404:
                return R.drawable.blizzard;
            case 501:
            case 502:
                return R.drawable.snow;
            case 601:
            case 602:
            case 603:
                return R.drawable.snow;
            case 701:
                return R.drawable.snow;
            case 801:
                return R.drawable.sleet;
            case 901:
            case 902:
            case 903:
                return R.drawable.showers;
            case 1001:
            case 1002:
                return R.drawable.showers_scattered;
            case 1101:
                return R.drawable.showers_isolated;
            case 1201:
                return R.drawable.showers_light;
            case 1301:
                return R.drawable.rain_freezing;
            case 1401:
                return R.drawable.rain;
            case 1501:
            case 1502:
                return R.drawable.rain_light;
            case 1601:
                return R.drawable.fog;
            case 1701:
                return R.drawable.mist;
            case 1801:
                return R.drawable.smoke;
            case 1901:
                return R.drawable.haze;
            case 2001:
                return R.drawable.cloudy_mostly;
            case 2101:
            case 2102:
            case 2103:
                return R.drawable.cloudy_mostly;
            case 2201:
            case 2202:
            case 2203:
            case 2204:
                return R.drawable.cloudy_partly;
            case 2301:
            case 2302:
                return R.drawable.cloudy;
            case 2401:
            case 2402:
            case 2403:
            case 2501:
            case 2502:
                return R.drawable.sunny;
            case 2601:
            case 2602:
            case 2603:
            case 2604:
                return R.drawable.windy;
            case 2701:
            case 2702:
                return R.drawable.wet;
            case 2801:
                return R.drawable.dry;
            case 2901:
                return R.drawable.freezing;
            case 3001:
                return R.drawable.frost;
            case 3101:
                return R.drawable.hot;
            case 3201:
            case 3202:
                return R.drawable.cold;
            case 3301:
                return R.drawable.warm;
            case 3401:
                return R.drawable.cool;
            case 3501:
                return R.drawable.eruption;
        }
        return android.R.drawable.sym_def_app_icon;
    }

    @SuppressLint("SetTextI18n")
    private void setInfo(JSONObject day) {
        try {
            binding.currentDateTextView.setText("Дата: " + day.getString("forecastDate"));
            binding.temperatureTextView.setText("Температура:\nМинимальная: " + day.getString("minTemp")
                    + " С\nМаксимальная: " + day.getString("maxTemp") + " С");
            binding.descriptionTextView.setText("Oписание: " + day.getString("weather"));
            binding.weatherIconImageView.setImageResource(getIcon(day.getInt("weatherIcon")));
        } catch (JSONException e) {
            throw new RuntimeException(e);}}}

