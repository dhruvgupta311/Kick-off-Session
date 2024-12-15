import java.util.*;

class WeekDay {
    String day;
    String date;

    WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    @Override
    public String toString() {
        return day + ": " + date;
    }
}

class Week {
    Queue<WeekDay> weekDays = new LinkedList<>();

    public void addWeekDay(WeekDay weekDay) {
        weekDays.add(weekDay);
    }

    public void displayWeek() {
        while (!weekDays.isEmpty()) {
            System.out.println(weekDays.poll());
        }
    }
}

public class WeekCalendar {
    public static void main(String[] args) {
        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Scanner sc = new Scanner(System.in);

        Week week = new Week();
        for (String day : weekDays) {
            System.out.print("Enter date for " + day + ": ");
            String date = sc.nextLine();
            week.addWeekDay(new WeekDay(day, date));
        }

        System.out.println("Week Calendar:");
        week.displayWeek();
    }
}
