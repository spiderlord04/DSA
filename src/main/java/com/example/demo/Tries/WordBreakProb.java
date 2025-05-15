
package com.example.demo.Tries;
import java.util.List;

public class WordBreakProb {
    //trie ka imple
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        public Node() {
            //initilize array with nulls
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        if (curr.endOfWord == true) {
            return true;
        }
        return false;
    }

    public static boolean helperWordBreak(String s) {
        //this is an recuresive function
        // The approach is to make substrings of the word and check them in the trie.
        // While making substrings, we start the loop from i = 1 because the substring method in Java
        // uses indices from 'beginIndex' (inclusive) to 'endIndex' (exclusive).
        // If we start with i = 0, then 'substring(0, -1)' would be invalid when j = -1.
        // To avoid this, we start from i = 1 so that when we call 'substring(j, i)',
        // 'j' is 0 and 'i' is 1 initially, making 'substring(0,1)' valid.

        //base cond
        if (s.length() == 0) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (search(s.substring(0, i)) && helperWordBreak(s.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();

        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }
        return helperWordBreak(s);
    
}
}
