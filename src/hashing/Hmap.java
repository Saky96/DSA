package hashing;

import java.util.Arrays;

//Internal Implementation of hash map
public class Hmap {
    static int intHashfunction(int key){
        int hash = key % 7;
        return hash;
    }

//    static Node<Integer, String> getKeyValue(int key, Node<Integer, String>[] hashtable){
//        int hash = intHashfunction(key);
//
//
//    }

    public static void main(String[] args) {
        int[] arrKeys = {24, 16, 12, 17, 18, 10, 9};
        Node[] hashTable = new Node[arrKeys.length];

        for (int i=0; i<arrKeys.length; i++) {
            int hash = intHashfunction(arrKeys[i]);
            Node<Integer, String> node = new Node<>(arrKeys[i], "random", hash, null);
            if(hashTable[hash] != null){
                if(hashTable[hash].next == null){
                    hashTable[hash].setNext(node);
                }
                else {
                    Node nextNode = hashTable[hash].next;
                    nextNode.setNext(node);
                }
            }
            else {
                hashTable[hash] = node;
            }
        }

        System.out.println(Arrays.toString(hashTable));
    }

}

class Node<K, V>{
    K key;
    V value;
    int hash;
    Node next;

    public Node(K key, V value, int hash, Node next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", hash=" + hash +
                ", next=" + next +
                '}';
    }
}
