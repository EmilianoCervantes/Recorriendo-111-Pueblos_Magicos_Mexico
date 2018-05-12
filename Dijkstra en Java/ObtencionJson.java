import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ObtencionJson {
    public void setURL(String puebloInicial, String[] destinos){
        String urlDestinos = "";
        for(int i = 0; destinos.length; i++){
            urlDestinos+= destinos[i]+"|";
        }
        jsonMap("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+puebloInicial+"&destinations="+destinos+"&key=AIzaSyB2vj6e3SsNUFPhGCEF9dazLKMWLAKYP3c");
    }

    private void jsonMap(String url){
        //Limpie el adapatador
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for(int i = 0; i < jsonArray.length();i++){
                        JSONObject jsonObject01 = jsonArray.getJSONObject(i);
                        JSONObject gemoetry = jsonObject01.getJSONObject("geometry");
                        JSONObject location = gemoetry.getJSONObject("location");
                        double lat = location.getDouble("lat");
                        double lon = location.getDouble("lng");
                        LatLng cdmxRestaurantes = new LatLng(lat, lon);
                        mMap.addMarker(new MarkerOptions().position(cdmxRestaurantes).title("Restaurante"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(cdmxRestaurantes));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
            }
        });
    }
}