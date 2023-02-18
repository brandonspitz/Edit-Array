import java.util.Scanner; //importing scanner

public class EditArray {
	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner (System.in)) {
			String choice; //variables for menu options
			char command;
			
			int arraySize;
			
			System.out.println("Please enter the size for the array.");
			arraySize = scan.nextInt();
			
			IntCollection numArray = new IntCollection(arraySize);

				printMenu(); //prints menu
				do {
					System.out.println("Please enter a command or type ?");
					choice = scan.next().toLowerCase();
					command = choice.charAt(0); //uses lower case characters for menu
					
					switch (command) {
					case 'a': 
						System.out.println("Please enter an integer to add.");
						int add = scan.nextInt();
						numArray.addNum(add);
					break;
					case 'b':
						System.out.println("Please enter an integer to remove.");
						int remove = scan.nextInt();
						numArray.removeNum(remove);
					break;
					case 'c':
						System.out.println(numArray.toString());
					break;
					case 'd':
						System.out.println("The maximum is: " + numArray.findMax());
					break;
					case 'e':
						System.out.println("The minimum is: " + numArray.findMin());
					break;
					case 'f':
						System.out.println("The sum is: " + numArray.computeSum());
					break;
					case '?':
						printMenu(); //prints menu again
					break;
					case 'q': //terminates 
					break;
					
					default:
						System.out.println("Invalid input");//error message
					}
				} while (command != 'q'); //while loop facilitates menu
		}
	}
	
	public static void printMenu() { //menu options
		System.out.print("\nCommand Options\n"
						+"-----------------------------------\n"
						+"'a': add an integer in the array\n"
						+"'b': remove an integer from the array\n"
						+"'c': display the array\n"
						+"'d': compute and display the maximum\n"
						+"'e': compute and display the minimum\n"
						+"'f': compute and display the sum\n"
						+"'?': display the menu again\n"
						+"'q': quit this program\n\n");
	}	
}