package Amazon;


/***
 * The team at a TomTom International factory has been assigned a critical optimization task aimed at improving the efficiency of packing
   a set of boxes, each labeled with a unique ID. These boxes are initially arranged in a single row from left to right, where the ID
   of the i-th box is represented by the string s_id, which consists of digits ranging from 0 to 9, inclusive.
 * To streamline the packing process, the team has been granted the ability to perform a specific operation an arbitrary number of times,
   including zero times if necessary. The operation is defined as follows:
   
 * The team can choose any index within the string s_id and remove the digit at that position.
 * After removing the selected digit, the team can insert a new box with an updated ID. The new ID is determined by computing min(s_id[i] + 1, 9),
   ensuring that the new ID does not exceed 9.
 * Given the initial arrangement of boxes represented by the string s_id, the goal is to determine the lexicographically minimal string
   that can be achieved by applying the allowed operations optimally.
 * Clarification on Lexicographic Order:
 * A string X is considered lexicographically smaller than another string Y of the same length if and only if, at the first position where
   X and Y differ, the corresponding digit in X is smaller than the corresponding digit in Y.
 * Objective: Find and return the lexicographically smallest possible string that can be formed by performing the given operation
   any number of times.
 *
 *  Example 1:
 *
 * Input:  id = "26547"
 * Output: "24677"
 *
 *
 */

public class BestWayToPack {

    public static String bestWayToPack(String id) {
        // write your code here

        int l = id.length();

        StringBuilder sb  = new StringBuilder(id);

        for(int i =l-1;i>=0;i--){

            int j =i-1;

            if(j>=0 && sb.charAt(j) > sb.charAt(i)){
                adjustIdPosition(sb,j);
            }

        //    System.out.println(sb.toString());

        }

        return sb.toString();

    }

    private static void adjustIdPosition(StringBuilder sb, int j) {

        char c = sb.charAt(j);

        sb.deleteCharAt(j);

        char newChar = (char) ( Math.min( (int)(c-'0'+1), 9 ) + '0' ) ;


     //   char newChar = c == '9' ? '9' : (char)(c + 1);


        int l = sb.length()-1;

        while(l>=0  &&  sb.charAt(l) >  newChar   )  {
            l--;
        }
        // 2647
     //   System.out.println(sb.charAt(l) + "   " + newChar);
        sb.insert(l+1,newChar);

    }


    public static void main(String args[]){

        System.out.println(bestWayToPack("26547"));

        System.out.println(bestWayToPack("12345"));

        System.out.println(bestWayToPack("2413"));
        

    }
}
