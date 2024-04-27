public class IndirectKMP {
    
    public static int[] giveLPS(String s){

        int n=s.length();

        int[] lps=new int[n];
        int prev=0,i=1;
        while(i<n){

            if(s.charAt(i)==s.charAt(prev)){
                lps[i]=++prev;
                i++;
            }
            else if(prev==0){
                lps[i]=0;
                i++;
            }

            else{
                prev=lps[prev-1];
            }
        }

        return lps;

    }

    public static int stringToAdd(String str){

        StringBuilder s=new StringBuilder();
        s.append(str);
        String rev=s.reverse().toString();
        s.reverse().append("#").append(rev);

        int[] lps=giveLPS(s.toString());

        return str.length()-lps[s.length()-1];
    }

    public static void main(String[] args) {
        
        System.out.println(stringToAdd("aacecaaa"));
        System.out.println(stringToAdd("abcd"));
        System.out.println(stringToAdd("aaaaaaa"));
    }
}
