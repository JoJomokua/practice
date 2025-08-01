package Inheritance;

public class Person {

    String name;
    int age;

    public Person(String personName, int personAge) {
        this.name = personName;
        this.age = personAge;
    }
    public void  displayDetails(){
        System.out.println("Name: " + name + "\nAge: " + age);
    }
}
class Student extends Person {
    String studentId;
    String course;

    public Student(String name, int age, String studentId, String course) {
        super(name, age);// call parent constructor
        this.studentId = studentId;
        this.course = course;
    }

    public void showStudentInfo() {
        System.out.println("Student details");
        displayDetails();//call parent method

        System.out.println("Student Id: " + studentId + "\nCourse: " + course);
        System.out.println();
    }
}
    class Teacher extends Person{
        String subject;
        double salary;

        public Teacher(String name, int age, String subject, double salary){
            super(name,age);
            this.subject = subject;
            this.salary = salary;
        }

              public void showTeacherInfo() {
            System.out.println("Teacher details");
            displayDetails();

            System.out.println("Subject: " + subject +  "\nSalary: " + salary);
        }


    public static void main(String[] args) {
        Student student = new Student("Alice",  34, "s1798", "Medicine");
        student.showStudentInfo();

        Teacher teacher = new Teacher("Mark", 49, "Physics", 50000);
        teacher.showTeacherInfo();
}

    }

