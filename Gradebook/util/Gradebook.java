/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook
{
    private ArrayList<Student> listOfStudents;

	public Gradebook() //Constructor for initializing ArrayList.
	{
		listOfStudents = new ArrayList<Student>();
	}
    public double calculateAvg()  // Takes the sum of all student scores and divides by the number of students.
	{
	double sum = 0;
	for(Student s: listOfStudents)
	    sum += s.getGrade().getScore();
	return sum / listOfStudents.size();
    }

    public float calculateMedian() // Calculates the median score
	{
	int i = 0, n = listOfStudents.size();
	int[] scores = new int[n];
	for(Student s: listOfStudents)
	    scores[i++] = s.getGrade().getScore();
	Arrays.sort(scores);
	if (n % 2 == 0)
	    return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
	else
	    return scores[n / 2];
    }

	public String calculateAverageLetter() //calculates the average letter grade
	{
		String averageLetter;
		int averageInt = (int) Math.round(calculateAvg());
		averageLetter = Grade.setGrade(averageInt);
		return averageLetter;
	}

	public String calculateMedianLetter() // Calculates the median letter grade.
	{
		int i = 0;
		int smallestIndex;
		int tempVal;
		int n = listOfStudents.size();
		int[] scores = new int[n];
		float medianScore;


		for (Student student: listOfStudents) //Collects every student's scores and adds them to an array.
		{
			scores[i++] = student.getGrade().getScore();
		}



		for (i = 0; i < scores.length - 1; i++) // Sorting algorithm to organize it in ascending order.
		{
			smallestIndex = i;
			for (int j = i + 1; j < scores.length; j++)
			{
				if (scores[j] < scores[smallestIndex])
				{
					smallestIndex = j;
				}
			}
			tempVal = scores[i];
			scores[i] = scores[smallestIndex];
			scores[smallestIndex] = tempVal;
		}


		if (n % 2 == 0) // Checks the median score and transforms it to a letter.
		{
			medianScore = (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
		}
		else
		{
			medianScore = scores[n /2];
		}

		return Grade.setGrade(Math.round(medianScore));

	}

    public void printAllStudents() // prints all students with their associated information
	{
	for(Student s: listOfStudents)
	    System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }

	public void addStudent(Student student)  // Adds student within listOfStudents array
	{
		listOfStudents.add(student);
	}

	public int minScore() // calculates the minimum score based on the list of students information.
	{
		int minValue = listOfStudents.get(0).getGrade().getScore();
		for(Student student: listOfStudents)
		{
			if(student.getGrade().getScore() <= minValue)
			{
				minValue = student.getGrade().getScore();
			}
		}
		return minValue;
	}

	public String minLetter() // calculates the minimum letter grade based on the list of students information.
	{
		String minLetter = null;
		int minValue = listOfStudents.get(0).getGrade().getScore();
		for(Student student: listOfStudents)
		{
			if(student.getGrade().getScore() <= minValue)
			{
				minValue = student.getGrade().getScore();
				minLetter = student.getGrade().getLetterGrade();
			}
		}
		return minLetter;
	}

	public int maxScore() // calculates the max score based upon the list of students
	{
		int maxValue = listOfStudents.get(0).getGrade().getScore();
		for(Student student: listOfStudents)
		{
			if(student.getGrade().getScore() >= maxValue)
			{
				maxValue = student.getGrade().getScore();
			}
		}
		return maxValue;
	}

	public String maxLetter() // calculates the max Letter grade based upon all the students in the list
	{
		String maxLetter = null;
		int maxValue = listOfStudents.get(0).getGrade().getScore();
		for(Student student: listOfStudents)
		{
			if(student.getGrade().getScore() >= maxValue)
			{
				maxValue = student.getGrade().getScore();
				maxLetter = student.getGrade().getLetterGrade();
			}
		}
		return maxLetter;
	}

	public String letterGivenPid(int pid) // retrieves and outputs a grade letter associated to a student's pid
	{
		String letterGivenPid = null;

		for(Student student: listOfStudents)
		{
			if(student.getPid() == pid)
			{
				letterGivenPid = student.getGrade().getLetterGrade();
			}
		}
		return "The letter grade associated with this pid: " + pid + " is: " + letterGivenPid;
	}

	public String nameGivenPid(int pid) //retrieves and outputs the full name of a student associated to a specific pid
	{
		String fullName = null;
		for(Student student: listOfStudents)
		{
			if(student.getPid() == pid)
			{
				fullName = student.getFirstName() + " " + student.getLastName();
			}
		}
		return "The full name associated with this pid: " + pid + " is: " + fullName;
	}

	public String replaceGrade(int pid, int newGrade) //replaces the current grade of a specific student associated to pid to a new grade
	{
		for(Student student: listOfStudents)
		{
			if(student.getPid() == pid)
			{
				student.getGrade().setScore(newGrade);
			}
		}
		return "Grade has been replaced with: " + newGrade + " for the associated pid: " + pid;
	}

	public void printAllStudentsLetter() //Prints all students with their associated letter grade.
	{
		for (Student s: listOfStudents)
		{
			System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
		}
	}
}
