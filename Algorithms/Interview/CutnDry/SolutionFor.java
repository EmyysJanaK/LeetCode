package Algorithms.Interview.CutnDry;

public class SolutionFor {

    public static void main(String[] args) {
        SolutionFor solutionSwap = new SolutionFor();
        int[] nums = {5, 10};
        solutionSwap.swap(nums, 0, 1);
        System.out.println("After swap: nums[0] = " + nums[0] + ", nums[1] = " + nums[1]);
    }
    // Swap 2 variables in place without using additional memory
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    //Group anaragrams together from a given list of strings. - algorithm type is sliding window
    public java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, java.util.List<String>> map = new java.util.HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray(); // Convert string to char array
            java.util.Arrays.sort(charArray); // Sort the char array
            String key = new String(charArray); // Convert sorted char array back to string
            map.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(str); // Add original string to the corresponding list in the map
        }
        return new java.util.ArrayList<>(map.values()); // Return the list of anagram groups
    }
 // is above function using sliding window approach? No, the above function does not use the sliding window approach. It uses sorting and hashing to group anagrams together.
// we we use hashmap to store the sorted version of each string as the key and the list of anagrams as the value.

    //Matching substring in a given string
    public java.util.List<String> findMatchingSubstrings(String[] words, String prefix) {
        java.util.List<String> result = new java.util.ArrayList<>();
        for (String word : words) {
            if (word.startsWith(prefix)) {
                result.add(word);
            }
        }
        return result;
    }

    //find the indices of the two numbers of a given array that add up to a specific target
    // eg: Input: nums = [2,7,11,15], target = 9 Output: [0,1] what is the algorithm type for this problem? Two Sum problem can be solved using a HashMap to achieve O(n) time complexity.
    public int[] twoSum(int[] nums, int target) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>(); // eg {2:0, 7:1, 11:2, 15:3}
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {// check if complement exists in the map
                return new int[]{map.get(complement), i};// return indices of the two numbers
            }
            map.put(nums[i], i); // Store the number and its index in the map
        }
        return new int[]{-1, -1}; // Return -1, -1 if no solution is found
    }

    //why method overriding is used in java?
    // Method overriding is used in Java to achieve runtime polymorphism, allowing a subclass to provide 
    // a specific implementation of a method that is already defined in its superclass. This enables dynamic
    // method resolution, where the appropriate method is called based on the object's actual type at runtime,
    // rather than the reference type. It enhances code flexibility, maintainability, and allows for more specialized behavior in subclasses.
    // Example:
    class Animal {
        void sound() {
            System.out.println("Animal makes a sound");
        }
    }
    class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks");
        }
    }
    public void demonstrateOverriding() {
        Animal myAnimal = new Dog();
        myAnimal.sound(); // Output: Dog barks
    } 
    // why this is called runtime polymorphism because the method to be called is determined 
    // at runtime based on the actual object type (Dog) rather than the reference type (Animal).


}

//Method overloading is used in java?
// Method overloading is used in Java to enhance code readability and usability by allowing multiple methods
// with the same name to coexist in the same class, as long as they have different parameter lists (different types, number, or both).
// This allows developers to use the same method name for similar operations, making the code more intuitive and easier to understand.
// Example:
class MathOperations {
    // Overloaded method for adding two integers
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method for adding three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method for adding two double values
    double add(double a, double b) {
        return a + b;
    }
}
//why called compile-time polymorphism because the method to be called is determined
// at compile-time based on the method signature (parameter types and number).

//singleton design pattern in java?
// The Singleton design pattern in Java is a creational design pattern that ensures a class has only
// one instance and provides a global point of access to that instance. This is useful when exactly one
// object is needed to coordinate actions across the system, such as in logging, configuration management,

class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation from other classes
    private Singleton() {
    }

    // Public method to provide access to the single instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
//observer design pattern in java?
// The Observer design pattern in Java is a behavioral design pattern that establishes a one-to-many
// dependency between objects, allowing multiple observer objects to be notified and updated automatically
// when the state of a subject object changes. This pattern is useful for implementing event-driven systems
// where changes in one object need to be communicated to multiple dependent objects without tight coupling.
// Example:
class Subject {
    private java.util.List<Observer> observers = new java.util.ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// explain how garbage collection works in java?
// Garbage collection in Java is an automatic memory management process that identifies and
// reclaims memory occupied by objects that are no longer reachable or needed by the program.
// The Java Virtual Machine (JVM) uses a garbage collector to periodically scan the heap memory
// for objects that are no longer referenced by any part of the program. When such objects are found,
// the garbage collector frees up the memory they occupy, making it available for new object allocations.
// Java primarily uses two garbage collection algorithms: Mark-and-Sweep and Generational Garbage Collection.
// In the Mark-and-Sweep algorithm, the garbage collector marks all reachable objects starting from
// root references and then sweeps through the heap to collect unmarked objects. Generational Garbage 
// Collection divides objects into generations based on their age, allowing for more efficient collection
// of short-lived objects while minimizing the impact on long-lived objects. Overall, garbage collection