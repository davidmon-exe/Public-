package MergeSorter;

public class MergeSort{
    /** 
     * Sorting method to increment through the array and 
     * split the part of the array that is being checked into
     * two. 
     * <P>
     * Recursion is used to go into the array and continuously 
     * split the part that is being looked at, until a max depth is reached.
     * @return values Array is returned when sorthing is finished
     * @param n The length of the array
     * @param values The array
    */
    public double[] sort(double[] values, int n){
                
        if (n < 2) return values;

        int mid = n/2;

        double[] S1 = new double[mid];

        double[] S2 = new double[n - mid];

        for (int x = 0; x < mid; x++) {

            S1[x] = values[x];
        }
        for (int x = mid; x < n; x++) {

            S2[x-mid] = values[x];
        }

        sort(S1, mid);
        sort(S2, n - mid);

        merge(values, S1, S2, mid, n-mid);
        
        return values;
    }

    /**
     * Used to compare both sides of the array, and will organize from smallest
     * to largest value
     * @return values
     * @param left Length of S1
     * @param right Length of S2
     * @param S1 The left half of a split array.
     * @param S2 The right half of a split array.
     * @param values The array
     */
    private double[] merge(double[] values, double[] S1, double[] S2, int left, int right){

        int x = 0, y = 0, z = 0;
        while(x < left && y < right){
            if (S1[x] <= S2[y]) { values[z++] = S1[x++]; }
            else{ values[z++] = S2[y++]; } 
        }
        while (x < left) values[z++] = S1[x++];
	    
	    while (y < right) values[z++] = S2[y++];
	    
        return values;
    }

    /**
     * Used to iterate through the array to check if the value at index i
     * is smaller than the value at index i+1. 
     * @param values The array
     */
    public void checker(double[] values){
        for (int i = 0; i < values.length-1; i++) {
            if (values[i] > values[i+1]) {
                System.out.println("Sort failed.");
            }
        }
    }   
}