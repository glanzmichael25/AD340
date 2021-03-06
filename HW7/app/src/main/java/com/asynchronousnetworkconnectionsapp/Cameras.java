package com.asynchronousnetworkconnectionsapp;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Cameras {

    //declares variables
    private Double latitude;
    private Double longitude;
    private String label;
    private String imageUrl;

    //gets Latitude
    public Double getLatitude() {

        return  latitude; }

    //gets Longitude
    public Double getLongitude() {

        return longitude; }

    //sets label
    public Cameras(String label) {

        this.label = label;
    }

    //gets Url
    public String getImageUrl() {

        return imageUrl;
    }

    //gets label
    public String getLabel() {

        return label;
    }

    //builders cameras
    public static class Builder {
        Cameras camera;

        public Builder() {

            camera = new Cameras("");
        }

        public Builder label(String label) {
            camera.label = label;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            camera.imageUrl = imageUrl;
            return this;
        }


        public Builder latitude(Double latitude) {
            camera.latitude = latitude;
            return this;
        }

        public Builder longitude(Double longitude) {
            camera.longitude = longitude;
            return this;
        }

        public Cameras build() {

            return camera;
        }
    }

    //initiates cameras from JSON Object
    public static Cameras[] initCameras(String data) {

        ArrayList<Cameras> camerasArray = new ArrayList<>();
        Double latitude;
        Double longitude;
        String imageUrl;
        String imageUrlComplete;
        String description;
        String type;
        String sdotLink = "http://www.seattle.gov/trafficcams/images/";
        String wsdotLink = "http://images.wsdot.wa.gov/nw/";

        //generates JSON objects
        try {

            JSONObject initJSONObject = new JSONObject(data);
            JSONArray JSONdata = initJSONObject.getJSONArray("Features");

            for (int i=0; i < JSONdata.length(); i++) {

                JSONObject object = JSONdata.getJSONObject(i);

                //Lat Lon Coordinates
                JSONArray location = object.getJSONArray("PointCoordinate");
                latitude = location.getDouble(0);
                longitude = location.getDouble(1);

                //gets camera from object
                JSONArray camera = object.getJSONArray("Cameras");
                //gets data from object
                JSONObject cameraData = camera.getJSONObject(0);
                //gets image
                imageUrl = cameraData.getString("ImageUrl");
                //gets description
                description = cameraData.getString("Description");
                //gets type
                type = cameraData.getString("Type");
                //chooses link
                if (type.equalsIgnoreCase("wsdotLink")){

                    imageUrlComplete = wsdotLink + imageUrl;

                } else {
                    imageUrlComplete = sdotLink + imageUrl;

                }
                //builds cameras
                camerasArray.add(new Cameras.Builder().label(description)
                        .imageUrl(imageUrlComplete)
                        .latitude(latitude)
                        .longitude(longitude)
                        .build());
            }

        } catch (Exception e) {

        }
        //returns camera array
        Cameras[] cameras = new Cameras[camerasArray.size()];
        cameras = camerasArray.toArray(cameras);
        return cameras;
    }
}