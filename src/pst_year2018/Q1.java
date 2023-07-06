package pst_year2018;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("The tower has 64 layer");
        int layer = 64;

        //calculate how many step I need to iterate for this
        double tStep = Math.pow(2, layer);
        int totalS = (int) tStep;

        System.out.println("The total step need to be done are: " + totalS);

        //Trying a simple 8 layer of tower of hanoi
        towerOfHanoi(4, 'A', 'B', 'C');
    }

    public static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod){
        if(n==1){
            System.out.println("Take 1 disk from rod" + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, to_rod, helper_rod);
        System.out.println("Take disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }
}
