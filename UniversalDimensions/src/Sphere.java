public class Sphere extends Shape {
    @SuppressWarnings("FieldMayBeFinal")
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double surface_area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volume() {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return String.format("Object: Planet Earth | Radius: %.2f km\nSurface Area: %.2f sq km | Volume: %.2f cubic km",
                                radius, surface_area(), volume());
    }
}

