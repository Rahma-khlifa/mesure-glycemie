package com.example.rahma_khlifa_mesure_glycemie.contoller;


import android.content.SharedPreferences;
import android.databinding.tool.Context;

import com.example.rahma_khlifa_mesure_glycemie.model.User;

public class HomeController {
    private static HomeController  instance = null;
    private static final String SHARED_PREFS = "mySharedPrefs";
    private static User user;

    public HomeController() {
    }

    public static final HomeController getInstance(Context context){
        if(HomeController.instance ==null){
            HomeController.instance = new HomeController();
        }
        recapUser(context);
        return HomeController.instance;
    }
    public void createUser(String userEmail, String password, Context context){
        user = new User(userEmail,password);
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", userEmail);
        editor.putString("password", password);
        editor.apply();
    }
    public static void recapUser(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");
        user = new User(userEmail,password);
    }
    public String getUserEmail() {
        return user.getEmail();
    }

    public String getPassword() {
        return user.getPassword();
    }
}
