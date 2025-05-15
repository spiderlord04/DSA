package com.example.demo.Hashing;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl {
    static class HashMap<K, V> {
        private class Node {
            V val;
            K key;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            // now initilize all buckets with empyt ll
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // hashFucntion to find the buckeet index..
        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % N;
        }

        private int searchInLL(K key, int buckIdx) {
            LinkedList<Node> ll = buckets[buckIdx];
            int di = 0; // data index
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (key == node.key) { // if(key == node.key) use for obj comparison , Because == checks reference
                                       // equality and .equals() checks value equality.
                    return di;
                }
                di++;
            }
            return -1;

        }

        // rehash func
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            // increast the size of buckt
            buckets = new LinkedList[N * 2];
            N = N * 2;// update N val;
            // now make the new buakcet empty
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            // now re inset the elements into new bukcet
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();// we can also use get(i);
                    // now put
                    put(node.key, node.val);
                }
            }
        }

        // put function
        public void put(K key, V val) {
            // step 1 : to find the bucket index i.e where to inset the new node
            int buckIdx = hashFunction(key);
            // step 2 : to find the data index ... this tells if the node exists in ll or
            // not . if it is then update teh val if not thenn ins new node
            int dataIdx = searchInLL(key, buckIdx);
            // step 3 : put
            if (dataIdx != -1) {
                Node node = buckets[buckIdx].get(dataIdx);
                node.val = val;

            } else {
                Node node = new Node(key, val);
                buckets[buckIdx].add(node);
                n++;
            }
            double lambda = (double) n / N;
            // if the threshold is greater than requied then reshah
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int buckIdx = hashFunction(key);
            int dataIdx = searchInLL(key, buckIdx);
            if (dataIdx != -1) {
                return true;
            } else {
                return false;
            }
            // return key == buckets[buckIdx].get(dataIdx).key;
        }

        // GET
        public V get(K key) {
            int buckIdx = hashFunction(key);
            int dataIdx = searchInLL(key, buckIdx);
            if (dataIdx != -1) {
                return buckets[buckIdx].get(dataIdx).val;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int buckIdx = hashFunction(key);
            int dataIdx = searchInLL(key, buckIdx);
            if (dataIdx != -1) {
                n--;
                return buckets[buckIdx].remove(dataIdx).val;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    list.add(ll.get(j).key);
                }
            }
            return list;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("America", 130);
        map.put("Japan", 50);
        System.out.println(map.keySet());
        System.out.println("Keys: " + map.keySet());
        System.out.println("Value for India: " + map.get("India"));
        map.remove("Japan");
        System.out.println("After removing Japan: " + map.keySet());

    }
}