package com.example.kylehirschfelder.ship;

/**
 * Created by poorwa on 14/1/16.
 */
public class Parse {
    public static String parseString(int length, String bitStream) {
        String output = "";

        int bitLength = bitStream.length();
        int j = 0;

        for(int i = 0; i < length; i++) {
            if(i >= length - bitLength)
                output += bitStream.charAt(j++);
            else
                output += "0";
        }

        return output;
    }
}
