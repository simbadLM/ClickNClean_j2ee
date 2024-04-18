package tools;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class APOD {
    public final String type;
    public final String version;
    public final List<Feature> features;
    public final String attribution;
    public final String licence;
    public final String query;
    public final int limit;

    public APOD(
        @JsonProperty("type") String type,
        @JsonProperty("version") String version,
        @JsonProperty("features") List<Feature> features,
        @JsonProperty("attribution") String attribution,
        @JsonProperty("licence") String licence,
        @JsonProperty("query") String query,
        @JsonProperty("limit") int limit
    ) {
        this.type = type;
        this.version = version;
        this.features = features;
        this.attribution = attribution;
        this.licence = licence;
        this.query = query;
        this.limit = limit;
    }

    public static class Feature {
        public final String type;
        public final Geometry geometry;
        public final Properties properties;

        public Feature(
            @JsonProperty("type") String type,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Properties properties
        ) {
            this.type = type;
            this.geometry = geometry;
            this.properties = properties;
        }
    }

    public static class Geometry {
        public final String type;
        public final ArrayList<Double> coordinates;

        public Geometry(
            @JsonProperty("type") String type,
            @JsonProperty("coordinates") ArrayList<Double> coordinates
        ) {
            this.type = type;
            this.coordinates = coordinates;
        }
    }

    public static class Properties {
        public final String label;
        public final double score;
        public final String housenumber;
        public final String id;
        public final String featureType;
        public final String name;
        public final String postcode;
        public final String citycode;
        public final double x;
        public final double y;
        public final String city;
        public final String context;
        public final double importance;
        public final String street;

        public Properties(
            @JsonProperty("label") String label,
            @JsonProperty("score") double score,
            @JsonProperty("housenumber") String housenumber,
            @JsonProperty("id") String id,
            @JsonProperty("type") String featureType,
            @JsonProperty("name") String name,
            @JsonProperty("postcode") String postcode,
            @JsonProperty("citycode") String citycode,
            @JsonProperty("x") double x,
            @JsonProperty("y") double y,
            @JsonProperty("city") String city,
            @JsonProperty("context") String context,
            @JsonProperty("importance") double importance,
            @JsonProperty("street") String street
        ) {
            this.label = label;
            this.score = score;
            this.housenumber = housenumber;
            this.id = id;
            this.featureType = featureType;
            this.name = name;
            this.postcode = postcode;
            this.citycode = citycode;
            this.x = x;
            this.y = y;
            this.city = city;
            this.context = context;
            this.importance = importance;
            this.street = street;
        }
    }
}
