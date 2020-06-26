package main.phone;

import java.io.Serializable;

public class TableData implements Serializable {
    private int num;
    private String type;
    private String brand;
    private String dateTime;

    public TableData(int num, String type, String brand, String dateTime) {
        this.num = num;
        this.type = type;
        this.brand = brand;
        this.dateTime = dateTime;
    }

    public int getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "TableData[" +
            "num=" + num +
            ", type=" + type +
            ", brand=" + brand +
            ", dateTime=" + dateTime +
            "]";
    }
}
