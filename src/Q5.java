/**Bitonic search: An array is bitonic if it is comprised of an increasing sequence of integers
followed immediately by a decreasing sequence of integers. Write a program in java that, given a
bitonic array of N distinct int values, determines whether a given integer is in the array. Your
program should use ~3 lg N compares in the worst case */
public class Q5 {

    public Q5(int[] arr, int size){
        bitonic = arr;
        N = size;
    }

    public boolean bitonicSearch(int key){
        //binary search, but sort is out of order. But they are in order in their respective halves.
        //Need to determine if middle is left or right of center. Can do a modified binary search
        //(with edge cases) to find middle.
        //if left and right are lower => at middle. (first, others follow as else.)
            //consider searches around as two smaller sorted arrays
        //left is lower, and right is higher => left hand side. 
            //left can be searched binarily, else comparsion must be used again.
        //right is lower, left is higher => right hand side.
            //right can be searched binarily, else comparison must be used again.
        int directLeft = 0, directRight = 0, mid = 0;
        int low = 0, high = N-1;
        if (bitonic[low]> bitonic [low + 1])
            return rightBinarySearch(key, low, high);//full inverse array
        if (bitonic[high] > bitonic [high - 1])
            return leftBinarySearch(key, low, high);//full normal array.
        while (low <= high){ //binary max search.
            mid = low + (high-low)/2;
            directLeft = mid - 1;
            directRight = mid + 1;
            if(bitonic[mid] > bitonic[directLeft] && bitonic[mid] > bitonic[directRight]) break; //middle is max.
            if (bitonic[directLeft] < bitonic[directRight]) low = mid + 1;//mid is on left side of bitonic max.
            else high = mid -1 ;//mid is on right side of bitonic max.
        }

        if (leftBinarySearch(key, 0, mid)) return true;
        else return (rightBinarySearch(key, mid, N-1));
    }

    public boolean leftBinarySearch(int key, int low, int high){ //low on left, high on right
        while (low <= high){
            int mid = low + (high-low)/2;
            if (bitonic[mid] == key) return true;
            if(bitonic[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    public boolean rightBinarySearch(int key, int low, int high){ //low on right, high on left
        while (low <= high){
            int mid = low + (high-low)/2;
            if (bitonic[mid] == key) return true;
            if (key < bitonic[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
    
    private int[] bitonic;
    private int N;
}
