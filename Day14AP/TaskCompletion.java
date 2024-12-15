import java.util.*;

public class TaskCompletion {
    static class Task {
        int deadline, minutes;

        Task(int deadline, int minutes){
            this.deadline = deadline;
            this.minutes = minutes;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++){
            tasks[i] = new Task(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(tasks,Comparator.comparingInt(t -> t.deadline));
        int totalMinutes=0;
        int maxDelay=0;
        for (Task t : tasks){
            totalMinutes += t.minutes;
            maxDelay = Math.max(maxDelay, totalMinutes - t.deadline);
        }
        System.out.println(maxDelay);
    }
}
