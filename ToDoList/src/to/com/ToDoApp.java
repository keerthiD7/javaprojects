package to.com;
import java.util.Scanner;

public class ToDoApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList todoList = new ToDoList();

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                case 2:
                    todoList.listTasks();
                    break;
                case 3:
                    System.out.print("Enter the task index to remove: ");
                    int index = scanner.nextInt();
                    todoList.removeTask(index - 1);
                    break;
                case 4:
                    System.out.println("Exiting the To-Do List Application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
