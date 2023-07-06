package Search_Sort;

public class Search {

    //this method will return the index of the search
    public static int linearSearch(int[] list, int key){
        for(int i=0;i< list.length;i++)
            if(key == list[i])
                return i;
        return -1;
    }

    // binary search = the item must already be odered from small to big
    // left to right

    public static int binarySearch(int[] list, int key){
        int low = 0;
        int high = list.length-1;

        while(high >= low){
             int mid = (low + high)/2;
            if(key < list[mid]){
                high = mid -1;
            }
            else if(key==list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1 - low;
    }

    //selection sort - sort it 1 by 1 
    public static void selectionSort(double[] list){
        for(int i = 0; i< list.length; i++){
            //Find the minimum in the list
            double currentMin = list[i];
            int currentMinIndex = i;

            for(int j= i; j< list.length; j++){
                if(currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
        //swap list[i] if necessary
        if(currentMinIndex != i){
            list[currentMinIndex] = list[i];
            list[i] = currentMin;
        }
        }        
    }

    //insertion sort
    public static void insertionSort(int[] list){
        for(int i = 1; i < list.length ; i++){
            int currentElement = list[i];
            int k;
            //inner loop
            for(k = i -1; k>=0 && list[k] > currentElement; k--){
                list[k+1] = k;
            }
        }
    }

    //bubble sort
    public static void bubbleSort(int[] list){
        boolean needNextPass = true;
        for(int k = 1; k <list.length;k++){
            needNextPass = false;
            for(int i = 0; i < list.length -1 ; i++){
                if(list[i] > list[i+1]){
                    //Swap list[i] with list[i+1]
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                        needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println("Testing linear search");
        int[] nombor = {10,20,30,40,50,60,70,80,90};
        double[] list = {-2,4.5,5,1,2,-3.3};
        int[] waduh = {-2,3,5,-1,20,50};
        int cari = 70;

        //System.out.println(binarySearch(nombor, cari));
        bubbleSort(waduh);
        for(int i=0;i< waduh.length ; i++){
            System.out.print(waduh[i] + " ");
        }
    }
    
}
