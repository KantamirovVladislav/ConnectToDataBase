package com.example.connecttodatabase;

public class Medicines {
    private String idMedicines;
    private String Name;
    private double Price;

    public Medicines() {
    }

    private String Features;
    private int count;

    public String getIdMedicines() {
        return idMedicines;
    }

    public void setIdMedicines(String idMedicines) {
        this.idMedicines = idMedicines;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getFeatures() {
        return Features;
    }

    public void setFeatures(String features) {
        Features = features;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Medicines(String idMedicines, String name, double price, String features, int count) {
        this.idMedicines = idMedicines;
        Name = name;
        Price = price;
        Features = features;
        this.count = count;
    }


}
