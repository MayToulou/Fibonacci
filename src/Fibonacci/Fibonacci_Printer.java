package Fibonacci;

import java.util.Scanner;

public class Fibonacci_Printer {

	public static void main(String[] args) 
	{
		int countOfFibonacciNumbers = -1;


		countOfFibonacciNumbers = readCountOfFibonacciNumbers();
		
		System.out.println("Print " + countOfFibonacciNumbers + " fibonacci numbers:");
		
		printFibonacciNumbers(countOfFibonacciNumbers);
	}
	
	private static int readCountOfFibonacciNumbers()
	{		
		int returnCount = -1;
		boolean valid = false;
				
		System.out.print("How many fibonacci numbers do you want to have? \nPlease insert a number greater than 2! \n");
		Scanner scanner = new Scanner(System.in);
		
		while(!valid)
		{
			try
			{
				returnCount = scanner.nextInt();
				valid = returnCount >= 3;
			}
			catch (Exception e)
			{
				System.out.println("No valid input. Please insert only numbers greater than 2!\n");
				scanner.nextLine();
				valid = false;
			}
			
		}
		
		scanner.close();
		
		return returnCount;
	}
	
	private static void printFibonacciNumbers(int count)
	{
		long number1 = 0;
		long number2 = 1;
		long nextNumber = number1 + number2;
		
		for(int i = 0; i < count; i++)
		{
			if(i == 0)
				System.out.print(number1);
			else if(i == 1)
				System.out.print(", " + number2);
			else
			{
				System.out.print(", " + nextNumber);
				number1 = number2;
				number2 = nextNumber;
				nextNumber = number1 + number2;
				
				if(nextNumber < 0)
				{
					System.out.println("\nNumbers are getting too large. Cancelling at fibonacci number " + i + ", last value: " + number2);
					return;
				}
			}
		}
	}

}
