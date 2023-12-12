

public class Solution
{

    static void Main(string[] args)
    {
        Console.WriteLine("This is a program for adding two integers.");
        Console.WriteLine("Input a number:");

        // Uses the CheckInput function to record and determine if input value is an actual number
        double num1 = CheckInput();

        Console.WriteLine("Input another number:");

        double num2 = CheckInput();

        Sum(num1,num2);
    }
    
    static double Sum(double num1, double num2)
    {
        // This will add the values of num1 and num2 and record to result        
        double result = num1 + num2;

        Console.WriteLine("The total sum is: " + result);
        
        return result;
    }

    static double CheckInput()
    {
        double userInput;
        while (true)
        {
            
            if (double.TryParse(Console.ReadLine(), out userInput))
            {

                // If the parse is successful, we return userInput to break out of loop
                return userInput;

            }
            Console.WriteLine("Invalid number. Retry.");
        }

        
    }

}
