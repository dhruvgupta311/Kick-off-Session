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
    Stack<WeekDay> firstHalf = new Stack<>();
    Stack<WeekDay> secondHalf = new Stack<>();

    public void addWeekDay(WeekDay weekDay) {
        if (firstHalf.size() < 4) {
            firstHalf.push(weekDay);
        } else {
            secondHalf.push(weekDay);
        }
    }

    public void displayWeek() {
        while (!firstHalf.isEmpty()) {
            System.out.println(firstHalf.pop());
        }
        while (!secondHalf.isEmpty()) {
            System.out.println(secondHalf.pop());
        }
    }
}

public class WeekCalendarStacks {
    public static void main(String[] args) {
        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Scanner sc = new Scanner(System.in);

        Week week = new Week();
        for (String day : weekDays) {
            System.out.print("Enter date for " + day + ": ");
            String date = sc.nextLine();
            week.addWeekDay(new WeekDay(day, date));
        }

        System.out.println("Week Calendar in Stacks:");
        week.displayWeek();
    }
}
