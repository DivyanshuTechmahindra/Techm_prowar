package uk.prudentialwarnew.profileview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by user on 8/13/2016.
 */
public class Fragment_profileview extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    double latitude;
    double longitude;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profileview, container, false);

        GPSTracker mGPSTracker = new GPSTracker(getActivity().getApplicationContext());
        double lat = mGPSTracker.getLatitude();
        double lng = mGPSTracker.getLongitude();

        latitude = lat;//Double.parseDouble((getIntent().getStringExtra("latitude")) != null ? getIntent().getStringExtra("latitude") : lat+"");
        longitude = lng;//Double.parseDouble((getIntent().getStringExtra("longitude")) != null ? getIntent().getStringExtra("longitude") : lng+"");
//        societyName = getIntent().getStringExtra("name");
//        societyAddress = getIntent().getStringExtra("address");
//        societyId = getIntent().getStringExtra("id");





        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
//        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
//                .findFragmentById(R.id.map);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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


}
