

/***
 * 
   Amazon games have recently launched a new multi-player tournament on the platform. Each game of the tournament has 3 rounds.
   The players are provided with exactly three power boosters at the start of the game and each player is aware of the power boosters of their
   opponent. In each round, the player can choose to compete with any of the power boosters and any power booster can be used at most once in a 
   particular game. In any particular round, the player with a higher power booster wins.
   
 * A player X is considered to be capable of defeating player Y if there exists a rearrangement of power boosters of X such that some
   rearrangement of power boosters of Y can be defeated in at least 2 out of the three rounds. For example, if power boosters of X = [9, 5, 11]
   and Y = [7, 12, 3], then
   
 * If Y uses the boosters in order [3, 7, 12] then X can use it in order [11, 9, 5] and X wins 2 out of the three games as 11 > 3 and 9 > 7.
   Thus X is capable of defeating Y.
   
 * If X uses the boosters in order [5, 9, 11] then Y can use it in order [7, 12, 3] and Y wins 2 out of the three games as 7 > 5 and 12 > 9. 
   Thus Y is also capable of defeating X.
   
 * Another example is if X = [1, 2, 3] and Y = [3, 4, 5]. Here X is not capable of defeating Y as any rearrangement of Y can not be defeated 
   by X in at least two rounds.
   
 * Given the power boosters provided to n players where the three power boosters of the ith player are defined by (power_a[i], power_b[i],
   power_c[i]), find the number of players who are capable of defeating all other players in a game by using their power boosters optimally.
   It is guaranteed that all powers of each player's power boosters are distinct.
   
 * Function Description
 * Complete the function findCapableWinners in the editor.
 * findCapableWinners has the following parameter:
 * int power_a[n]: the first set of power boosters
 * int power_b[n]: the second set of power boosters
 * int power_c[n]: the third set of power boosters
 * Returns
 * int: the number of players capable of defeating all other players
 *
 *
 *
 * Input:  power_a = [9, 4, 2], power_b = [5, 12, 10], power_c = [11, 3, 13]
 * Output: 2
 * Explanation:
 *
 *
 * Consider the number of players to be n = 3, and their first set of power boosters to be power_a = [9, 4, 2],
   their second set of power boosters to be power_b = [5, 12, 10] and their third set of power boosters to be power_c = [11, 3, 13]. 
   Thus, Player 1 has power boosters [9, 5, 11], Player 2 has [4, 12, 3] and Player 3 has power boosters [2, 10, 13].
 *
 * Player 1 can defeat Player 2 by playing in the following way: 5 against 3, 9 against 4, 11 against 12; Player 1 wins the first 2 rounds
 * Player 1 can defeat Player 3 by playing in the following way: 5 against 2, 9 against 13, 11 against 10; Player 1 wins the first and last rounds.
 * Player 2 cannot defeat Player 1 using any combination of powers.
 * Player 2 can defeat Player 3 by playing in the following way: 4 against 2, 12 against 10, 3 against 13; Player 2 wins the firt 2 rounds.
 * Player 3 can defeat Player 1 by playing in the following way: 2 against 5, 10 against 9, 13 against 11; Player 3 wins the last 2 rounds.
 * Player 3 can defeat Player 2 by playing in the following way: 2 against 12, 10 against 4, 13 against 3; Player 3 wins the last 2 rounds.
 * Thus, Player 1 and Player 3 can defeat all the players using their power boosters optimally. Thus, the answer is 2.
 *
 */



public class FindCapableWinners {

    public static int findCapableWinners(int[] power_a, int[] power_b, int[] power_c) {
        // write your code here

        int n = power_a.length;

        int mid[] = new int[n];
        int strong[] = new int[n];

        int maxMid = Integer.MIN_VALUE;
        int maxWeak = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            int p1 = power_a[i];  // weakest
            int p2 = power_b[i];  // mid
            int p3 = power_c[i];  // strongest


            if(p1 > p2) { int tmp  = p1; p1 = p2; p2 = tmp;}
            if(p1 > p3) { int tmp  = p1; p1 = p3; p3 = tmp;}
            if(p2 > p3) { int tmp  = p2; p2 = p3; p3 = tmp;}

            mid[i] = p2;
            strong[i] = p3;

            maxMid = Math.max(maxMid,p2);
            maxWeak = Math.max(maxWeak,p1);


        }

        int count=0;
        for(int i=0;i<n;i++){
            if(strong[i] > maxMid && mid[i] > maxWeak){
                count ++;
            }
        }

        return count;

    }


    public static void main(String args[]){

        int[] power_a = {9, 4, 2};
        int[] power_b = {5, 12, 10};
        int[] power_c = {11, 3, 13};

        System.out.println(findCapableWinners(power_a, power_b, power_c));
    }


}
