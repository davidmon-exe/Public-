
import MergeSort.*;
public class Driver {
    public static double[] generateRandomArray(int size) {
		double[] array = new double[size];
	
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * 100.0;
		}
		return array;
	}
	public static void main(String[] args) {

		double[] array = generateRandomArray(10000);

		int arrlength = array.length;

		// algorithm #1
		MergeSort mSort = new MergeSort();
		double[] temp = mSort.sort(array, arrlength);
        mSort.checker(temp);
    } 
}
