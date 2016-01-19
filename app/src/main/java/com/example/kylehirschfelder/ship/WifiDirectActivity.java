package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WifiDirectActivity extends AppCompatActivity implements WifiP2pManager.PeerListListener, WifiP2pManager.ConnectionInfoListener, WifiP2pManager.GroupInfoListener {

    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;
    MyBroadcastReceiver mReceiver;
    public  static final String TAG = "log";
    IntentFilter mIntentFilter;
    Button btn, btnConnect;
    ArrayList<HashMap<String,String>> list2 = new ArrayList<HashMap<String,String>>();
    public List peers = new ArrayList();
    Bundle bundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_direct);

        btn = (Button) findViewById(R.id.button);
        btnConnect = (Button) findViewById(R.id.btn2);
        btnConnect.setVisibility(View.GONE);


        Intent intent = this.getIntent();
        Bundle bundle = getIntent().getExtras();


        list2 = (ArrayList<HashMap<String, String>>) bundle.getSerializable("map");
        Log.println(Log.ASSERT, "LIST2 SIZE: ", String.valueOf(list2.size()));
        //Handles Wifi connection
        WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        manager.setWifiEnabled(false);
        Log.println(Log.ASSERT, TAG, "Resetting WIFI");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        manager.setWifiEnabled(true);
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this,getMainLooper(),null);
        mReceiver = new MyBroadcastReceiver(mManager,mChannel,this);

        deletePersistentGroups();

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi.disconnect();
        DisconnectWifi discon = new DisconnectWifi(wifi);
        registerReceiver(discon, new IntentFilter(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION));



        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
                    @Override
                    public void onSuccess() {
                        Log.println(Log.ASSERT,TAG,"Discovery process success");

                    }

                    @Override
                    public void onFailure(int i) {
                        Log.println(Log.ASSERT,TAG,"Discovery process failed");
                        Log.println(Log.ASSERT,TAG,String.valueOf(i));
                    }
                });
            }
        });
    }

    @Override   //Register broadcast receiver with intent values
    protected void onResume(){
        super.onResume();
        registerReceiver(mReceiver,mIntentFilter);
    }

    @Override   //Register broadcast receiver with intent values
    protected void onPause(){
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    @Override
    public void onPeersAvailable(WifiP2pDeviceList wifiP2pDeviceList) {

        peers.clear();
        peers.addAll(wifiP2pDeviceList.getDeviceList());

        if (peers.size() == 0) {
            Log.println(Log.ASSERT, TAG, "0 Devices found");
            return;
        } else {
            Log.println(Log.ASSERT, TAG, String.valueOf(peers.size()) + " Devices found");
            Toast.makeText(WifiDirectActivity.this, "Connect and Transfer now", Toast.LENGTH_SHORT).show();
            btnConnect.setVisibility(View.VISIBLE);
            //connect();
        }
    }

    public void connect(){

        // Picking the first device found on the network.
        if(peers.size() < 1) return;
        WifiP2pDevice device = (WifiP2pDevice) peers.get(0);
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = WpsInfo.PBC;
        config.groupOwnerIntent = 0;
        Log.println(Log.ASSERT,"LOG","Before connecting to the tablet");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mManager.connect(mChannel, config, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                // WiFiDirectBroadcastReceiver will notify us. Ignore for now.
                Log.println(Log.ASSERT,"Log","success connecting");

            }
            @Override
            public void onFailure(int reason) {
                // Toast.makeText(WiFiDirectActivity.this, "Connect failed. Retry.",
                // Toast.LENGTH_SHORT).show();
                Log.println(Log.ASSERT, "log", "connecting failed " + String.valueOf(reason));
            }
        });
    }

    @Override
    public void onConnectionInfoAvailable(final WifiP2pInfo info){
        InetAddress groupOwnerAddress = info.groupOwnerAddress;
        Log.println(Log.ASSERT,TAG,"Connection info available");
        if(info.groupFormed) {
            Log.println(Log.ASSERT, TAG, "This is group client");
            Log.println(Log.ASSERT, TAG, groupOwnerAddress.getHostAddress());


/*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
            new FileServerAsyncTask(getApplicationContext(),groupOwnerAddress.getHostAddress(),this,list2).execute();

            mManager.stopPeerDiscovery(mChannel, new WifiP2pManager.ActionListener() {
                @Override
                public void onSuccess() {
                    Log.println(Log.ASSERT, "Log", "Peer discovery stopped");
                }

                @Override
                public void onFailure(int reason) {
                    Log.println(Log.ASSERT, "Log", "Peer discovery continues");

                }
            });
        }
    }

    @Override
    public void onGroupInfoAvailable(WifiP2pGroup group){
        //connect();
        Log.println(Log.ASSERT, "Group formed: ", "Connect Now...");
        Toast.makeText(WifiDirectActivity.this, "Group Formed. Connect Now..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wifi_direct, menu);
        return true;
    }

    public void deletePersistentGroups(){
        try {
            Method[] methods = WifiP2pManager.class.getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals("deletePersistentGroup")) {
                    // Delete any persistent group
                    for (int netid = 0; netid < 32; netid++) {
                        methods[i].invoke(mManager, mChannel, netid, null);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
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

    public static class FileServerAsyncTask extends AsyncTask <Object,Void,String> {

        Context context;
        String host;
        int port = 8888;
        int len;
        Socket socket = new Socket();
        byte buf[] = new byte[1024];
        //Activity main;
        ArrayList<HashMap<String,String>> data;

        WifiDirectActivity mActivity;
        public FileServerAsyncTask(Context context, String host, WifiDirectActivity mActivity, ArrayList<HashMap<String,String>> data) {
            //  this.main = main;
            this.context = context;
            this.host = host;
            this.mActivity = mActivity;
            this.data = data;
        }

        @Override
        protected String doInBackground(Object[] objects) {
            Log.println(Log.ASSERT, "Tag", "Here");

            if (host != null) {
                Log.println(Log.ASSERT, "HOST:", host);
                try {
                    //String data = "Sending this motherfucking string";
                    socket.bind(null);
                    socket.connect((new InetSocketAddress(host, port)), 8000);
                    //String data ="This is the data";

                    ArrayList<HashMap<String,String>>  map = this.data;
                    // map.put("Mayank","Kale");
                    // map.put("Kyle","CS GOD");

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutput out = null;
                    out = new ObjectOutputStream(bos);
                    out.writeObject(map);
                    byte[] array = bos.toByteArray();
                    // buf = data.getBytes();
                    OutputStream outputStream = socket.getOutputStream();
                    int len = array.length;
                    outputStream.write(array, 0 , len);

                    outputStream.close();
                    bos.close();
                    /*
                    main.function_count++;
                    MyAppApplication.count++;
                    buf = data.getBytes();
                    int len = buf.length;
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(buf, 0, len);
                    outputStream.close();
                    */
                    socket.close();
                    mActivity.deletePersistentGroups();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = null;
            MemberDataInterface sync = new MemberDataInterface(context);
            /*try {
                sync.setAllSync(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
            String activityFlag = mActivity.getIntent().getStringExtra("activityFlag");
            if(activityFlag.equals("1"))
            {
                intent = new Intent(this.mActivity,HouseTransferList.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction(android.content.Intent.ACTION_VIEW);
                this.context.startActivity(intent);

            }
            else if(activityFlag.equals("2"))
                Log.println(Log.ASSERT,"Flag","is two");


        }
    }
    public class DisconnectWifi extends BroadcastReceiver {
    WifiManager wifi;
        DisconnectWifi(WifiManager wifi){
            this.wifi = wifi;
        }
        @Override
        public void onReceive(Context c, Intent intent) {
            if(!intent.getParcelableExtra(wifi.EXTRA_NEW_STATE).toString().equals(SupplicantState.SCANNING)) wifi.disconnect();
        }
    }

    private class TimerTask extends AsyncTask<Integer,Void,Void>{
        private long time;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            time = System.currentTimeMillis();
        }

        @Override
        protected Void doInBackground(Integer... params){

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            Log.println(Log.ASSERT,"in","postExec");
            Button connect = (Button) findViewById(R.id.btn2);
            connect.setVisibility(View.VISIBLE);
        }

    }
}