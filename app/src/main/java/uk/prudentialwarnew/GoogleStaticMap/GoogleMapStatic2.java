package uk.prudentialwarnew.GoogleStaticMap;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 8/13/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import uk.prudentialwarnew.R;
import uk.prudentialwarnew.utils.GPSTracker;

public class GoogleMapStatic2 extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    double latitude;
    double longitude;
    String societyName, societyAddress, societyId;
    TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map_static);

        GPSTracker mGPSTracker = new GPSTracker(GoogleMapStatic2.this);
        double lat = mGPSTracker.getLatitude();
        double lng = mGPSTracker.getLongitude();

        latitude = Double.parseDouble((getIntent().getStringExtra("latitude")) != null ? getIntent().getStringExtra("latitude") : lat+"");
        longitude = Double.parseDouble((getIntent().getStringExtra("longitude")) != null ? getIntent().getStringExtra("longitude") : lng+"");
        societyName = getIntent().getStringExtra("name");
        societyAddress = getIntent().getStringExtra("address");
        societyId = getIntent().getStringExtra("id");


        address = (TextView) findViewById(R.id.address);
        address.setText(societyName + "\n" + societyAddress);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
//        setupActionBar();
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng noida = new LatLng(28.5700, 77.3200);
        LatLng noida = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(noida).title("Your Address").icon(BitmapDescriptorFactory.fromResource(R.drawable.address_ico)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(noida));
        mMap.isMyLocationEnabled();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(noida, 15));
    }

    public void btnNO(View view) {
        finish();
    }

    public void btnYES(View view) {

    }
}
