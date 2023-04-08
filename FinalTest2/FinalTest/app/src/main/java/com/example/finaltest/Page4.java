package com.example.finaltest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.microsoft.maps.Geopoint;
import com.microsoft.maps.MapAnimationKind;
import com.microsoft.maps.MapElementLayer;
import com.microsoft.maps.MapRenderMode;
import com.microsoft.maps.MapScene;
import com.microsoft.maps.MapTappedEventArgs;
import com.microsoft.maps.MapView;
import com.microsoft.maps.OnMapTappedListener;

public class Page4 extends Fragment {
    private MapElementLayer mPinLayer;
    private MapView mMapView;
    private static final Geopoint INC_AIRPORT = new Geopoint(37.45683766873818, 126.44357045478996);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = (ViewGroup) inflater.inflate(R.layout.slide_page4, container, false);

        mMapView = new MapView(getContext(), MapRenderMode.VECTOR);
        mMapView.setCredentialsKey("Atv45x1-Ti-sjgNH6mm-TBzZstZ79v1Tfl2ldojTYp2BAJTW05WDljb9sqWdhceQ");
        ((FrameLayout)view.findViewById(R.id.map_view)).addView(mMapView);
        mMapView.setLanguage("ko");
        mMapView.onCreate(savedInstanceState);

        mMapView.setScene(MapScene.createFromLocationAndZoomLevel(INC_AIRPORT, 11), MapAnimationKind.NONE);

        mPinLayer = new MapElementLayer();
        mMapView.getLayers().add(mPinLayer);

        mMapView.addOnMapTappedListener(new OnMapTappedListener() {
            @Override
            public boolean onMapTapped(MapTappedEventArgs mapTappedEventArgs) {
                Geopoint location = mMapView.getLocationFromOffset(mapTappedEventArgs.position);

                Log.e("****", location.getPosition().toString());
                return false;
            }
        });

        return view;
    }
}
