import java.util.*;

public class BucketSort {
    
    static Vector<Vector<Integer>>[] bs(Vector<Vector<Integer>> vec){

        int k=0;
        for(Vector<Integer> pair:vec){
            int num=pair.get(0);
            if(num>k) k=num;
        }

        // Count the frequency
        int[] count=new int[k+1];
        for(Vector<Integer> pair:vec){
            int num=pair.get(0);
            count[num]++;
        }

        // Apply prefix sum
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }

        // Create ans array
        Vector<Vector<Integer>>[] ans=new Vector[vec.size()];
        for(int i=0;i<vec.size();i++){
            ans[i] = new Vector<>();
        }

        for(int i=vec.size()-1;i>=0;i--){
            int num=vec.get(i).get(0);
            int id=--count[num];
            ans[id].add(vec.get(i));
        }

        return ans;
        
    }

    public static void main(String[] args) {
        Vector<Vector<Integer>> vec=new Vector<>();
        Vector<Integer> pair=new Vector<>();
        pair.add(50);pair.add(10);
        vec.add(pair);
        pair=new Vector<>();
        pair.add(10);pair.add(30);
        vec.add(pair);
        pair=new Vector<>();
        pair.add(20);pair.add(40);
        vec.add(pair);
        pair=new Vector<>();
        pair.add(50);pair.add(10);
        vec.add(pair);
        pair=new Vector<>();
        pair.add(10);pair.add(20);
        vec.add(pair);
        pair=new Vector<>();
        pair.add(15);pair.add(25);
        vec.add(pair);

        Vector<Vector<Integer>>[] ans=bs(vec);

        for (Vector<Vector<Integer>> bucket : ans) {
            for (Vector<Integer> p : bucket) {
                System.out.print(p.get(0) + ":" + p.get(1) + " ");
            }
            System.out.println();
        }
    }
}
