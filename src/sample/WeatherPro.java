package sample;
import com.google.gson.Gson;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class WeatherPro {
    private final String url;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    Gson gson;
    Result result;

    public WeatherPro(String url) throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        gson = new Gson();
        result = gson.fromJson(response.body(), Result.class);
        this.url = url;
    }

    public int[] getWeekWeather(){
        if (response.statusCode() != 400 & response.statusCode() != 401){
            int []temp = new int[7];
            int i = 0;
            for (Weather weather: result.getData().getWeather()){
                temp[i] = Integer.parseInt(weather.getAvgtempC());
                System.out.println(weather.getAvgtempC());
                i++;
            }
            return temp;
        }
        return null;
    }

    public int getCurrentWeather(){
        if (response.statusCode() != 400 & response.statusCode() != 401){
            List<CurrentCondition> list = result.getData().getCurrentCondition();
            return Integer.parseInt(list.get(0).getTempC());
        }else {
            System.out.println("400 Error");
            return 0;
        }
    }

    public String getCurrentCity(){
        if (response.statusCode() != 400 & response.statusCode() != 401){
            List<Request> request = result.getData().getRequest();
            return request.get(0).getQuery();
        }else {
            System.out.println("400 Error");
            return null;
        }
    }

    public Image getConditionImage(int index){
        String urlImage = result.getData().getWeather().get(index).getHourly().get(0).getWeatherIconUrl().get(0).getValue();
        Image image = new Image(urlImage);
        return image;
    }
}
