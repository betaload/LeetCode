package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0 ) {
            return intervals;
        }

        // Comparator<Interval> comparator1 = Comparator.comparing(p -> p.start);
        // Comparator<Interval> comparator2 = Comparator.comparing(i -> i.end);
        // Collections.sort(intervals, comparator1.thenComparing(comparator2));

        Comparator<Interval> comparator1 = Comparator.<Interval, Integer>comparing(p -> p.start).thenComparing(p -> p.end);
//        Collections.sort(intervals, comparator1);
        intervals.sort(comparator1);
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        intervals.remove(0);
        for(Interval i : intervals) {

            if(i.start > res.get(res.size()-1).end) {
                Interval in = new Interval(i.start, i.end);
                res.add(in);
            } else {
                if(i.end > res.get(res.size()-1).end) {
                    res.get(res.size()-1).end = i.end;
                }
            }

        }
        return res;
    }
}

  class Interval {
      public int start;
      public int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

