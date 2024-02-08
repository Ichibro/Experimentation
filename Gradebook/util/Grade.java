/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade {
    private int score;
    private String studentGrade;
    public Grade(int score) // Constructor for Grade
    {
        this.score = score;
        this.studentGrade = setGrade(score);
    }
    public static String setGrade(int studentScore)
    {
        String studentGrade;
        if(studentScore >= 95)
        {
            studentGrade = "A";
        }
        else if (studentScore >= 90)
        {
            studentGrade = "A-";
        }
        else if (studentScore >= 87)
        {
            studentGrade = "B+";
        }
        else if (studentScore >= 83)
        {
            studentGrade = "B";
        }
        else if (studentScore >= 80)
        {
            studentGrade = "B-";
        }
        else if (studentScore >= 77)
        {
            studentGrade = "C+";
        }
        else if (studentScore >= 70)
        {
            studentGrade = "C";
        }
        else if (studentScore >= 60)
        {
            studentGrade = "D";
        }
        else
        {
            studentGrade = "F";
        }
        return studentGrade;
    }

    public void setScore(int score) // Used to update the letter and score
    {
        this.score = score;
        this.studentGrade = setGrade(score);
    }

    public int getScore() {
        return score;
    }
    public String getLetterGrade() {
        return studentGrade;
    }
}
