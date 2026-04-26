public class MeddlingKid {
    @SuppressWarnings("FieldMayBeFinal")
    private int rollno;
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private String address;

    public MeddlingKid(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() { return rollno; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("| %-5d | %-12s | %-20s |", rollno, name, address);
    }
}