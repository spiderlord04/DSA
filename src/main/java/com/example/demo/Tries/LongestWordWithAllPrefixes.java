package com.example.demo.Tries;
public class LongestWordWithAllPrefixes {
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
        // System.out.println("Inserted : " + word);
    }

    // Longest_Word
    public static void longestWord(Node node, StringBuilder ans, StringBuilder temp) {
        // this is an recursiv func
        // base
        if (node == null) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < 26; i++) { // for all letters in the arr
            // step 1 : check if the childern is not null and eow = true (i.e all pefixes
            // have eow = true)..then follow other stps
            // step 2: append the char to temp
            // step 3 : compare the length to the ans and temp , assign the temp if the
            // length of temp is larger..
            // step 4 : recursive call the function for the next levels..
            // step 5 : while backtrack remove the curr char from the temp..
            if (node.children[i] != null && node.children[i].endOfWord == true) {
                temp.append((char) (i + 'a'));
                if (ans.length() < temp.length()) {
                    ans.setLength(0); // clear ans
                    ans.append(temp.toString());
                }
                longestWord(node.children[i], ans, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        StringBuilder ans = new StringBuilder();
        longestWord(root, ans, new StringBuilder(""));
        System.out.println(ans);

    }
}
