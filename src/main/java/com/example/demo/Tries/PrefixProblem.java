package com.example.demo.Tries;
public class PrefixProblem {
    //shortest unique prefix for any stirng
    //we can solve this problem by counting hte frequendcy of the lettes ,so that to avoid the same prefix...

    //step 1 : build the trie
    static class  Node {
    Node children[] = new Node[26];
    boolean endOfWord = false;
    int freq;
    public Node(){
        for(int i = 0;i<26;i++){
            children[i] = null;
        }
        freq = 1;
    }
        
    }
    static Node root = new Node();
    //insert method
    public static void insert(String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;

    }

    // step 2 : find prefix mehtod ..
    // In this method we start with the root and check the freq if the freq = 1 then than in the unique prefix . so we nned to tavel each node and check until the we get the freq = 1 , unit that add the letts to the ans and when we get the freq as 1 we return the ans ..\
    public static void findPrefix(Node node,String ans){
        //this an recursive function
        //check each and every node for freq

        if(root == null){
            return;
        }
        if(node.freq ==1 ){
            System.out.println(ans);
            return;
        }
        for(int i = 0;i<26;i++){
            if(node.children[i] != null){
                findPrefix(node.children[i], ans+(char)(i+'a'));
            }
        } 
    }
    public static void main(String[] args) {
        String words[] = {"dog","dove","zebra","duck"};
        for(int i = 0;i<words.length;i++){
            insert(words[i]);
        }
        root.freq = -1;
        findPrefix(root, "");
    }
}
