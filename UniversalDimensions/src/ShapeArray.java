public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[3];

        shapeArray[0] = new Sphere(6371); // Earth radius in km
        shapeArray[1] = new Cylinder(7.25, 50.5); // AA Battery in mm
        shapeArray[2] = new Cone(10, 25); // A tall Gnome Hat in cm

        for (Shape s : shapeArray) {
            System.out.println(s.toString());
            System.out.println("--------------------------------------------------");
        }
    }
}