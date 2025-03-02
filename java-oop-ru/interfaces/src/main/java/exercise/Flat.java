package exercise;

// BEGIN
public class Flat implements Home{
    private double area;
    private double balconyArea;
    private int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home home) {
        if (getArea() > home.getArea()) {
            return 1;
        } else if (getArea() < home.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "Квартира площадью " + (area + balconyArea) + " метров на " + floor + " этаже";
    }
}
// END
