package edu.cityu.ds.report.entity;

public class City {

    private Integer cityId;

    private String city;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                '}';
    }
}
