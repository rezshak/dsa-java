package main.java.dict;

public class Main {

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(101, "John");
        ht.put(101, "John 2");
        ht.put(203, "Mary");
        ht.put(303, "Bob");
        System.out.println(ht.get(303));
        ht.remove(303);
        ht.print();
    }

}
