import java.util.Comparator;

class NameComparator implements Comparator<MeddlingKid> {
    @SuppressWarnings("override")
    public int compare(MeddlingKid m1, MeddlingKid m2) {
        return m1.getName().compareTo(m2.getName());
    }
}

class RollNoComparator implements Comparator<MeddlingKid> {
    @SuppressWarnings("override")
    public int compare(MeddlingKid m1, MeddlingKid m2) {
        return m1.getRollno() - m2.getRollno();
    }
}