package virtualclassroom;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("*********************************");
            System.out.println("Virtual Classroom Manager Menu:");
            System.out.println("*********************************");
            System.out.println("1. Add Classroom");
            System.out.println("2. Add Student");
            System.out.println("3. Schedule Assignment");
            System.out.println("4. Submit Assignment");
            System.out.println("5. List Classrooms");
            System.out.println("6. List Students in Classroom");
            System.out.println("7. Remove Classroom");
            System.out.println("8. Quit");

            System.out.println("--------------------------------");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("--------------------------------");

            // Consume the newline character
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the classroom name: ");
                    String className = sc.nextLine();
                    manager.addClassroom(className);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = sc.nextLine();
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    manager.addStudent(studentID, className);
                    break;
                case 3:
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    System.out.print("Enter assignment details: ");
                    String assignmentDetails = sc.nextLine();
                    manager.scheduleAssignment(className, assignmentDetails);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextLine();
                    System.out.print("Enter classroom name: ");
                    className = sc.nextLine();
                    System.out.print("Enter assignment details: ");
                    assignmentDetails = sc.nextLine();
                    manager.submitAssignments(studentID, className, assignmentDetails);
                    break;
                case 5:
                    manager.listClassrooms();
                    break;
                case 6:
                    System.out.print("Enter Classroom Name: ");
                    className = sc.nextLine();
                    manager.listStudents(className);
                    break;
                case 7:
                    System.out.print("Enter the Classroom Name: ");
                    className = sc.nextLine();
                    manager.removeClassroom(className);
                    break;
                case 8:
                    System.out.println("Exiting Virtual Classroom Manager...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

