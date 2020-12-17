package sample;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Controller extends Thread{
    public Label currentWeather;
    public Label currentTime;
    public Label currentCity;
    public Label firstDay = new Label();
    public Label secondDay = new Label();
    public Label thirdDay = new Label();
    public Label fourthDay = new Label();
    public Label fifthDay = new Label();
    public Label sixthDay = new Label();
    public Label firstWeather;
    public Label secondWeather;
    public Label thirdWeather;
    public Label fourthWeather;
    public Label fifthWeather;
    public Label sixthWeather;
    public TextField searchCity;
    public ImageView searchButton;
    public TimeManagement timeManagement;
    public int[] tempData;
    public int currentW;
    public int condition = -1;
    public int index = 0, i = 0, k=0;
    public List<Label> days = new LinkedList<>();
    public String[] weekDays = {"SUN","MON","TUE","WEN","THU","FRI","SAT"};
    public ImageView mainWeatherCondition;
    public ImageView sixthCondition;
    public ImageView fifthCondition;
    public ImageView fourthCondition;
    public ImageView thirdCondition;
    public ImageView secondCondition;
    public ImageView firstCondition;

    @FXML
    void initialize(){
        days.add(firstDay);
        days.add(secondDay);
        days.add(thirdDay);
        days.add(fourthDay);
        days.add(fifthDay);
        days.add(sixthDay);
        searchCity.setVisible(condition != -1);
        WeatherPro weather = null;
        try {
            weather = new WeatherPro("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=59834e9cf85f4110a15215525201411&type=city&q=Kazan&num_of_days=7&tp=24&format=json");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        tempData = weather.getWeekWeather();
        currentW = weather.getCurrentWeather();
        timeManagement = new TimeManagement();
        currentWeather.setText(currentW + "⁰");
        currentTime.setText("");
        weatherData(weather);
        index = timeManagement.getWeek();
        i=0;
        k=index-1;
        for (int j = 0; j < days.size(); j++){
            if (k + 1 > 6){
                k = 0;
            }else {
                k++;
            }
            days.get(i).setText(weekDays[k]);
            i++;
        }
        searchButton.setOnMouseClicked(mouseEvent -> {
            condition *= -1;
            searchCity.setVisible(condition != -1);
        });
        clock();
        searchCity.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                if (searchCity.getText()!=null){
                    WeatherPro weather1 = null;
                    try {
                        weather1 = new WeatherPro("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=59834e9cf85f4110a15215525201411&type=city&q="+searchCity.getText()+"&num_of_days=7&tp=24&format=json");
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(searchCity.getText());
                    tempData = weather1.getWeekWeather();
                    currentW = weather1.getCurrentWeather();
                    System.out.println(currentW);
                    currentWeather.setText(currentW+"⁰");
                    weatherData(weather1);
                }
            }
        });
    }

    private void weatherData(WeatherPro weather1) {
        currentCity.setText(weather1.getCurrentCity());
        firstWeather.setText(tempData[0]+"⁰");
        secondWeather.setText(tempData[1]+"⁰");
        thirdWeather.setText(tempData[2]+"⁰");
        fourthWeather.setText(tempData[3]+"⁰");
        fifthWeather.setText(tempData[4]+"⁰");
        sixthWeather.setText(tempData[5]+"⁰");
        firstCondition.setImage(weather1.getConditionImage(1));
        secondCondition.setImage(weather1.getConditionImage(2));
        thirdCondition.setImage(weather1.getConditionImage(3));
        fourthCondition.setImage(weather1.getConditionImage(4));
        fifthCondition.setImage(weather1.getConditionImage(5));
        sixthCondition.setImage(weather1.getConditionImage(6));
        mainWeatherCondition.setImage(weather1.getConditionImage(0));
    }

    public void clock(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            Date currentT = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            currentTime.setText(formatter.format(currentT));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}