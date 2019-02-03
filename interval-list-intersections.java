/* 
    题目：区间列表的交集
         给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。
         返回这两个区间列表的交集。
（形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）

*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
 /**code-finished_firstly**/
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> result = new ArrayList<> ();
        if(A.length==0||B.length==0)
        {
            return  result.toArray(new Interval[result.size()]);
        }
        int len1 = A.length;
        int len2 = B.length;
        for(int i=0;i<len1;i++)
        {
            Interval temp=A[i];
            int start = temp.start;
            int end = temp.end;
            int j=0;
            while(j<len2&&B[j].end<start) {j++;}
            for(;j<len2&&B[j].start<=end;j++)
            {
                Interval temp1 = B[j];
                int start1 = temp1.start;
                int end1 = temp1.end;
                if(start1>end||end1<start)
                {
                    continue;
                }
                 Interval in = new Interval ();
                if(start1<=end)
                {    
                     if(start1==end) 
                     {
                      in.start=end; 
                      in.end=end;
                      result.add(in);
                     }
                     if(start1<end)
                     {
                         if(end>end1)
                         {
                             in.end=end1;
                         }
                             
                         else
                         {in.end=end; }
                         if(start1<start)
                         {
                             in.start=start;
                         }
                         else
                         {
                             in.start=start1;
                         }
                         result.add(in);
                     }
                }
}
                
            }
        
        return  result.toArray(new Interval[result.size()]);
        
    }
}
