package com.example.kylehirschfelder.ship;

import android.app.Application;

/**
 * Created by mayank on 1/7/16.
 */
public class CurrentVillage extends Application {

        private int villageId;

        public int getSomeVariable() {
            return villageId;
        }

        public void setSomeVariable(int villageId) {
            this.villageId = villageId;
        }


    }

