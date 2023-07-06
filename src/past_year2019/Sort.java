package past_year2019;

class SalesList{
    public String region;
    public int salesAmount;
    public String rep_name;

    SalesList(){
        region = null;
        salesAmount = 0;
        rep_name = null;
    }

    SalesList(String region, int salesAmount, String name){
        this.region = region;
        this.salesAmount = salesAmount;
        this.rep_name = name;
    }


}

class SortSaleList{
    //sorting region using selection sort descending
    public static void selectionSort(SalesList[] lists){
     
        for(int i = 0 ; i < lists.length ; i++){
            Comparable currItem = lists[i].region;
            SalesList current = lists[i];
            int currMax = i;
         for(int j = i + 1 ; j < lists.length ; j++){
             if(currItem.compareTo(lists[j].region) < 0){
                 currMax = j;
                 lists[i] = lists[j];
             }
             
         }
         if(currMax != i){
             lists[currMax] = current;
         }
           
         
        }
    }

    //insertion sort in ascending order [Sales Amount]
    public static void insertionSort(SalesList[] lists){
        for(int i= 1; i< lists.length ; i++){
            Comparable item = lists[i].salesAmount;
            SalesList list = lists[i];
            int k;

            for(k=i-1; k>=0 && item.compareTo(lists[k].salesAmount) < 0; k--){
                    lists[k+1] = lists[k];
            }

            lists[k+1] = list;
        }
    }

    //sort sales representative using bubble sort in ascending order
    public static void bubbleSort(SalesList[] lists){
        int n = lists.length;
        for(int i=0;i< n-1; i++){
            
            for(int j=0;j<n-i-1;j++){
                Comparable currItem = lists[j].rep_name;
                if(currItem.compareTo(lists[j + 1].rep_name) > 0){
                    SalesList temp = lists[j];
                    lists[j] = lists[j+1];
                    lists[j+1] = temp;
                }
            }
        }
    }



}



public class Sort {
    public static void main(String[] args) {
        String[] regions = {"Asia" , "Europe" ,"Europe", "Greenland", "Asia","Greenland","Asia"};
        int[] amount = {450,518,650,200,390,670,790};
        String[] name = {"Ahamd" , "Hemish" ,"Banny", "Ain", "Ali","Ben","Lee"};
      SalesList[] lists = new SalesList[regions.length];
        System.out.println("Original data:");
      for(int i = 0; i < regions.length ; i++){
          System.out.printf("%-10s %-3d %-1s \n",regions[i] , amount[i], name[i]);
          lists[i] =  new SalesList(regions[i] , amount[i], name[i]);
      //    System.out.println("regions[i] : " + regions[i]);
      }

      SortSaleList satu = new SortSaleList();

       System.out.println("\nSorting Result on Region using SelectionSort");
       satu.selectionSort(lists);  
            for (int i = 0; i < lists.length; i++) {
                    System.out.printf("%-10s %-3d %-1s \n", lists[i].region, lists[i].salesAmount, lists[i].rep_name);
        }




        System.out.println("\nSorting Result on Sales using InsertionSort");
        satu.insertionSort(lists);
            for(int i = 0; i < regions.length ; i++){
                    System.out.printf("%-10s %-3d %-1s \n",lists[i].region , lists[i].salesAmount, lists[i].rep_name); 
        }

        System.out.println("\nSorting Result on SortReps using BubbleSort");
        satu.bubbleSort(lists);
        for(int i = 0; i < regions.length ; i++){
            System.out.printf("%-10s %-3d %-1s \n",lists[i].region , lists[i].salesAmount, lists[i].rep_name); 
         } 

        
    }
    
}
