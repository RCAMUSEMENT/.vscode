public class Cylinder extends Shape {
    @SuppressWarnings("FieldMayBeFinal")
    private double radius;
    @SuppressWarnings("FieldMayBeFinal")
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return String.format("Object: AA Battery | Radius: %.2f mm | Height: %.2f mm\nSurface Area: %.2f sq mm | Volume: %.2f cubic mm",
                                radius, height, surface_area(), volume());
    }
}

