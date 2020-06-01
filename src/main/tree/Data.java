package main.tree;

public class Data {
    private double x;
    private double y;
    private String type;
    private String name;
    private String address;

    public Data(double x, double y, String type, String name, String address) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.name = name;
        this.address = address;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
