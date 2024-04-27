public class DirectKMP {
    
    public static int kmp(String haystack,String needle){

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

    public static int countOccur(String haystack,String needle){

        int count=0;

        String s=haystack;
        while(s.length()>=needle.length()){
            int id=kmp(s,needle);
            if(id!= -1){
                count++;
                s=s.substring(id+1);
            }
            else return count;
        }

        return count;
    }

    public static void main(String[] args) {
        


        String haystack="AAAAAAAAAA";
        String needle="AAA";
        System.out.println(countOccur(haystack, needle));
    }
}
