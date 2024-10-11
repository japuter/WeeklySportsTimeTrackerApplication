import java.util.ArrayList;
import java.util.Scanner;

class SportActivity {
    private String sportName;
    private String date;
    private int duration;  // in minutes

    public SportActivity(String sportName, String date, int duration) {
        this.sportName = sportName;
        this.date = date;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return "Sport: " + sportName + ", Date: " + date + ", Duration: " + duration + " minutes";
    }
}

public class SportsTimeTracker {
    private static ArrayList<SportActivity> activities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Log a sport activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    logActivity(scanner);
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    calculateTotalTime();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void logActivity(Scanner scanner) {
        System.out.print("Enter sport name: ");
        String sportName = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter duration (minutes): ");
        int duration = scanner.nextInt();
        activities.add(new SportActivity(sportName, date, duration));
        System.out.println("Activity logged.");
    }

    private static void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged.");
        } else {
            for (SportActivity activity : activities) {
                System.out.println(activity);
            }
        }
    }

    private static void calculateTotalTime() {
        int totalTime = 0;
        for (SportActivity activity : activities) {
            totalTime += activity.getDuration();
        }
        System.out.println("Total time spent on sports this week: " + totalTime + " minutes");
    }
}
