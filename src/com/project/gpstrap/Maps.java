package com.project.gpstrap;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Maps extends MapActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapView mapView = (MapView) findViewById(R.id.mapview1);
        mapView.setSatellite(true);
        mapView.setBuiltInZoomControls(true);
        MapController mapController = mapView.getController();
        
        mapController.setZoom(16);
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.pin);
        HelloItemizedOverlay sourceItemizedoverlay = new HelloItemizedOverlay(drawable, this);
        HelloItemizedOverlay destinationItemizedoverlay = new HelloItemizedOverlay(drawable, this);
        HelloItemizedOverlay deviceItemizedoverlay = new HelloItemizedOverlay(drawable, this);
        
        // Page1 page= new Page1();
        
        //Toast.makeText(page, page.lat,Toast.LENGTH_LONG).show();
        
        GeoPoint source = new GeoPoint(GpsTrap.sourceLat,GpsTrap.sourceLong);
        OverlayItem sourceOverlayitem = new OverlayItem(source, "Source:", GpsTrap.source);
          
        mapController.setCenter(source);
        
        GeoPoint destination = new GeoPoint(GpsTrap.destinationLat,GpsTrap.destinationLong);
        OverlayItem destinationOverlayitem = new OverlayItem(destination, "Destination:", GpsTrap.destination);
       // mapController.animateTo(new GeoPoint(16486428,70692976));
       // mapView.invalidate();
        
        GeoPoint device = new GeoPoint(GpsTrap.dev_lat,GpsTrap.dev_long);
        OverlayItem deviceOverlayitem = new OverlayItem(device, "Device:", "!!!");
        
        
        sourceItemizedoverlay.addOverlay(sourceOverlayitem);
        mapOverlays.add(sourceItemizedoverlay);
        
        destinationItemizedoverlay.addOverlay(destinationOverlayitem);
        mapOverlays.add(destinationItemizedoverlay);
        
        deviceItemizedoverlay.addOverlay(deviceOverlayitem);
        mapOverlays.add(deviceItemizedoverlay);
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gpstrap, menu);
        return true;
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
}
