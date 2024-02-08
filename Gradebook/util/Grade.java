/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade
{
    private int score;
    private String studentGrade;
    public Grade(int score) // Constructor for Grade
    {
        this.score = score;
        this.studentGrade = setGrade(score);
    }
    public static String setGrade(int studentScore) //Sets the grade based on studentScore
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

    public void setScore(int score) // Sets the score and letterGrade
    {
        this.score = score;
        this.studentGrade = setGrade(score);
    }

    public int getScore() // Retrieves the score and returns it
    {
        return score;
    }
    public String getLetterGrade() //Retrieves the letterGrade and returns it
    {
        return studentGrade;
    }
}
