package main.tree;

public class MBR implements Comparable<MBR>{
    private double xLU;
    private double xRL;
    private double yLU;
    private double yRL;
    private double area;


    public MBR(double xLU, double xRL, double yLU, double yRL) {
        this.xLU = xLU;
        this.xRL = xRL;
        this.yLU = yLU;
        this.yRL = yRL;

        double x = xRL-xLU;
        double y = yLU-yRL;

        area = x*y;
    }

    public MBR(){}

    public double getxLU() {
        return xLU;
    }

    public void setxLU(double xLU) {
        this.xLU = xLU;
    }

    public double getxRL() {
        return xRL;
    }

    public void setxRL(double xRL) {
        this.xRL = xRL;
    }

    public double getyLU() {
        return yLU;
    }

    public double getyRL() {
        return yRL;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "MBR{" +
                "xLU=" + xLU +
                ", yLU=" + yLU +
                ", xRL=" + xRL +
                ", yRL=" + yRL +
                ", area=" + area +
                '}';
    }


    @Override
    public int compareTo(MBR o) {
        return Double.compare(this.area, o.area);
    }
}
