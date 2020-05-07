import java.util.ArrayList;
import java.util.Collections;

public class Interval {
    int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

    public static void main(String[] args) {
        Solution101 s= new Solution101();
        //[1,3],[2,6],[8,10],[15,18]
        ArrayList<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        s.merge(intervals);
    }
}
class Solution101 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null) return null;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        System.out.println(intervals);
        ArrayList<Interval> merged = new ArrayList<>();

        for (Interval current : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() -1).end < current.start) {
                merged.add(current);
            } else {
                merged.get(merged.size() -1).end = Math.max(current.end,
                        merged.get(merged.size() -1).end);
            }
        }
        return merged;
    }
}
