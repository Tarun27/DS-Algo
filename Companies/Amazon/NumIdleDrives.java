package Amazon;

import java.util.*;

/**
 *
 * The Banana Company employs small, autonomous transport units, known as "Bananaer", to efficiently carry large stacks of products within its warehouses. These Bananaer navigate along predefined paths in a warehouse, which can be represented as a Cartesian plane. Each Bananaer is stationed at distinct integral coordinate points of the form (x, y).
 * When a product needs to be delivered to a specific location (i, j), the system selects the nearest available Bananaer to complete the task. However, some Bananaers may seldom be chosen due to being surrounded by other units.
 * A Bananaer is considered idle if it has another Bananaer positioned directly above, below, to the left, and to the right of it. This means it is entirely enclosed and less likely to be selected for work. It is guaranteed that no two Bananaers share the same coordinates.
 * Given the locations of n Bananaers on the Cartesian plane, determine how many Bananers are idle based on the above criteria.
 * Example 1:
 * Input:  x = [0, 0, 0, 0, 0, 1, 1, 1, 2, -1, -1, -2, -1], y = [-1, 0, 1, 2, -2, 0, 1, -1, 0, 1, -1, 0, 0]
 * Output: 5
 * Explanation:
 *
 * The robots at locations (0, 0), (1, 0), (-1, -0), (0, 1), and (0, -1) are idle as they are surrounded by robots on all 4 sides.
 *
 *
 *Input:  x = [1, 1, 1, 2, 2, 2, 2, 3, 3, 3], y = [1, 2, 3, 1, 2, 3, 5, 1, 2, 3]
 * Output: 2
 * Explanation:
 *
 *The robot at (2, 2) is idle because it has robots at (1, 2), (3, 2), (2, 3), and (2, 1) directly to the left, right, up, and down respectively.
 *
 *
 * The robot at (2, 3) is idle because it has robots at (1, 3), (3, 3), (2, 5), and (2, 2) directly to the left, right, up, and down respectively.
 *
 *
 * There are 2 idle robots in this arrangement.
 *
 */
public class NumIdleDrives {

    public static int numIdleDrives(int[][] x) {
        // write your code here
        int ans = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < x[0].length; i++) {
            set.add(encode(x[0][i], x[1][i]));
        }

        int n =  x[0].length;

        for (int i = 0; i <n; i++) {

            int xi=x[0][i];
            int yi = x[1][i];

            boolean left = false;
            boolean right = false;
            boolean top = false;
            boolean bottom = false;

            for(int j=0;j<n;j++){

                // check top and bottom
                if( x[0][j] == xi ){

                    if(x[1][j] > yi) top = true;
                    if(x[1][j] < yi) bottom = true;
                }

                // check left and right

                if( x[1][j] == yi ){

                    if(x[0][j] > xi) right = true;
                    if(x[0][j] < xi) left = true;
                }


            }

            if( left && right && top && bottom) ans++;
        }

        return ans;
    }

    public static String encode(int x, int y){
        return x + "," + y;
    }


    public static void main(String args[]){

        int[][]  x = {
                      {0, 0, 0, 0, 0, 1, 1, 1, 2, -1, -1, -2, -1},
                      {-1, 0, 1, 2, -2, 0, 1, -1, 0, 1, -1, 0, 0}
                      };


        int[][] y = {
                   {1, 1, 1, 2, 2, 2, 2, 3, 3, 3},
                   {1, 2, 3, 1, 2, 3, 5, 1, 2, 3}
                   };

        /**
         *             0,2
         *
         *    -1,1  :  0  1 :  1,1
         *
         *             0,0
         */


        System.out.println(numIdleDrives(x));
        System.out.println(numIdleDrives(y));




        System.out.println(countIdleRobots(x[0],x[1]));

        System.out.println(countIdleRobots(y[0],y[1]));
        }

    /**
     *
     If you want a more efficient solution (O(n)) when the number of points is large, you can precompute, for each row and column, the minimum and maximum coordinate values. In this interpretation:

     A robot in a given row is not “edge” (i.e. has a robot to its left and right) if its x value is strictly between the minimum and maximum x in that row.
     A robot in a given column is not “edge” (i.e. has a robot above and below) if its y value is strictly between the minimum and maximum y in that column.
     Here’s an implementation that uses hash maps to record the boundaries for each row and column:
     */
    public static int countIdleRobots(int[] x, int[] y) {
        int n = x.length;
        // Map for each row: y -> [minX, maxX]
        Map<Integer, int[]> rowMap = new HashMap<>();
        // Map for each column: x -> [minY, maxY]
        Map<Integer, int[]> colMap = new HashMap<>();

        // Build the maps.
        for (int i = 0; i < n; i++) {
            
            int xi = x[i], yi = y[i];
            
            rowMap.putIfAbsent(yi, new int[]{xi, xi});
            
            int[] rowRange = rowMap.get(yi);
            rowRange[0] = Math.min(rowRange[0], xi);
            rowRange[1] = Math.max(rowRange[1], xi);

            colMap.putIfAbsent(xi, new int[]{yi, yi});
            int[] colRange = colMap.get(xi);
            colRange[0] = Math.min(colRange[0], yi);
            colRange[1] = Math.max(colRange[1], yi);
        }

        int idleCount = 0;
        // Check each robot against the row and column boundaries.
        for (int i = 0; i < n; i++) {
            int xi = x[i], yi = y[i];
            int[] rowRange = rowMap.get(yi);
            int[] colRange = colMap.get(xi);

            // Robot is idle if it is not at the extreme in its row or column.
            if (xi > rowRange[0] && xi < rowRange[1] && yi > colRange[0] && yi < colRange[1]) {
                idleCount++;
            }
        }

        return idleCount;
    }

}
