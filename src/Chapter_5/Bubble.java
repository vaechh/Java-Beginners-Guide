package Chapter_5;

public class Bubble {
    public static void main(String[] args) {
        int[] nums = { 99, -10, 100123, 18, -978,
                5623, 463, -9, 287, 49 };
        int a, b, t;
        int size;
        size = 10; // number of elements to sort
        // display original array
        System.out.print("Original array is:");
        for(int i=0; i < size; i++)
            System.out.print(" " + nums[i]);
        System.out.println();
        // This is the Chapter_5.Bubble sort.
        for(a = 0; a < size - 1; a++)
            for(b = a + 1; b < size; b++) {
                if(nums[a] > nums[b]) { // if out of order
                    // exchange elements
                    t = nums[a];
                    nums[a] = nums[b];
                    nums[b] = t;
                }
            }
        // display sorted array
        System.out.print("Sorted array is:");
        for(int i=0; i < size; i++)
            System.out.print(" " + nums[i]);
        System.out.println();
    }
}
