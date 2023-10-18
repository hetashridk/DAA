public class exp5 {

    public static int platfromCount(int[] arr, int dept[]){
        int plat = 1;
        int platcount = 1;
        int i = 1;
        int j =  0;

        while(i < arr.length && j < arr.length){
            if(dept[i] > arr[j]){
                plat++;
                i++;
                // platcount = 1;
            }
            else{
                plat--;
                j++;
            }
            platcount = Math.max(plat,platcount);
            
        }

        return plat;
    }
    public static void main(String[] args) {
        int arr[] = {900, 950, 1300, 1500};
        int dept[] = {1000, 1200, 1400, 1600};
        System.out.println(platfromCount(arr, dept));
    }
}
