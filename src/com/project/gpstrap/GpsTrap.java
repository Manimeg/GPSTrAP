package com.project.gpstrap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class GpsTrap extends Activity {

	static int sourceLat;
	static int sourceLong;
	static int destinationLat;
	static int destinationLong;
    static String retval;
    static int dev_lat;
    static int dev_long;
    static String source;
    static String destination;
    static String dev;
    public	Context q;
    
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpstrap);
        Button button= (Button) findViewById(R.id.button1);
          
        button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			q = getApplicationContext();
				Spinner spinner1=(Spinner) findViewById(R.id.spinner1);
				Spinner spinner2=(Spinner) findViewById(R.id.spinner2);
				source = (String) spinner1.getSelectedItem();
		    	destination = (String) spinner2.getSelectedItem();
		    	
		    	new FetchSQL().execute();
               
				Toast.makeText(q, source,Toast.LENGTH_LONG).show();
				Toast.makeText(q, destination,Toast.LENGTH_LONG).show();
				
				Intent intent= new Intent();
				intent.setClass(GpsTrap.this, Maps.class);
				startActivity(intent);
				
				
				
			}
		});
           }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gpstrap, menu);
        return true;
    }
    
    
     
    private class FetchSQL extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... params) {
            String retval = "";
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                retval = e.toString();
            }
           
            try {
            	String url;
        		url = "jdbc:postgresql://10.0.2.2:5432/db_gpstrap";//+"?sslfactory=org.postgresql.ssl.NonValidatingFactory"+"&ssl=false";
        		Connection conn = DriverManager.getConnection(url,"postgres","postgres");
                Statement st = conn.createStatement();
                
                String sql;
                sql = "SELECT * FROM current_details.device1";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()) {
                	System.out.println("QUERY - sql");
                    retval += rs.getString(1) + "\n" + rs.getString(2) + "\n\n";
                    System.out.println(retval);
                }
                
                String sourceSql;
                sourceSql = "SELECT latitude, longitude FROM locations.locations_details WHERE location_name = '" + source + "'";
                rs = st.executeQuery(sourceSql);
                while(rs.next()) {
                	System.out.println("QUERY - sourceSql");
                    sourceLat = rs.getInt(1);
                    sourceLong = rs.getInt(2);
                    System.out.println(sourceLat + "\t" + sourceLong);
                    retval += "hello";
                }
                
                String destinationSql;
                destinationSql = "SELECT latitude, longitude FROM locations.locations_details WHERE location_name = '" + destination + "'";
                rs = st.executeQuery(destinationSql);
                while(rs.next()) {
                	System.out.println("QUERY - destinationSql");
                    destinationLat = rs.getInt(1);
                    destinationLong =  rs.getInt(2);
                    System.out.println(destinationLat + "\t" + destinationLong);
                    retval += "hiiiiiiii";
                }
                
               
                dev = "device1";
                
      /*          String devicenameSQL = "SELECT " + source + ".device_name FROM Locations." + source + ", Locations." + destination + " WHERE ";/* +
                "WHERE time = (SELECT max(time) from curr_details." + dev +")";*/
     /* rs = st.executeQuery(devicecoordsSQL);
      while(rs.next()){
      	System.out.println("DEVICEcoordsSQL");
      	dev_lat = rs.getInt(1);
      	dev_long = rs.getInt(2);
      	System.out.println(dev_lat + "\t" + dev_long);
      }*/
                String devicecoordsSQL = "SELECT latitude, longitude FROM current_details." + dev;/* +
                          "WHERE time = (SELECT max(time) from curr_details." + dev +")";*/
                rs = st.executeQuery(devicecoordsSQL);
                while(rs.next()){
                	System.out.println("DEVICEcoordsSQL");
                	dev_lat = rs.getInt(1);
                	dev_long = rs.getInt(2);
                	System.out.println(dev_lat + "\t" + dev_long);
                }
                
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                retval = e.toString();
            }
            return retval;
        }
        @Override
        protected void onPostExecute(String value) {
            //System.out.println(value);
        }
    }







}





       
