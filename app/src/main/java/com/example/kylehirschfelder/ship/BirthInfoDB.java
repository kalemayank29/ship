package com.example.kylehirschfelder.ship;

import android.provider.BaseColumns;

/**
 * Created by poorwa on 10/8/15.
 */

public class BirthInfoDB {




                public BirthInfoDB()
                {

                }

                public static abstract class TableInfo implements BaseColumns
                {
                        public static final String MOTHER_VILLAGE = "mother_village" ;//2spinners
                        public static final String MOTHER_VILLAGE_ID = "mother_village_id" ;//tv
                        public static final String MOTHER_NAME = "mother_name" ;//tv
                        public static final String FAMILY_ID = "family_id" ;//tv
                        public static final String HOUSE_ID = "house_id" ;//tv
                        public static final String CHILD_ID = "child_id" ;//
                        public static final String MEMBER_ID = "member_id" ;
                        public static final String VILLAGE_ID = "village_id" ;
                        public static final String BIRTH_DATE = "birth_date" ;//dp
                        public static final String VILLAGE_OF_BIRTH = "village_of_birth" ;//2 spinners
                        public static final String VILLAGE_OF_BIRTH_ID = "village_of_birth_id" ;//tv
                        public static final String VILLAGE_OF_BIRTH_PLACE = "village_of_birth_place" ;//rb
                        public static final String DELIVERY_NAME = "delivery_name" ;//et
                        public static final String DELIVERY_METHOD = "delivery_method" ;//cb
                        public static final String CHILD_GENDER = "child_gender" ;//rb
                        public static final String PREGNANCY_TIME = "pregnancy_time" ;//rb
                        public static final String FAD_PRESENCE = "female_messenger" ;//rb
                        public static final String HEALTH_MESSENGER = "health_messenger" ;//et
                        public static final String HEALTH_MESSENGER_ID = "health_messenger_id";//et
                        public static final String HEALTH_MESSENGER_DATE = "health_messenger_date" ;//dp
                        public static final String GUIDE_NAME = "guide_name" ;//et
                        public static final String GUIDE_ID = "guide_id" ;//et
                        public static final String GUIDE_TEST_DATE = "guide_test_date" ;//dp
                        public static final String DATABASE_NAME = "SEARCHF";
                        public static final String TABLE_NAME = "BirthInfo";
                }

        }

