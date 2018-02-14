package com.liftoff.spots.models;

import com.google.maps.internal.StringJoin.UrlValue;
import java.io.Serializable;
import java.util.Locale;

/** A place on Earth, represented by a latitude/longitude pair. */
public class LatLng implements UrlValue, Serializable {

    private static final long serialVersionUID = 1L;

    /** The latitude of this location. */
    public double lat;

    /** The longitude of this location. */
    public double lng;

    /**
     * Constructs a location with a latitude/longitude pair.
     *
     * @param lat The latitude of this location.
     * @param lng The longitude of this location.
     */
    public LatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /** Serialisation constructor. */
    public LatLng() {}

    @Override
    public String toString() {
        return toUrlValue();
    }

    @Override
    public String toUrlValue() {
        // Enforce Locale to English for double to string conversion
        return String.format(Locale.ENGLISH, "%.8f,%.8f", lat, lng);
    }
}
