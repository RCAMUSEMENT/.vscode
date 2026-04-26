import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CoolsvilleRegistrar {

    // Custom Selection Sort
    public static void ghostlySort(ArrayList<MeddlingKid> list, Comparator<MeddlingKid> clue) {
        for (int i = 0; i < list.size() - 1; i++) {
            int trapIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (clue.compare(list.get(j), list.get(trapIndex)) < 0) {
                    trapIndex = j;
                }
            }
            MeddlingKid scoobySnack = list.get(trapIndex);
            list.set(trapIndex, list.get(i));
            list.set(i, scoobySnack);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<MeddlingKid> mysteryGang = new ArrayList<>();

            mysteryGang.add(new MeddlingKid(105, "Fred", "Mystery Machine"));
            mysteryGang.add(new MeddlingKid(102, "Daphne", "Fashion Way"));
            mysteryGang.add(new MeddlingKid(108, "Velma", "Library Ave"));
            mysteryGang.add(new MeddlingKid(101, "Shaggy", "Snack Street"));
            mysteryGang.add(new MeddlingKid(110, "Scooby", "Snack Street"));
            mysteryGang.add(new MeddlingKid(104, "Red Herring", "Bully Lane"));
            mysteryGang.add(new MeddlingKid(103, "Scrappy", "Puppy Ct"));
            mysteryGang.add(new MeddlingKid(107, "Flim Flam", "Magic Cir"));
            mysteryGang.add(new MeddlingKid(109, "Vincent", "Spooky Rd"));
            mysteryGang.add(new MeddlingKid(106, "Crystal", "Alien Ave"));

            boolean unmasking = true;
            while (unmasking) {
                System.out.println("\n--- Coolsville High Registrar ---");
                System.out.println("1. Unmask All Meddling Kids (View)");
                System.out.println("2. Sort by Name");
                System.out.println("3. Sort by Roll Number");
                System.out.println("4. Close Case (Exit)");
                System.out.print("What's the plan, Gang? ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> mysteryGang.forEach(System.out::println);
                    case 2 -> {
                        ghostlySort(mysteryGang, new NameComparator());
                        System.out.println("Sorted by Name!");
                    }
                    case 3 -> {
                        ghostlySort(mysteryGang, new RollNoComparator());
                        System.out.println("Sorted by Roll Number!");
                    }
                    case 4 -> {
                        unmasking = false;
                        System.out.println("Case Closed! Zoinks!");
                    }
                    default -> System.out.println("Ruh-roh! Not a valid choice.");
                }
            }
        }
    }
}
