package virtualclassroom;

import java.util.ArrayList;
import java.util.List;

// This class represents a Classroom with a name, a list of students, and a list of assignments.
public class Classroom {
    private String name; // The name of the classroom
    private List<String> students; // List of students in the classroom
    private List<String> assignments; // List of assignments for the classroom

    // Constructor for Classroom class
    // Initializes the classroom with a name, and initializes empty lists for students and assignments
    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // Getter for the name field
    // Returns the name of the classroom
    public String getName() {
        return name;
    }

    // Getter for the students field
    // Returns the list of students in the classroom
    public List<String> getStudents() {
        return students;
    }

    // Getter for the assignments field
    // Returns the list of assignments for the classroom
    public List<String> getAssignments() {
        return assignments;
    }
}
