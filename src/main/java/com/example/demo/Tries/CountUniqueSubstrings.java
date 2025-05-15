
package com.example.demo.Tries;
public class CountUniqueSubstrings {
    static class Node {
        Node children[];
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            endOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node(); // as Root is an empty Node ...

    public static void insert(String word) {
        // step 1 :
        Node curr = root;
        // step 2 : checking and insert
        for (int level = 0; level < word.length(); level++) {
            // step 3 : check if the curr's next level has a curr word or not ..if not then
            // create an new node..
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // step 4 : change our curr level to next level(i.e move to next level)..
            curr = curr.children[idx];

        }
        // step 5: here we reach the end of the word .. now make the endOfWord True
        curr.endOfWord = true;
    }

    //count the nodes
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i= 0;i<26;i++){
            if(root.children[i]!= null){
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }

}
