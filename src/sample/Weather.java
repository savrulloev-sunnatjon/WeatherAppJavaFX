package sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("astronomy")
    @Expose
    private List<Astronomy> astronomy = null;
    @SerializedName("maxtempC")
    @Expose
    private String maxtempC;
    @SerializedName("maxtempF")
    @Expose
    private String maxtempF;
    @SerializedName("mintempC")
    @Expose
    private String mintempC;
    @SerializedName("mintempF")
    @Expose
    private String mintempF;
    @SerializedName("avgtempC")
    @Expose
    private String avgtempC;
    @SerializedName("avgtempF")
    @Expose
    private String avgtempF;
    @SerializedName("totalSnow_cm")
    @Expose
    private String totalSnowCm;
    @SerializedName("sunHour")
    @Expose
    private String sunHour;
    @SerializedName("uvIndex")
    @Expose
    private String uvIndex;
    @SerializedName("hourly")
    @Expose
    private List<Hourly> hourly = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Astronomy> getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(List<Astronomy> astronomy) {
        this.astronomy = astronomy;
    }

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(String maxtempF) {
        this.maxtempF = maxtempF;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public String getMintempF() {
        return mintempF;
    }

    public void setMintempF(String mintempF) {
        this.mintempF = mintempF;
    }

    public String getAvgtempC() {
        return avgtempC;
    }

    public void setAvgtempC(String avgtempC) {
        this.avgtempC = avgtempC;
    }

    public String getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempF(String avgtempF) {
        this.avgtempF = avgtempF;
    }

    public String getTotalSnowCm() {
        return totalSnowCm;
    }

    public void setTotalSnowCm(String totalSnowCm) {
        this.totalSnowCm = totalSnowCm;
    }

    public String getSunHour() {
        return sunHour;
    }

    public void setSunHour(String sunHour) {
        this.sunHour = sunHour;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

}