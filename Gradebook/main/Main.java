/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package main;
import util.*;
import java.util.Scanner; // import for user input

public class Main
{

    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);  // Create a Scanner object
        String firstName;
        String lastName;
        String userInput;
        int pid;
        int gradeScore;



        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println("\"firstName lastName PID grade\"");
        System.out.println("Press Enter when you are done.");


        //New gradebook object to contain all students.
        Gradebook gradebook = new Gradebook();

        while (true)
        {
            userInput = scnr.nextLine(); //Read the entire line.

            String[] studentList = userInput.split("\\s"); //Using a regex, we split what we read into a string depending on their spaces.

            if (studentList[0].equals("DONE")) //If the first element in the array is "DONE", break out of the loop.
            {
                break;
            }

            //Split the array into variables to validate.
            firstName = studentList[0];
            lastName = studentList[1];
            pid = Integer.parseInt(studentList[2]);
            gradeScore = Integer.parseInt(studentList[3]);

            //Checks if each variable is valid.
            if (isValidFirstName(firstName) && isValidLastName(lastName) && isValidPid(pid) && isValidGrade(gradeScore))
            {
                //Create new grade object and pass the score.
                Grade grade = new Grade(gradeScore);

                //Create new student object with all the variables including the grade object.
                Student student = new Student(firstName, lastName, pid, grade);

                //After student is made, add student into gradebook.
                gradebook.addStudent(student);
            }
            else
            {
                //If the entries aren't valid, display a message and ask the user to try again.
                System.out.println("Invalid entries, try again.");
                continue;
            }


            System.out.println("Please enter the information of the next student using the same format.");
            System.out.println("If there is no more students, please enter the keyword “DONE”.");
            System.out.println("Press Enter when you are done.");


        }


        menuDisplay(); // Display the menu to the User
        System.out.print("Enter a command");

        while (!userInput.equals("quit")) //While loop that'll run until the user enters "quit"
        {
            userInput = scnr.nextLine();
            //Take the line read and split it using the spaces.
            String[] inputArray = userInput.split("\\s");


            switch (inputArray[0]) //switch case that has a case for the first element in the array made.
            {
                case "min": //Runs if the user enters "min score".

                    if (inputArray[1].equals("score"))
                    {
                        //Calls the gradebook's minScore() method.
                        System.out.println("The minimum score is: " + gradebook.minScore());
                    }
                    //Runs if the user enters "min letter".
                    else if (inputArray[1].equals("letter"))
                    {
                        //Calls the gradebook's minLetter() method.
                        System.out.println("The minimum letter is: " + gradebook.minLetter());
                    }
                    else
                    {
                        System.out.println("Invalid input. Check spelling and try again");
                    }
                    break;

                case "max": //Runs if the user enters "max score".

                    if (inputArray[1].equals("score"))
                    {
                        System.out.println("The maximum score is: " + gradebook.maxScore());
                    }
                    //Runs if the user enters "max letter".
                    else if (inputArray[1].equals("letter"))
                    {
                        System.out.println("The maximum letter is: " + gradebook.maxLetter());
                    }
                    else
                    {
                        System.out.println("Invalid input. Check spelling and try again");
                    }
                    break;

                case "letter": //This runs if the user inputs letter with a pid.

                    //This will take the pid and revert it back into an int since it has been read as a string.
                    pid = Integer.parseInt(inputArray[1]);
                    //We pass the pid into the gradebook's letterGivenPid() method.
                    System.out.println(gradebook.letterGivenPid(pid));
                    break;

                case "name": //Another similar way of doing it, this transforms the pid into an int and passes it to the method

                    System.out.println(gradebook.nameGivenPid(Integer.parseInt(inputArray[1])));
                    break;

                case "change": //This allows us to take the pid and score from the array and revert them back into an int.

                    pid = Integer.parseInt(inputArray[1]);
                    gradeScore = Integer.parseInt(inputArray[2]);
                    //Pass both the pid and the score to gradebook's changeGrade() method.
                    System.out.println(gradebook.replaceGrade(pid, gradeScore));
                    break;

                case "average":
                    if (inputArray[1].equals("score"))
                    { //Calls method to calculate the average score.
                        System.out.printf("The average score is: %.2f\n", gradebook.calculateAvg());
                    }
                    else if (inputArray[1].equals("letter"))
                    { //Calls method to calculate the average letter.
                        System.out.println("The average letter is : " + gradebook.calculateAverageLetter());
                    }
                    else
                    {
                        System.out.println("Invalid input. Check spelling and try again");
                    }
                    break;

                case "median":
                    if (inputArray[1].equals("score"))
                    { //Calls method to calculate the median score.
                        System.out.printf("The median score is: %.2f", gradebook.calculateMedian());
                    }
                    else if (inputArray[1].equals("letter"))
                    { //Calls method to calculate the median letter.
                        System.out.println("The median letter is: " + gradebook.calculateMedianLetter());
                    }
                    else
                    {
                        System.out.println("Invalid input. Check spelling and try again");
                    }
                    break;

                case "tab":

                    if (inputArray[1].equals("scores"))
                    { //Prints all students with their respective scores in a tab table.
                        gradebook.printAllStudents();
                    }
                    else if (inputArray[1].equals("letters"))
                    { //Prints all students with their associated letter grades in a tab table.
                        gradebook.printAllStudentsLetter();
                    }
                    else
                    {
                        System.out.println("Invalid input. Check spelling and try again");
                    }
                    break;

                case "quit": //If user enters "quit", break out of program.
                    System.out.println("Goodbye");
                    break;

                case "menu": //Prints the menu again.
                    menuDisplay();
                    break;

                default: //If no command was input, prompts the user to retry.
                    System.out.println("Invalid input. Check spelling and try again");
                    break;
            }

        }

    }





    private static boolean isValidFirstName(String firstName) //Checks if firstName is a valid String.
    {
        if (!Character.isUpperCase(firstName.charAt(0)))
        {
            return false;
        }

        for (int i = 0; i < firstName.length(); i++)
        { //For loop to iterate through firstName characters.
            //Checks if the characters are a whitespace OR if they're NOT a letter.
            if (Character.isWhitespace(firstName.charAt(i)) || !Character.isLetter(firstName.charAt(i)))
            {
                return false;
            }
        }
        return true; //Returns true if valid.
    }

    private static boolean isValidLastName(String lastName) //Checks if lastName is a valid String.
    {
        //Replaces the "." in lastName with an empty string, and subtracts that from the length of lastName to get the dotCount.
        int dotCount = lastName.length() - lastName.replace(".", "").length();

        if (!Character.isUpperCase(lastName.charAt(0)))
        { //Checks if the first character in lastName is uppercase.
            return false;
        }
        else if (dotCount > 1)
        { //Checks if the dotCount is greater than one, return false if it is.
            return false;
        }

        // For loop to go through lastName
        for (int i = 0; i < lastName.length(); i++)
        {
            // Checks to see if lastName has a whitespace, and also checks for a non-letter character that is not a dot.
            if (Character.isWhitespace(lastName.charAt(i)) || (!Character.isLetter(lastName.charAt(i)) && lastName.charAt(i) != 46))
            {
                return false;
            }
        }


        return true;
    }

    private static boolean isValidPid(int pid) // Checks if pid is a validPid
    {
        //We transform pid into a string then capture its length
        int length = (Integer.toString(pid)).length();

        //If pid's length isn't 7 OR if it's very first digit is a zero, meaning a "LEADING ZERO", return false.
        if ((length != 7) || (Integer.parseInt(Integer.toString(pid).substring(0, 1)) == 0))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    private static boolean isValidGrade(int grade) // Determines if grade is a valid integer.
    {
        if (grade >= 0 && grade <= 100)
        { // Determines if grade is between 0 and 100 inclusive
            return true;
        }
        else
        {
            return false;
        }
    }
    private static void menuDisplay() // Prints out a display of the menu with options.
    {
        System.out.println("min score - minimum score");
        System.out.println("min letter - minimum letter grade");
        System.out.println("max score - maximum score");
        System.out.println("max letter - maximum letter grade");
        System.out.println("letter XXXXXXX - letter grade of specific student");
        System.out.println("name XXXXXXX - name of specific student");
        System.out.println("change XXXXXXX YY - changes a specific student's grade");
        System.out.println("average score - average score of grade book");
        System.out.println("average letter - average letter of grade book");
        System.out.println("median score - median score of grade book");
        System.out.println("median letter - median letter of grade book");
        System.out.println("tab scores - print all students with their scores");
        System.out.println("tab letters - print all students with their letters");
        System.out.println("menu - view menu");
    }
}

