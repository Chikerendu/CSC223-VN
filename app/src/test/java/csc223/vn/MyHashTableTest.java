package csc223.vn;
public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();

        // Test putting values
        table.put("apple", 10);
        table.put("banana", 20);
        table.put("cherry", 30);
        System.out.println("Added apple, banana, cherry");

        // Test getting values
        System.out.println("Value for apple: " + table.get("apple")); // 10
        System.out.println("Value for banana: " + table.get("banana")); // 20
        System.out.println("Value for cherry: " + table.get("cherry")); // 30
        System.out.println("Value for orange (not added): " + table.get("orange")); // null

        // Test containsKey
        System.out.println("Contains apple? " + table.containsKey("apple")); // true
        System.out.println("Contains orange? " + table.containsKey("orange")); // false

        // Test updating value
        table.put("banana", 99);
        System.out.println("Updated banana value: " + table.get("banana")); // 99

        // Test remove
        table.remove("cherry");
        System.out.println("Removed cherry. Contains cherry? " + table.containsKey("cherry")); // false

        // Test size
        System.out.println("Current size of table: " + table.size()); // Should be 2
    }
}