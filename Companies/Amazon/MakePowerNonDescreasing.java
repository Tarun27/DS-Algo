package Amazon;

/***
 * Suppose we, together, run a cloud computing company that offers a highly scalable system that allows applications to expand efficiently. We now have a set of n servers that are used to horizontally scale an application.
 * The objective is to ensure that the computational power of these servers is arranged in a non-decreasing order.
 * To achieve this, we are allowed to increment the computational power of any contiguous segment of servers by a chosen value z. The challenge is to determine the optimal values of z for different segments so that, once the computational powers are in the desired non-decreasing order, the total sum of all chosen z values across the entire process is minimized.
 * Example 1:
 * Input:  powa = [3, 4, 1, 6, 2]
 * Output: 7
 * Explanation:
 *
 * Input:  powa = [3, 2, 1]
 * Output: 2
 * Explanation:
 *
 *
 * Adding one unit to subarray (1, 2) and one unit to subarray (2, 2). The final arrangement of server is [3, 3, 3].
 *
 *
 * Input:  powa = [3, 5, 2, 3]
 * Output: 3
 * Explanation:
 *
 *
 * Lets add three units to subarray (2, 3). The final arrangement of servers is now 3, 3, 5, 6...(To be continued...)
 *
 */



public class MakePowerNonDescreasing {

    public static int makePowerNonDescreasing(int[] powa) {

        int ans =0;

        int carry =0;

        for(int i=0;i<powa.length-1;i++){

            if( powa[i] > powa[i+1] ){
                int diff = powa[i] - powa[i+1];
                ans += diff;
            }
        }


        return ans;

    }



    public static void main(String args[]){

        int[][] powa = { {3, 4, 1, 6, 2}, {3, 2, 1} ,{3, 5, 2, 3} };

        int[] sol = {7,2,3};

        for(int[] input: powa){

            System.out.println(makePowerNonDescreasing(input));
        }


    }


}
