package exercise;

// BEGIN
public class Cottage implements Home{
    private double area;
    private int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
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
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
