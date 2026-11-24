import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MaxHeap tasks = new MaxHeap();
        boolean running = true;

        System.out.println("Priority To-Do List");

        while (running) {
            System.out.println();
            System.out.println("1. Create new task");
            System.out.println("2. View/peek highest priority task");
            System.out.println("3. Pop/remove highest priority task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!input.hasNextLine()) {
                break;
            }
            String choice = input.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter task name: ");
                String name = input.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }
                System.out.print("Enter priority (higher number = more urgent): ");
                String line = input.nextLine().trim();
                int priority;
                try {
                    priority = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Priority must be a whole number.");
                    continue;
                }
                tasks.insert(new Task(name, priority));
                System.out.println("Task added.");
            } else if (choice.equals("2")) {
                Task top = tasks.peek();
                if (top == null) {
                    System.out.println("No tasks in list.");
                } else {
                    System.out.println("Highest priority task: " + top);
                }
            } else if (choice.equals("3")) {
                Task done = tasks.extractMax();
                if (done == null) {
                    System.out.println("No tasks to complete.");
                } else {
                    System.out.println("Completed: " + done);
                    System.out.println("Tasks remaining: " + tasks.size());
                }
            } else if (choice.equals("4")) {
                running = false;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }

        System.out.println("Closing Priority To-Do List");
        input.close();
    }
}
