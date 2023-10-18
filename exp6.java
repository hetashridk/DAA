// Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.

// brute force :- TC = O(n^2)
    // two for loop
    //one for loop i = 0 to i < n 
    //second for loop j = i+1  to  n
    // compare arr[i] == arr[j]

// 2nd approach:- TC = O(n logn)
    //first sort array
    // then loop i = 0 to i < n
    // compare arr[i] == arr[j]


public class exp6 {
    public static int duplicate(int arr[]){
        int freq[] = new int[arr.length + 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = 0;
        }

        for(int i = 1; i < freq.length; i++){
            // if(freq[arr[i]] == 0){
            //     freq[arr[i]]++;
            // }
            // else{
            //     return arr[i];
            // } 
            freq[arr[i]]++;
            if(freq[arr[i]] != 0 || freq[arr[i]] != 1){
                return arr[i];
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 4};
        System.out.println(duplicate(arr));
    }
}
