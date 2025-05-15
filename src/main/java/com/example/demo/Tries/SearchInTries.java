package com.example.demo.Tries;
public class SearchInTries {
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
        System.out.println("Inserted : " + word);
    }

    // SEARCH METHOD

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        // at last we should check if the end is true or false
        // if ture then total word is present ..
        // if false then not prestn
        return curr.endOfWord == true;
    }

    public static void main(String[] args) {
        String words[] = { "the", "any", "thee", "there", "their", "three" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(search("the"));
        System.out.println(search("there"));
        System.out.println(search("thet"));
        System.out.println(search("thor"));
        System.out.println(search("me"));
        System.out.println(search("you"));
    }
}
