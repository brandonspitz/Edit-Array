import java.util.Arrays;

public class IntCollection {

	private int[] numArray; //declaring variables needed for methods
	private int count;
	
	public IntCollection(int arraySize) {
		this.numArray = new int[arraySize]; //initializes array with size parameter
	}
	
	private int indexOf(int searchingNum) { //parameter is entered number
		for (int i = 0; i < numArray.length; i++) { //searches loop
			if (numArray[i] == searchingNum) { //finds if number exists
				return i;
			}
		}
		return -1;
	}
	
	public int getNumInArray() {
		return count; //keeps track of how many numbers are added/removed
	}
	
	public boolean addNum(int numberToAdd) {
		if (getNumInArray() >= numArray.length || indexOf(numberToAdd) != -1) { 
			return false; // if statement checks to see if array has reached capacity and if the entered number already exists
		} 
		numArray[count++] = numberToAdd; //adds number to spot corresponding with the count
		if (count >= numArray.length) {
			doubleCapacity(); //if it reaches capacity now, this method is called
		}
		return true;
	}
	
	public boolean removeNum(int numberToRemove) {
		int index = indexOf(numberToRemove); //checks to see if the entered number exists
		if (index == -1) {
			return false;
		}
		int[] temp = new int[numArray.length]; //creates temporary array to copy over elements
		for (int i = 0, j = 0; i < count; i++) {
			if (i != index) {
				temp[j++] = numArray[i]; //removes desired number and continues building array
			}
		}
		numArray = temp; //temporary array is set back to the original array
		count--; //count is decremented
		return true;
	}
	
	private void doubleCapacity() {
		int[] array = new int[numArray.length * 2]; //creates new temporary array with double the size of the original array
		System.arraycopy(numArray, 0, array, 0, numArray.length); //copies over all elements to that array
		numArray = array; //sets temporary array back to original now with double size
	}
	
	public int findMax() {
		if (count == 0) { //determines if there is more than one element in array
			return 0;
		}
		int max = Integer.MIN_VALUE; //min_value sets basis for lowest possible value to begin with
		for (int i = 0; i < count; i++) { //loop moves through the array
			if (numArray[i] > max) { //updates max with each greater number found
				max = numArray[i]; 
			}
		}
		return max; //returns maximum in array
	}
	public int findMin() {
		if (count == 0) { //checks if array has more than one element
			return 0;
		}
		int min = Integer.MAX_VALUE; //max_value starts off with highest possible amount
		for (int i = 0; i < count; i++) { //loop goes through array
			if (numArray[i] < min) { //updates min with each lesser number
				min = numArray[i];
			}
		}
		return min; //returns minimum
	}
	
	public int computeSum() {
		int sum = 0; //sets sum to nothing
		for (int i = 0; i < count; i++) { //moves through array
			sum += numArray[i]; //concatenates each element together
		}
		return sum; //returns sum of all numbers in array
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(); //creates new string builder for array
		for (int i = 0; i < count; i++) { //loop moves through array
			builder.append(numArray[i]); //transfers numbers found in array to string
			if ((i + 1) != count) { //finds spaces between numbers
				builder.append(", "); //adds a comma
			}
		}
		return "{" + builder.toString() + "}"; //returns desired format with array
	}
}
