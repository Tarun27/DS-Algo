package Amazon;

import java.util.Arrays;


/***
 *
 * Imagine that the Banana Company is managing a queue of tasks that need to be executed sequentially. Each task is defined by 
   its processing time, represented in an array taskDurations[], where each index refers to a specific task.
   The execution of these tasks happens one after another, without any parallel processing.
   
 * The execution happens in work shifts, where each shift has a specified duration, represented by workShifts[].
   If a task isn't fully completed within the allocated shift time, it continues in the subsequent shift. 
   At the beginning of each shift, the processing resumes from where it left off in the previous shift.
   
 * Your objective is to determine the count of unfinished tasks at the conclusion of each shift.
 * Function Description
 * Complete the function computeUnfinishedTasks in the editor.
 * computeUnfinishedTasks has the following parameters:
 * 1. int[] taskDurations: an array of integers denoting the processing time required for each task
 * 2. int[] workShifts: an array of integers representing the duration of each shift
 * Returns
 * int[]: an array of integers indicating the number of unfinished tasks remaining after each shift
 * Example 1:
 * Input:  taskDurations = [1, 4, 4], workShifts = [9, 1, 4]
 * Output: [0, 2, 1]
 *
 *
 * Input:  taskDurations = [2, 4, 5, 1, 1], workShifts = [1, 5, 1, 5, 2]
 * Output: [5, 3, 3, 1, 0]
 * Explanation:
 *
 *
 *
 *      Shift 1: The first task is only partially completed, leaving [1, 4, 5, 1, 1] still to be done.
 *      At the end of Shift 1, 5 tasks remain unfinished.
 *      Shift 2: The first two tasks are fully processed, reducing the remaining work to [0, 0, 5, 1, 1].
 *      After Shift 2, the pending tasks are "5, 1, 1", leaving 3 tasks unfinished.
 *      Shift 3: The third task is partially completed, with the remaining work now being [0, 0, 4, 1, 1].
 *      After Shift 3, the remaining tasks are "4, 1, 1", meaning 3 tasks are still incomplete.
 *      Shift 4: The third and fourth tasks are completely processed, leaving [0, 0, 0, 0, 1].
 *      After Shift 4, only 1 task is still pending.
 *      Shift 5: The last task is completed, resulting in [0, 0, 0, 0, 0].
 *      By the end of Shift 5, all tasks have been processed! 🎉
 *      Thus, the number of unfinished tasks after each shift is: [5, 3, 3, 1, 0].
 *
 */

public class ComputeUnfinishedTasks {


    public static int[] computeUnfinishedTasks(int[] taskDurations, int[] workShifts) {
        // write your code here

        int currTask  = taskDurations[0];
        int workLen = workShifts.length;
        int taskLen = taskDurations.length;
        int j =0;
        int ans[] = new int[workLen];

        for(int i=0;i<workShifts.length;i++){

            int shift = workShifts[i];

            while( shift>0 ){

                if(currTask<=shift){
                    shift -= currTask;

                    j++;

                    if(j==taskLen){
                        currTask  = taskDurations[0];
                        break;
                    }

                    currTask = taskDurations[j];
                }else{
                    currTask -= shift;
                    break;
                }

            }

            ans[i] =  taskLen - j;

            j = j%taskLen;


        }

        return ans;
    }

    public static void main(String args[]){


        int[][] taskDurations = { {1, 4, 4}, {1, 2, 4, 1, 2}, {2, 4, 5, 1, 1} };
        int[][] workShifts = { {9, 1, 4}, {3, 10, 1, 1, 1}, {1, 5, 1, 5, 2} };

        for(int i=0;i<taskDurations.length;i++){

            int[] arr =  computeUnfinishedTasks(taskDurations[i],workShifts[i]);
            System.out.println(Arrays.toString(arr)  );
        }

    }

}
