package com.example.kylehirschfelder.ship;

import java.io.Serializable;

/**
 * Created by kylehirschfelder on 12/23/15.
 */
public class Medicine implements Serializable {

    private String id;
    private String name;
    private int quantity;
 //   private String village_id;

    public Medicine(){

    }

    public Medicine(String id, String name){
        this.id = id;
        this.name = name;
        //this.quantity = quantity;
       // this.village_id = village_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

/*    public void setVillageId(String info){
        this.village_id = info;
    }

    public String getVillageId(){
        return village_id;
    }*/
}