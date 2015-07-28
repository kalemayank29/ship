package com.example.kylehirschfelder.ship;

import android.util.Log;

import java.util.BitSet;

import static android.text.TextUtils.split;

public class Census {

    private String _caste, _pbus, _abus1, _abus2, _abus3, _wall,
                _roof, _electricity, _houseowner, _toiletuse,
                _toilet, _cook, _kitchen, _water, _date, _religion;


    private int _famid;

    BitSet wallBit;

    public Census(int _famid, String _caste, String _religion, String _pbus,
                  String _abus1, String _abus2,
                  String _abus3, String _wall,
                  String _roof, String _electricity, String _houseowner,
                  String _toilet, String _toiletuse, String _cook,
                  String _kitchen, String _water,
                  String _date) {

        this._famid = _famid;
        this._caste = _caste;
        this._pbus = _pbus;
        this._abus1 = _abus1;
        this._abus2 = _abus2;
        this._abus3 = _abus3;
        this._wall = _wall;
        this._roof = _roof;
        this._electricity = _electricity;
        this._houseowner = _houseowner;
        this._toiletuse = _toiletuse;
        this._toilet = _toilet;
        this._cook = _cook;
        this._kitchen = _kitchen;
        this._water = _water;
        this._date = _date;
        this._religion = _religion;
    }

    public int get_famid(){
        return _famid;
    }

    public String get_famid_str() {return String.valueOf(_famid); }

    public String get_caste() {
        return _caste;
    }

    public String get_pbus() {
        return _pbus;
    }

    public String get_abus1() {
        return _abus1;
    }

    public String get_abus2() {
        return _abus2;
    }

    public String get_abus3() {
        return _abus3;
    }

    public String get_wall() {
        return _wall;
    }

    public String get_wallParse(String bitString) {

        String uncompress= " ";
        bitString = bitString.substring(1, bitString.length()-1);
        String[] parsed = split(bitString, ", ");

        for(int i=0;i<parsed.length;i++)
        {
            if(parsed[i].equals("0")){
                uncompress += "Cement,";
            }

            if(parsed[i].equals("1")){
                uncompress += "Brick,";
            }

            if(parsed[i].equals("2")){
                uncompress += "Sand,";
            }

            if(parsed[i].equals("3")){
                uncompress += "Junk,";
            }

            if(parsed[i].equals("4")){
                uncompress += "Others,";
            }
        }

        return uncompress;
    }

    public String get_roof() {
        return _roof;
    }

    public String get_roofParse(String bitString) {

        String uncompress= " ";
        bitString = bitString.substring(1, bitString.length()-1);
        String[] parsed = split(bitString, ", ");

        for(int i=0;i<parsed.length;i++)
        {
            if(parsed[i].equals("0")){
                uncompress += "Cement,";
            }

            if(parsed[i].equals("1")){
                uncompress += "Mangalore Tiles,";
            }

            if(parsed[i].equals("2")){
                uncompress += "Normal Tiles,";
            }

            if(parsed[i].equals("3")){
                uncompress += "Tin,";
            }

            if(parsed[i].equals("4")){
                uncompress += "Grass,";
            }

            if(parsed[i].equals("5")){
                uncompress += "Others,";
            }
        }

        return uncompress;
    }

    public String get_electricity() {
        return _electricity;
    }

    public String get_electricityParse() {
        String parsed="";
        switch (_electricity) {
            case "1":
                parsed= "Yes";
                break;
            case "0":
                parsed = "No";
                break;
        }
        return parsed;
    }

    public String get_houseowner() {
        return _houseowner;
    }

    public String get_houseOwnerParse() {
        String parsed="";
        switch (_houseowner) {
            case "1":
                parsed= "Owned";
                break;
            case "0":
                parsed = "Rented";
                break;
        }
        return parsed;
    }

    public String get_toiletuse() {
        return _toiletuse;
    }

    public String get_toiletuseParse() {
        String parsed="";
        switch (_houseowner) {
            case "1":
                parsed= "Yes";
                break;
            case "0":
                parsed = "No";
                break;
        }
        return parsed;
    }


    public String get_toilet() {
        return _toilet;
    }

    public String get_toiletParse() {
        String parsed="";
        switch (_houseowner) {
            case "1":
                parsed= "Yes";
                break;
            case "0":
                parsed = "No";
                break;
        }
        return parsed;
    }


    public String get_cook() {
        return _cook;
    }

    public String get_cookParse(String bitString) {

        String uncompress= " ";
        bitString = bitString.substring(1, bitString.length()-1);
        String[] parsed = split(bitString, ", ");

        for(int i=0;i<parsed.length;i++)
        {
            if(parsed[i].equals("0")){
                uncompress += "Light,";
            }

            if(parsed[i].equals("1")){
                uncompress += "Gas,";
            }

            if(parsed[i].equals("2")){
                uncompress += "Coal,";
            }

            if(parsed[i].equals("3")){
                uncompress += "Wood,";
            }

            if(parsed[i].equals("4")){
                uncompress += "Others,";
            }
        }
Log.e("works","yes");
        return uncompress;
    }


    public String get_kitchen() {
        return _kitchen;
    }

    public String get_kitchenParse() {
        String parsed="";
        switch (_houseowner) {
            case "1":
                parsed= "Yes";
                break;
            case "0":
                parsed = "No";
                break;
        }
        return parsed;
    }


    public String get_water() {
        return _water;
    }

    public String get_waterParse(String bitString) {

        String uncompress= " ";
        bitString = bitString.substring(1, bitString.length()-1);
        String[] parsed = split(bitString, ", ");

        for(int i=0;i<parsed.length;i++)
        {
            if(parsed[i].equals("0")){
                uncompress += "Well,";
            }

            if(parsed[i].equals("1")){
                uncompress += "Handpump,";
            }

            if(parsed[i].equals("2")){
                uncompress += "Tap,";
            }

            if(parsed[i].equals("3")){
                uncompress += "Lake,";
            }

            if(parsed[i].equals("4")){
                uncompress += "River,";
            }

            if(parsed[i].equals("5")){
                uncompress += "Canal,";
            }
        }

        return uncompress;
    }

    public String get_date() {
        return _date;
    }

    public String get_religion() {
        return _religion;
    }

    public String get_religionParse() {
        String parsed = "";
        switch (_religion) {
            case "1":
                _religion = "Hindu";
                break;
            case "2":
                _religion = "Muslim";
                break;
            case "4":
                _religion = "Christian";
                break;
            case "8":
               _religion = "Sikh";
                break;
            case "16":
                _religion = "Jain";
                break;
            case "32":
                _religion = "Buddhism";
                break;
        }

        return parsed;
    }


}


