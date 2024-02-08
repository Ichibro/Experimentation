/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    public Student(String firstName, String lastName, int pid, Grade grade)
    {
        // Constructor for student that sets up initialization for variables.
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }


    public void setFirstName(String studentFirst)
    {
        this.firstName = studentFirst;
    }

    public void setLastName(String studentLast) {
        this.lastName = studentLast;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPid() {
        return pid;
    }
    public Grade getGrade() {
        return grade;
    }
}
