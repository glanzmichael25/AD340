package com.asynchronousnetworkconnectionsapp;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Cameras {

    //declares variables
    private String label;
    private String imageUrl;

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

        public Cameras build() {

            return camera;
        }
    }

    //initiates cameras from JSON Object
    public static Cameras[] initCameras(String data) {

        ArrayList<Cameras> camerasArray = new ArrayList<>();
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

                JSONArray camera = object.getJSONArray("Cameras");

                JSONObject cameraData = camera.getJSONObject(0);

                imageUrl = cameraData.getString("ImageUrl");

                description = cameraData.getString("Description");

                type = cameraData.getString("Type");

                if (type.equalsIgnoreCase("wsdotLink")){

                    imageUrlComplete = wsdotLink + imageUrl;

                } else {
                    imageUrlComplete = sdotLink + imageUrl;

                }

                camerasArray.add(new Cameras.Builder().label(description)
                        .imageUrl(imageUrlComplete)
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