package Amazon;


/***
 *
 * You are given:
 * An integer array packages[i], where each element represents the number of packages currently assigned to the i-th delivery center.
 * An integer extra_packages, which denotes the total number of additional packages that must be distributed among the delivery centers.
 * Our mission this time is to help the company calculate the minimum possible value of the maximum number of packages assigned to any 
   delivery center after distributing all the extra packages optimally.
 *
 * Example 1:
 * Input:  packages = [7, 5, 1, 9, 1], extra_packages = 25
 * Output: 10
 * Explanation: There are other possible optimal assignments, but the minimum value of the maximum value of the maximum number of pacakges
   any delivery center will deliver is 10.
 *
 * Input:  packages = [1, 2, 3], extra_packages = 3
 * Output: 3
 * Explanation:
 *
 * Assign two extra pacakges to the 1st delivery center and one extra to the second center.
 *
 * Eventually, each center will have to send three packages.
 *
 *
 * Input:  packages = [1], extra_packages = 3
 * Output: 4
 * Explanation:
 *
 * Because we have only 1 delivery center, all the extra packages will be assigned to the same :)
 *
 */

public class MinimizeMaximumParcels {


    public static int minimizeMaximumParcels(int[] packages, int extraParcels) {
        // write your code here

        int max =0;
        int n = packages.length;

        for(int i:packages)
            max = Math.max(max,i);

        for(int i=0;i<n;i++){
            int diff = max -packages[i];
            extraParcels -= diff;
        }

        if(extraParcels>0){
            float multiple = extraParcels/n;

            if(multiple<=1)
                max++;
            else{
                max+= (int)Math.ceil(multiple);
            }
        }

        return max;
    }

    public static void main(String args[]){

        int  packages[][] ={ {7, 5, 1, 9, 1}, {1, 2, 3},{1}   };

        int extra_packages[] = new int[]{25,3,3};

        for(int i=0;i<extra_packages.length;i++)
        System.out.println(minimizeMaximumParcels(packages[i],extra_packages[i]));

    }
}
