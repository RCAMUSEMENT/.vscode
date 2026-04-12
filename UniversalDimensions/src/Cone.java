/**
 * Represents a conical object. In this project, it models a whimsical Gnome's Hat.
 */
public class Cone extends Shape {
    @SuppressWarnings("FieldMayBeFinal")
    private double radius;
    @SuppressWarnings("FieldMayBeFinal")
    private double height;

    /**
     * @param radius The radius of the cone's circular base.
     * @param height The height from base to apex.
     */
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {
        return (1.0/3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return String.format("Object: Gnomeo's Pointy Hat | Base Radius: %.2f cm | Height: %.2f cm\nSurface Area: %.2f sq cm | Volume: %.2f cubic cm",
                                radius, height, surface_area(), volume());
    }
}