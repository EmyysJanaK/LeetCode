package Interview.SysLab;

import java.util.Stack;

// Explain all the concepts about Object oriented programming in Java

// Explain all the concepts about Object oriented programming in Java



public class DoubleOp {
    
    

}

/*
what kind of data structure do you use when you are given an
array [gas, gasoline, car, crowd, crowded, crown] and if you search for 
crow you should output crowd, crowded and crown if you search c you 
should output car, crowd, crowded
*/
//solution data structure is trie
class TrieNode {
    java.util.Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new java.util.HashMap<>();
        isEndOfWord = false;
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public java.util.List<String> searchByPrefix(String prefix) {
        java.util.List<String> results = new java.util.ArrayList<>();
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return results; // No words found with the given prefix
            }
            current = current.children.get(ch);
        }
        findAllWordsFromNode(current, new StringBuilder(prefix), results);
        return results;
    }

    private void findAllWordsFromNode(TrieNode node, StringBuilder prefix, java.util.List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix.toString());
        }
        for (char ch : node.children.keySet()) {
            prefix.append(ch);
            findAllWordsFromNode(node.children.get(ch), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1); // Backtrack
        }
    }
}
// Example usage:
// Trie trie = new Trie();
// trie.insert("gas");
// trie.insert("gasoline");
// trie.insert("car");
// trie.insert("crowd");
// trie.insert("crowded");
// trie.insert("crown");
// java.util.List<String> results = trie.searchByPrefix("crow");
// System.out.println(results); // Output: [crowd, crowded, crown]

//build a queue using stack
class MyQueue {
    private java.util.Stack<Integer> stack1 = new Stack<>();
    private java.util.Stack<Integer> stack2 = new Stack<>();

    // Push element x to the back of queue
    public void enqueue(int x) {
        stack1.push(x);
    }
    // Remove the element from in front of queue and return that element
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    // Get the front element
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    // Return whether the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}