package com.example.mynutrionistpal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.content.Context;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.fragment.NavHostFragment;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.InputStream;
import java.io.IOException;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView((R.layout.activity_main));
    }
    public void loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("Food_Display_Table_json.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            JSONObject obj = new JSONObject();
            JSONArray m_jArry = obj.getJSONArray(json);
            System.out.println((m_jArry));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
