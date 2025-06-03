package studentapp;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewAllStudents(); break;
                case 3: searchStudentById(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6:
                    System.out.println("Exiting... Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter grade: ");
        String grade = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setGrade(grade);
        s.setGender(gender);

        if (dao.addStudent(s)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private static void viewAllStudents() {
        List<Student> students = dao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(s -> System.out.println(
                "ID: " + s.getId() +
                ", Name: " + s.getName() +
                ", Age: " + s.getAge() +
                ", Grade: " + s.getGrade() +
                ", Gender: " + s.getGender()
            ));
        }
    }

    private static void searchStudentById() {
        System.out.print("Enter student ID to search: ");
        int id = Integer.parseInt(sc.nextLine());
        Student s = dao.getStudentById(id);
        if (s != null) {
            System.out.println(
                "ID: " + s.getId() +
                ", Name: " + s.getName() +
                ", Age: " + s.getAge() +
                ", Grade: " + s.getGrade() +
                ", Gender: " + s.getGender()
            );
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        Student s = dao.getStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name (" + s.getName() + "): ");
        String name = sc.nextLine();
        System.out.print("Enter new age (" + s.getAge() + "): ");
        String ageStr = sc.nextLine();
        System.out.print("Enter new grade (" + s.getGrade() + "): ");
        String grade = sc.nextLine();
        System.out.print("Enter new gender (" + s.getGender() + "): ");
        String gender = sc.nextLine();

        if (!name.isEmpty()) s.setName(name);
        if (!ageStr.isEmpty()) s.setAge(Integer.parseInt(ageStr));
        if (!grade.isEmpty()) s.setGrade(grade);
        if (!gender.isEmpty()) s.setGender(gender);

        if (dao.updateStudent(s)) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Failed to update student.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        if (dao.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Failed to delete student.");
        }
    }
}
