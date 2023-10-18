public class merge {

    public static int[] mergeSort(int arr[]){

        if(arr.length == 1){
            return;
        }
         int arr1[] = new int[5];
         int arr2[] = new int[5];
        
         arr1 = mergeSort(arr1);
         arr2 = mergeSort(arr2);

         merge(arr1, arr2);

    }

    public static void merge(int arr1[], int arr2[]){
        int arr3[] = new int[10];

        int i1 = 0;
        int i2 = 0;
        int j1 = arr1.length - 1;
        int j2 = arr2.length - 1;
        while(j1 != 0 && j2 != 0){
            if(arr1[i1] > arr2[i2]){
                arr3[i1] = arr2[i2];
                j1++;
            }
            else{
                arr3[i1] = arr1[i1];
                i1++;
            
            }
        }

        while(j1 != 0){
            if(arr2[i2]<=arr3[i3]){
                
            }

        }
    }
    public static void main(String[] args) {
        
    }
}
