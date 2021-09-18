// Packages to make URL request
import java.io.InputStream;
import com.google.gson.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GettingData {
    public JsonElement returnCode(String currencyCode) throws Exception {
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/d45b92e27aa87499e7e712c7/latest/USD";

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
        JsonObject req_result = (JsonObject) jsonobj.get("conversion_rates");

        return (req_result.get(currencyCode));
    }

    public static void main(String[] args) throws Exception {
        GettingData obj = new GettingData();
        String j = "USD";

        System.out.println (obj.returnCode(j));
        //inside the empty brackets we need to figure out how to input the user input
        //System.out.println(exchangeRate(obj.returnCode(), obj.returnCode(), moneyAmount));
    }
    
    public static double exchangeRate(double currencyFrom, double currencyTo, double moneyAmount) {
        double exchangeRate = currencyTo / currencyFrom;
        return moneyAmount * exchangeRate;
    }
}
