import java.util.*;

public class KMP{

    static int kmp(String haystack,String needle){

        int n=haystack.length();
        int m=needle.length();

        if(m==0) return 0;

        //? create an longest prefix suffix array
        int[] lps=new int[m];
        int prev=0,i=1;

        while(i<m){

            if(needle.charAt(i)==needle.charAt(prev)){
                lps[i]=++prev;
                i++;
            }
            else if(prev==0){
                lps[i]=0;i++;
            }
            else{
                prev=lps[prev-1];
            }
        }

        i=0; //* pointer for haystack
        int j=0; //* pointer for needle
        while(i<n){

            if(haystack.charAt(i)==needle.charAt(j)){
                i++;j++;
            }
            else{
                if(j==0) i++;
                else j=lps[j-1];
            }

            if(j==m) return i-m;
        }


        return -1;
    }

    static String lcps(Vector<String> arr){

        String ans="";

        int len=Integer.MAX_VALUE;
        for(String s:arr){

            if(len<s.length()){
                len=s.length();
            }
        }

        int i=0;
        while(i<len){
            char c=arr.get(0).charAt(i);

            for(int j=0;j<arr.size();j++){
                if(c!=arr.get(j).charAt(i)){
                    return ans;
                }
            }

            ans+=c;
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        
        Vector<String> arr=new Vector<>();
        arr.add("sadadadaghjt");
        arr.add("sadadadaghjt");
        arr.add("sadadaghjt");
        arr.add("sadadadadadadaghjt");


        System.out.println(lcps(arr));
        
    }
}