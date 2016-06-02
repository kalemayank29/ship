package com.example.kylehirschfelder.ship;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mayank on 1/17/16.
 */
public class GetDate {

    // THIS FUNCTION IS USED TO GET AGE, NOT DATE. Super misnomer.

    public static String getDate(int birthYear, int birthMonth, int birthDay, int deathYear, int deathMonth, int deathDay) {
        int ageYear = 0, ageMonth = 0, ageDate = 0;
        int flag = 30; // for number of days in a month

        if(birthMonth == 2) {
            if(birthYear % 4 == 0 || birthYear == 2000) { // leap year handling
                flag = 29;
            }
            else
                flag = 28;
        }
        else if(birthMonth == 1 || birthMonth == 3 || birthMonth == 5 || birthMonth == 7 || birthMonth == 8
                || birthMonth == 10 || birthMonth == 11 || birthMonth == 12) {
            flag = 31;
        }


        ageYear = deathYear - birthYear;
        if(birthMonth <= deathMonth) {
            ageMonth = deathMonth - birthMonth;
        }
        else {
            ageMonth = 12 + deathMonth - birthMonth;
            ageYear--;
        }
        if(birthDay <= deathDay)	 {
            ageDate = deathDay - birthDay;
        }
        else {

            ageDate = flag + deathDay - birthDay;
            ageMonth--;
        }

        return ageDate + "-" + ageMonth + "-" + ageYear ;
    }

    public static int getMonths(String date) {
        String array[] = date.split("-");
        return Integer.parseInt(array[1]);
    }
    public static int getYears(String date) {
        String array[] = date.split("-");
        return Integer.parseInt(array[0]);
    }
    public static int getDays(String date) {
        String array[] = date.split("-");
        Log.println(Log.ASSERT, "", array[0] + "/" + array[1] + "/" + array[2]);
        return Integer.parseInt(array[2]);
    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return String.valueOf(dateFormat.format(date));
    }


}
