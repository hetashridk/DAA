public class exp2 {
    public static int insert(int arr[], int target){  //O(Log n)
        int si = 0;
        int ei = arr.length - 1;
        int mid;

        while(si <= ei){
            mid = si + (ei - si) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                si = mid + 1;
            }
            else{
                ei = mid - 1;
            }
        }

        return si;
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, 7, 9};
        System.out.println(insert(arr, 1));
    }
}
