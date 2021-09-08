package kg.TestTask.dao;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class ResponseObject {
    private String currency;
    private Double course;
    private String image;
    private String date;

    public ResponseObject() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ResponseObject(String currency, Double course, String image, String date) {
        this.currency = currency;
        this.course = course;
        this.date = date;
        this.image=image;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
