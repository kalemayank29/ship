package com.example.kylehirschfelder.ship;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mayank on 1/14/16.
 */
public class Upload {
    private String url;

    public Upload(String url){
        this.url = url;
    }

    public List<Integer> idList(String value, int flag){

        // String to be scanned to find the pattern.
        String line = value;
        String pattern = "\\.\\d*\\-\\d";
        List<Integer> result = new ArrayList<Integer>();

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        Log.println(Log.ASSERT,"member",value);

        Matcher m = r.matcher(line);
        while (m.find( )) {
            //Log.println(Log.ASSERT, "Found value: " + m.group(0), "lol");
            int[] array = parse(m.group(0));
            Log.println(Log.ASSERT,String.valueOf(array[0]),String.valueOf(array[1]));
            if(array[1]==flag){
                result.add(array[0]);
            }
        }

        return result;
    }

    private int[] parse(String value){
        int[] array = new int[2];

        String pattern = "\\.\\d*\\-";
      //  Log.println(Log.ASSERT,"parse",value);
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        if (m.find( )) {
           String result = m.group(0);
            result = result.substring(1,result.length()-1);
            //Log.println(Log.ASSERT,"parseResult",result);
            array[0] = Integer.parseInt(result);
        }

        pattern = "\\-\\d";
        r = Pattern.compile(pattern);
        m = r.matcher(value);
        if (m.find( )) {
            String result = m.group(0);
            result = result.substring(1);
            array[1] = Integer.parseInt(result);
        }
        return array;
    }

    public String updateFlags(List<Integer> ids, int flag, String value){
        StringBuilder builder = new StringBuilder(value);
        int arrayLength = ids.size();
        int counter = 1;
        for (int id: ids
             ) {
           // Log.println(Log.ASSERT,"oldString",builder.toString());
            int index = builder.indexOf(String.valueOf(id)) - 1;
           // Log.println(Log.ASSERT,"index",String.valueOf(index));

                String replace = "." + String.valueOf(id) + "-" + String.valueOf(flag);
                // Log.println(Log.ASSERT,"replace",replace);
                int length = replace.length();
                //  Log.println(Log.ASSERT,"replaceLenght",String.valueOf(length));
                builder.replace(index,index+length,replace);
                  Log.println(Log.ASSERT,"newstring",builder.toString());


            counter++;

        }

        String result = builder.toString();
        int length = result.length();
        return result.substring(0,length);
    }
}
