


public class exp7 {
    public static int missing(int arr[]){
        int freq[] = new int[ (arr.length)+ 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = 0;
        }
       

        for(int i = 0; i < arr.length; i++){
            // if(freq[arr[i]] == 0){
            //     freq[arr[i]]++;
            // }
            // else{
            //     return arr[i];
            // } 
            // System.out.println(i);
            // System.out.println(arr[i]);
            freq[arr[i]]++;
            }
        for(int i = 1; i < freq.length; i++){
            if(freq[i] == 0){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 4};
        System.out.println(missing(arr));
    }
}
