package com.example.kylehirschfelder.ship;

/**
 * Created by kylehirschfelder on 7/9/15.
 */
public class Drug {

    private String _generic, _brand, _formula, _class, _color, _shape;
    private int _id;

    public Drug(int _id, String _generic, String _brand, String _formula, String _class, String _color, String _shape) {
        this._id = _id;
        this._generic = _generic;
        this._brand = _brand;
        this._formula = _formula;
        this._class = _class;
        this._color = _color;
        this._shape = _shape;
    }

    public Drug(){
    }

    public String get_generic() {
        return _generic;
    }

    public String get_brand() {
        return _brand;
    }

    public String get_formula() {
        return _formula;
    }

    public String get_class() {
        return _class;
    }

    public String get_color() {
        return _color;
    }

    public String get_shape() {
        return _shape;
    }

    public int get_id() {
        return _id;
    }


    public void set_generic(String _generic) {
        this._generic = _generic;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }

    public void set_formula(String _formula) {
        this._formula = _formula;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public void set_color(String _color) {
        this._color = _color;
    }

    public void set_shape(String _shape) {
        this._shape = _shape;
    }


    public void set_id(int _id){
        this._id = _id;
    }


}
