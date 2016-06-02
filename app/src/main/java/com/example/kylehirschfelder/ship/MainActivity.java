package com.example.kylehirschfelder.ship;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DeathAdultDataInterface adultDataInterface = new DeathAdultDataInterface(getApplicationContext());
        //adultDataInterface.drop();

        MemberDataInterface test = new MemberDataInterface(getApplicationContext());
       // test.getAllMembers(1);
        CF_DatabaseOperations databaseOperations = new CF_DatabaseOperations(getApplicationContext());
      //  databaseOperations.getUnsynced(1);
        //databaseOperations.setAutoIncr();
        /*try {
            test.cleanFamilyId();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        Translation object = new Translation();
     /*  try {
            Member member = test.getRecent(1);
          Log.println(Log.ASSERT, "memberid", String.valueOf(member.getMemberId()));
         Log.println(Log.ASSERT, "villageid", String.valueOf(member.getFamilyId()));
        } catch (SQLException e) {
            e.printStackTrace();

        }*/

      //  Member result = test.getLastMember(12);
      //  Log.println(Log.ASSERT,"lastmember", String.valueOf(result.getMemberId()));


       // test.getAllMembers(1);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences( getApplicationContext());

        String member = preferences.getString("member","default");

        //Log.println(Log.ASSERT,"memberFlag",member);
       /* Upload upload = new Upload("XXX");
        //upload.uploadPairs(member);
        List<Integer> result = upload.idList(member, 0);
        for (Integer x:result
             ) {
            Log.println(Log.ASSERT,"ID",String.valueOf(x));
        }

        String value = upload.updateFlags(result,1,member);
        Log.println(Log.ASSERT,"value",value);
*/

        ((CurrentVillage) this.getApplication()).setSomeVariable(12);
        int curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();
                Log.println(Log.ASSERT,"curVillage", String.valueOf(curVillage));

        File externalStorage = Environment.getExternalStorageDirectory();
        Log.println(Log.ASSERT,"path",externalStorage.getAbsolutePath());


        //CodOneFive.getInstance().setName("mayank");
         // Log.println(Log.ASSERT,"supervisor",object.Letter_E2M("sarcha gaDachirolee"));
        /*CF_DatabaseOperations census = new CF_DatabaseOperations(getApplicationContext());
        List<Census> list = census.getUnsynced(0);

        for (Census xyz: list
             ) {
            Log.println(Log.ASSERT,"House id",xyz.getHouseID());
        }*/
        /********************************************
        Member member = new Member(4,1,"Kyle", 22, 14, "M", "F", "E", "L", "D", "A");
        Member member1 = new Member(4,0,"Kyle1", 22, 14, "M", "F", "E", "L", "D", "A");
        Member member2 = new Member(5,0,"Kyle2", 22, 14, "M", "F", "E", "L", "D", "A");
        Member member3 = new Member(5,1,"Kyle3", 22, 14, "M", "F", "E", "L", "D", "A");

        try {
            test.createMember(member, 1);
            test.createMember(member1, 1);
            test.createMember(member2,1);
            test.createMember(member3, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*List<Member> familyHead = test.getAllFamilyHeads(0);

        for (Member temp: familyHead
             ) {
            Log.println(Log.ASSERT,temp.getName(), String.valueOf(temp.getMemberId()));
        }*/

       // Intent intent = new Intent(getApplicationContext(), CodFifteenForm.class);
        // startActivity(intent);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        Fragment myFragment = null;
        switch(position) {
            case 0:
                myFragment = new HomeFragment();
                break;
            case 1:
                myFragment = new MembersFragment();
                break;
           // case 2:
             //   myFragment = new PatientFragment();
               // break;
            /*case 3:
                myFragment = new HouseFragment();
                break;*/
            case 2:
                myFragment = new FormFragment();
                break;
            case 3:
                myFragment = new TransferFragment();
                break;
            case 4:
                myFragment = new TransferFragment();
                break;
            case 5:
                myFragment = new EducationFragment();

        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, myFragment)
                .commit();
    }

    public void onSectionAttached(int number) {

        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            //case 3:
              //  mTitle = getString(R.string.title_section3);
                //break;
            /*case 4:
                mTitle = getString(R.string.title_section4);
                break;*/
            case 4:
                mTitle = getString(R.string.title_section5);
                break;
            case 7:
                mTitle = getString(R.string.title_section8);
            /*case 5:
                mTitle = getString(R.string.title_section7);
                break;
            case 6:
                mTitle = getString(R.string.title_section8);
                break;
            /*case 6:
                mTitle = getString(R.string.title_section9);
                break;*/
        }


    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
