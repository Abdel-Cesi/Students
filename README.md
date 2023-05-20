# Students
Student Management in Java


The project is a Student Management System written in Java. It provides functionalities to manage a list of students and courses at a school, along with managing the relationship between students and their enrolled courses.

The primary classes in the project are Person, Student, Course, and StudentManagement.

The Person class is a base class that holds the common attributes for different types of people at the school. In this case, we have only Student who extends Person. The Student class has additional attributes like grade and a list of courses that the student is enrolled in.

The Course class represents a course at the school. Each course has a list of students who are enrolled in the course.

The StudentManagement class is the core class that manages the business logic of the application. It maintains lists of all students and courses at the school, and provides methods to add or remove students and courses, update a student's grade, and enroll a student in a course.

The application sorts students based on their grades in descending order. The system also allows enrolling a student in multiple courses and vice versa.

The Main class is the entry point to the application. It creates a StudentManagement object and uses it to add students and courses, enroll students in courses, display the students and courses, update a student's grade, and remove a student.

Overall, this project provides a solid foundation for a more complex student management system that could include features like handling multiple types of people (like teachers and staff), managing course schedules, handling grades for multiple assignments, etc.

This project is a great example of object-oriented programming in Java, demonstrating principles such as inheritance (with the Student class extending the Person class), encapsulation (with private attributes and public getter/setter methods), and polymorphism (with the toString method overridden in Student and Course classes).

The use of Java's built-in ArrayList and Collections classes are showcased for managing lists of objects and sorting lists, respectively. The project also demonstrates the use of the for-each loop and the Comparator interface in Java.
