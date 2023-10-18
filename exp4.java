import java.util.Arrays;

public class exp4 {
    public static boolean canWePlace(int stalls[], int dist, int cows){
        int countCow = 1;
        int lastPlaced = stalls[0];

        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - lastPlaced >= dist){
                countCow++;
                lastPlaced = stalls[i];
            }
            if(countCow >= cows){
                return true;
            }
        }

        return false;
    }
    public static int cows(int stalls[], int cows){
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canWePlace(stalls, mid, cows)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return high;
    }
    public static void main(String[] args) {
        int stalls[] = {2, 4, 8, 9, 3};
        System.out.println(cows(stalls, 3));   
    }
}
