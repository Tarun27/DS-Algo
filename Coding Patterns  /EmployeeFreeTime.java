// merge Intervals pattern

import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class Solution {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();
   
        // Step 1: Collect all intervals from each employee's schedule
        for (List<Interval> list : schedule) {
            allIntervals.addAll(list);
        }
   
        // Step 2: Sort intervals by their start time
        allIntervals.sort((a, b) -> a.start - b.start);
   
        // Step 3: Merge overlapping intervals
        List<Interval> merged = new ArrayList<>();
        Interval prev = allIntervals.get(0);

        for (int i = 1; i < allIntervals.size(); i++) {
            Interval curr = allIntervals.get(i);
            
            if (prev.end >= curr.start) {
                // Merge the intervals
                prev.setEnd(Math.max(curr.getEnd(), prev.getEnd()));
            } else {
                // No overlap, add the previous interval to merged and move to the current one
                merged.add(prev);
                prev = curr;
            }
        }
        // Add the last interval
        merged.add(prev);
   
        // Step 4: Find the free time between merged intervals
        List<Interval> ans = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            Interval prevInterval = merged.get(i - 1);
            Interval currInterval = merged.get(i);
            
            // Free time is the gap between the previous interval's end and the current interval's start
            if (prevInterval.getEnd() < currInterval.getStart()) {
                ans.add(new Interval(prevInterval.getEnd(), currInterval.getStart()));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule = Arrays.asList(
            Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
            Arrays.asList(new Interval(2, 4)),
            Arrays.asList(new Interval(2, 5), new Interval(9, 12))
        );

        List<Interval> freeTime = employeeFreeTime(schedule);

        System.out.println("Employee Free Time:");
        for (Interval interval : freeTime) {
            System.out.println(interval);
        }
    }
}
