package com.github.ystromm.learn_quickcheck.job.conversion;

import com.github.ystromm.learn_quickcheck.job.ad.Location;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.util.Optional;

public class GetLocation {
    Optional<Location> getLocation(String address) {

        final GeoApiContext geoApiContext = new GeoApiContext();
        final GeocodingApiRequest geocodingApiRequest = GeocodingApi.geocode(geoApiContext, address);

        try {
            final GeocodingResult[] geocodingResults = geocodingApiRequest.await();
            if (geocodingResults.length > 0) {
                final LatLng latLng = geocodingResults[0].geometry.location;
                return Optional.of(Location.builder().latitude(latLng.lat).longitude(latLng.lng).build());
            }
            else {
                return Optional.empty();
            }
        } catch (Exception e) {
            // todo unknown location?
            throw new IllegalStateException(e);
        }
    }
}
