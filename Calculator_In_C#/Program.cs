

public class Solution
{

    static void Main(string[] args)
    {   
        // Display title
        Console.WriteLine("This is a Calculator in C#\r");
        Console.WriteLine("------------------------\n");

        Console.WriteLine("Insert a number:");
        // Uses the StoreInput function to record and determine if input value is an actual number
        double num1 = StoreInput();

        Console.WriteLine("Input another number:");

        double num2 = StoreInput();

        // Prompt user to choose an option
        Console.WriteLine("Choose an option from the list:");
        Console.WriteLine("\ta - Add");
        Console.WriteLine("\ts - Subtract");
        Console.WriteLine("\tm - Multiply");
        Console.WriteLine("\td - Divide");
        Console.Write("Your choice? ");

        // Utilize switch statements for each operation
        switch (Console.ReadLine()) 
        {
            case "a":
                Console.WriteLine("Your result: " + num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case "s":
                Console.WriteLine("Your result: " + num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case "m":
                Console.WriteLine("Your result: " + num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case "d":
                Console.WriteLine("Your result: " + num1 + " / " + num2 + " = " + (num1 / num2));
                break;
        }
        // Wait for the user to respond before terminating
        Console.Write("Press any key to close...");
        Console.ReadKey();

    }

    static double Sum(double num1, double num2)
    {
        // This will add the values of num1 and num2 and record to result        
        double result = num1 + num2;

        Console.WriteLine("The total sum is: " + result);

        return result;
    }

    static double StoreInput()
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
