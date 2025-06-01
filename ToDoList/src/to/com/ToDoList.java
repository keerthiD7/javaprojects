package to.com; 

import java.util.ArrayList;

public class ToDoList {
	 private ArrayList<Task> tasks = new ArrayList<>();

	 public void addTask(String description) {
	        Task task = new Task(description);
	        tasks.add(task);
	        System.out.println("Task added successfully!");
	    }

	    public void listTasks() {
	        if (tasks.isEmpty()) {
	            System.out.println("No tasks found.");
	        } else {
	            System.out.println("Task List:");
	            for (int i = 0; i < tasks.size(); i++) {
	                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
	            }
	        }
	    }

	    public void removeTask(int index) {
	        if (index >= 0 && index < tasks.size()) {
	            tasks.remove(index);
	            System.out.println("Task removed successfully!");
	        } else {
	            System.out.println("Invalid task index.");
	        }
	    }
	}



