import java.util.*;

// Person is a base class to be extended by other specific person types like Student.
class Person {
    public String name; // Name of the person.
    
    // Person constructor.
    public Person(String name) {
        this.name = name; // Initialize the name field.
    }
}

// Student class that extends Person.
// This means that a Student is a Person with some additional data and behavior.
class Student extends Person {
    public int grade; // Grade of the student.
    // List to hold the courses for the student.
    // A student can be enrolled in many courses.
    public List<Course> courses;
    
    // Student constructor.
    public Student(String name, int grade) {
        super(name); // Call the superclass constructor (Person).
        this.grade = grade; // Initialize the grade field.
        // Initialize the courses list in the constructor.
        this.courses = new ArrayList<>();
    }

    // Method to add a course to a student.
    // The course object represents a course the student is taking.
    public void addCourse(Course course) {
        this.courses.add(course); // Add the course to the courses list.
    }

    // Override the toString method to provide a custom string representation of the student.
    @Override
    public String toString() {
        return this.name + ": " + this.grade + ", Courses: " + this.courses;
    }
}

// Course class represents a course that can have many students.
class Course {
    public String name; // Name of the course.
    // List to hold the students for the course.
    // A course can have many students.
    public List<Student> students;
    
    // Course constructor.
    public Course(String name) {
        this.name = name; // Initialize the name field.
        // Initialize the students list in the constructor.
        this.students = new ArrayList<>();
    }

    // Method to add a student to a course.
    // The student object represents a student who is taking the course.
    public void addStudent(Student student) {
        this.students.add(student); // Add the student to the students list.
    }

    // Override the toString method to provide a custom string representation of the course.
    @Override
    public String toString() {
        return this.name;
    }
}

// StudentManagement class handles the business logic for managing students and courses.
public class StudentManagement {
    // List to hold the students.
    private ArrayList<Student> students;
    // List to hold the courses.
    private ArrayList<Course> courses;
    
    // StudentManagement constructor.
    public StudentManagement() {
        // Initialize the students list in the constructor.
        this.students = new ArrayList<>();
        // Initialize the courses list in the constructor.
        this.courses = new ArrayList<>();
    }

    // Method to add a student.
    public void addStudent(String name, int grade) {
        this.students.add(new Student(name, grade)); // Create a new student and add it to the students list.
    }

    // Method to add a course.
    public void addCourse(String name) {
        this.courses.add(new Course(name)); // Create a new course and add it to the courses list.
    }

    // Method to remove a student.
    public void removeStudent(String name) {
        // Loop over the students list.
        for(int i = 0; i < this.students.size(); i++) {
            // If the name of the current student equals the given name...
            if(this.students.get(i).name.equals(name)) {
                // ... remove the student from the students list.
                this.students.remove(i);
                break; // Exit the loop.
            }
        }
    }

    // Method to update a student's grade.
    public void updateStudent(String name, int newGrade) {
        // Loop over the students list.
        for(Student student : this.students) {
            // If the name of the current student equals the given name...
            if(student.name.equals(name)) {
                // ... update the student's grade.
                student.grade = newGrade;
                break; // Exit the loop.
            }
        }
    }

    // Method to enroll a student in a course.
    public void enrollStudentInCourse(String studentName, String courseName) {
        // Get the student and course objects.
        Student student = this.getStudent(studentName);
        Course course = this.getCourse(courseName);

        // If both the student and course exist...
        if(student != null && course != null) {
            // ... enroll the student in the course.
            student.addCourse(course);
            course.addStudent(student);
        }
    }

    // Helper methods to get a student or a course by name.
    private Student getStudent(String name) {
        // Loop over the students list.
        for(Student student : this.students) {
            // If the name of the current student equals the given name...
            if(student.name.equals(name)) {
                // ... return the student.
                return student;
            }
        }
        // If no student was found, return null.
        return null;
    }

    private Course getCourse(String name) {
        // Loop over the courses list.
        for(Course course : this.courses) {
            // If the name of the current course equals the given name...
            if(course.name.equals(name)) {
                // ... return the course.
                return course;
            }
        }
        // If no course was found, return null.
        return null;
    }

    // Method to display the students.
    public void displayStudents() {
        // Sort the students list by grade.
        Collections.sort(this.students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.grade - s1.grade; // Order by grade, descending.
            }
        });

        // Loop over the sorted students list and print each student.
        for(Student student : this.students) {
            System.out.println(student.toString());
        }
    }

    // Method to display the courses and their students.
    public void displayCourses() {
        // Loop over the courses list and print each course and its students.
        for(Course course : this.courses) {
            System.out.println(course.toString() + ": " + course.students);
        }
    }
}

// Main class contains the program entry point (the main method).
public class Main {
    // Main method.
    public static void main(String[] args) {
        // Create a new StudentManagement object.
        StudentManagement sm = new StudentManagement();

        // Add students and courses.
        sm.addStudent("John", 89);
        sm.addStudent("Alice", 92);
        sm.addStudent("Bob", 78);
        sm.addCourse("Mathematics");
        sm.addCourse("Physics");

        // Enroll students in courses.
        sm.enrollStudentInCourse("John", "Mathematics");
        sm.enrollStudentInCourse("Alice", "Physics");
        sm.enrollStudentInCourse("Bob", "Mathematics");

        // Display the students and courses.
        sm.displayStudents();
        sm.displayCourses();

        // Update a student's grade.
        sm.updateStudent("John", 95);
        sm.displayStudents();

        // Remove a student.
        sm.removeStudent("Alice");
        sm.displayStudents();
        sm.displayCourses();
    }
}