import java.util.*;

class TrieNode{

    Map<Character,TrieNode> children;
    char c;
    boolean isEnd;

    TrieNode(char c){
        this.c=c;
        children=new HashMap<>();
    }

    TrieNode(){
        children=new HashMap<>();
    }

    void insert(String word){
        if(word==null || word.isEmpty()) return;

        char firstChar=word.charAt(0);
        TrieNode child=children.get(firstChar);

        if(child==null){
            child=new TrieNode(firstChar);
            children.put(firstChar,child);
        }

        if(word.length()>1){
            child.insert(word.substring(1));
        }
        else child.isEnd=true;
    }
}

/**
 * Trie
 */
public class trie {

    TrieNode root;

    public trie(List<String> words){
        root=new TrieNode();
        for(String word:words){
            root.insert(word);
        }
    }

    public boolean find(String prefix,boolean exact){
        TrieNode curr=root;

        for(char c:prefix.toCharArray()){
            curr=curr.children.get(c);
            if(curr==null){
                return false;
            }
        }

        return !exact || curr.isEnd;
    }

    public boolean find(String prefix){
        return find(prefix,false);
    }

    public void suggestion(TrieNode root,List<String> list,StringBuffer curr){

        //? StringBuffer : String that can be modified using called methods

        if(root.isEnd){
            list.add(curr.toString());
        }

        if(root.children==null || root.children.isEmpty()){
            return;
        }

        for(TrieNode child:root.children.values()){
            suggestion(child, list, curr.append(child.c));
            curr.setLength(curr.length()-1);
        }
    }

    public List<String> suggest(String prefix){
        List<String> list=new ArrayList<>();
        TrieNode lastNode=root;
        StringBuffer curr=new StringBuffer();
        for(char c:prefix.toCharArray()){
            lastNode=lastNode.children.get(c);
            if(lastNode==null){
                return list;
            }
            curr.append(c);
        }

        suggestion(lastNode,list,curr);
        return list;
    }

    public static void main(String[] args){
        List<String> words=List.of("mobile","mouse","mousepad","monitor","moneypot");

        trie t=new trie(words);

        System.out.println(t.suggest("m"));
        System.out.println(t.suggest("mon"));
        System.out.println(t.suggest("t"));
        System.out.println("mouse");
    }
    
}