package backbeans;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

@Named(value = "FindUsersByGoogleMapsBean")
@ViewScoped
public class FindUsersByGoogleMapsBean {

    private final static String API_KEY = "AIzaSyBCZQIyjWllsiodB4cyCvaFOqLw3zxQsNI";

    String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public FindUsersByGoogleMapsBean() {
    }

    private String sendPost(String origin, String destination) {

        try {
            String url = "https://maps.googleapis.com/maps/api/distancematrix/json";
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", req.getHeader("User-Agent"));
            con.setRequestProperty("Accept-Language", req.getHeader("Accept-Language"));

            String urlParameters = "units=imperial&origins=" + origin + "&destinations=" + destination + "&key=" + API_KEY;

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(urlParameters);
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            this.response = response.toString();

        } catch (Exception e) {
        }
        return this.response;
    }

    public String test() {
        return this.sendPost("Kielce", "Warszawa");
    }

}
