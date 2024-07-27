package virtualclassroom;

import java.util.HashMap;
import java.util.Map;

public class VirtualClassroomManager {
	
	/*This class is created to manage all the functionalities of the virtual classroom.
	 * ------------------------------------------------
	 * FUNCTIONALITIES:
	 * ------------------------------------------------
	 * 1.Adding new classrooms
	 * 2.Removing existing classrooms
	 * 3.Adding new student
	 * 4.Scheduling assignments for each classroom
	 * 5.Submission of assignments by students
	 * 6.Displaying list of classrooms
	 * 7.Displaying list of students belonging to the same class*/

    // Two maps are created
    // map1 to map class name with its respective classroom
    private Map<String, Classroom> classrooms;
    // map2 to map student ID and the class name (a student can enroll only in a single class)
    private Map<String, String> studentClassMap;

    public VirtualClassroomManager() {
        classrooms = new HashMap<>();
        studentClassMap = new HashMap<>();
    }

    // FUNCTIONALITIES OF VIRTUAL CLASSROOM
    // 1. Adding new classrooms
    public void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        } else {
            System.out.println("Classroom " + className + " already exists.");
        }
    }

    // 2. Removing existing classrooms
    public void removeClassroom(String className) {
        if (classrooms.containsKey(className)) {
            classrooms.remove(className);
            System.out.println("Classroom " + className + " has been removed.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    // 3. Adding new student
    public void addStudent(String studentID, String className) {
        if (classrooms.containsKey(className)) {
            if (!studentClassMap.containsKey(studentID)) {
                Classroom classroom = classrooms.get(className);
                classroom.getStudents().add(studentID);
                studentClassMap.put(studentID, className);
                System.out.println("Student " + studentID + " has been enrolled in " + className + ".");
            } else {
                System.out.println("Student " + studentID + " is already enrolled in a class.");
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    // 4. Scheduling assignments for each classroom
    public void scheduleAssignment(String className, String assignmentDetails) {
        if (classrooms.containsKey(className)) {
            Classroom classroom = classrooms.get(className);
            if (!classroom.getAssignments().contains(assignmentDetails)) {
                classroom.getAssignments().add(assignmentDetails);
                System.out.println("Assignment for " + className + " has been scheduled.");
            } else {
                System.out.println("Assignment for " + className + " already exists.");
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    // 5. Submission of Assignments by students
    public void submitAssignments(String studentID, String className, String assignmentDetails) {
        if (studentClassMap.containsKey(studentID) && studentClassMap.get(studentID).equals(className)) {
            Classroom classroom = classrooms.get(className);
            if (classroom.getAssignments().contains(assignmentDetails)) {
                System.out.println("Assignment submitted by Student " + studentID + " in " + className + ".");
            } else {
                System.out.println("Assignment - " + assignmentDetails + " does not exist for " + className + ".");
            }
        } else {
            System.out.println("Student " + studentID + " is not enrolled in " + className + ".");
        }
    }

    // 6. Displaying list of classrooms
    public void listClassrooms() {
        System.out.println("List of Classrooms:");
        System.out.println("------------------------------");
        for (String className : classrooms.keySet()) {
            System.out.println(className);
        }
    }

    // 7. Displaying list of students belonging to the same class
    public void listStudents(String className) {
        if (classrooms.containsKey(className)) {
            Classroom classroom = classrooms.get(className);
            System.out.println("Students in " + className + ":");
            System.out.println("-----------------------------------------");
            for (String student : classroom.getStudents()) {
                System.out.println(student);
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
