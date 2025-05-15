
package com.example.demo.Tries;
public class StartsWithProb {

    //inner class
    class Trie {
        Trie children[] = new Trie[26];
        boolean endOfWord = false;
        Trie root;

        //constructor
        public Trie() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            //set root to current object
            root = this;
        }

        //inserting the word
        public void insert(String word) {
            Trie curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a'; // find the index
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Trie(); // create a new node if null
                }
                curr = curr.children[idx]; // move to next level
            }
            curr.endOfWord = true; // mark end of word
        }

        //search for word
        public boolean search(String word) {
            Trie curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a'; // find the index
                if (curr.children[idx] == null) {
                    return false; // if null, word not present
                }
                curr = curr.children[idx]; // move to next level
            }
            //the word has reached its end or not
            if (curr.endOfWord == true) {
                return true;
            }
            return false;
        }

        //check for prefix
        public boolean startsWith(String prefix) {
            Trie curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a'; // find the index
                if (curr.children[idx] == null) {
                    return false; // if null, prefix not present
                }
                //go to next level
                curr = curr.children[idx];
            }
            //the total prefix has been traversed in above loop 
            //and the prefix is present in trie (i.e no null val has been given)
            //so this true will exec
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    //main method
    public static void main(String[] args) {
        // creating outer class object
        StartsWithProb problem = new StartsWithProb();

        // creating inner class object using outer class object
        Trie trie = problem.new Trie();

        //inserting words into trie
        trie.insert("apple");
        trie.insert("app");

        //searching for words
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("appl"));    // false

        //checking for prefix
        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("apl")); // false
    }
}
