package Interview.other;
import java.util.List;

public class Solutionq {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Solutionq sol = new Solutionq();
        List<List<String>> countryPairs = new java.util.ArrayList<>();
        countryPairs.add(java.util.Arrays.asList("SL", "IND"));
        countryPairs.add(java.util.Arrays.asList("PAK", "USA"));
        countryPairs.add(java.util.Arrays.asList("IND", "JPN"));
        countryPairs.add(java.util.Arrays.asList("JPN", "PAK"));
        List<String> travelOrder = sol.getCountryTravelOrder(countryPairs);
        System.out.println(travelOrder);

    }

    /*  [[SL, IND] , [PAK, USA], [IND, JPN], [JPN, PAK]] From this list
      get the order to go from the starting country to the destination. 
      In this case SL, IND, JPN, PAK, USA is the order.
      create the function
        Input: List of country pairs
        Output: List of countries in travel order


    */
    public List<String>getCountryTravelOrder( List<List<String>> countryPairs) {
        java.util.Map<String, String> travelMap = new java.util.HashMap<>();
        java.util.Set<String> destinations = new java.util.HashSet<>();
        for (List<String> pair : countryPairs) {
            travelMap.put(pair.get(0), pair.get(1));
            destinations.add(pair.get(1));
        }
        String startCountry = null;
        for (String country : travelMap.keySet()) {
            if (!destinations.contains(country)) {
                startCountry = country;
                break;
            }
        }
        List<String> travelOrder = new java.util.ArrayList<>();
        while (startCountry != null) {
            travelOrder.add(startCountry);
            startCountry = travelMap.get(startCountry);
        }
        return travelOrder;
    }
}

/*
JAVA KNOWLEDGE BASE
*/
//Java Garbage Collection
/*
Java has an automatic garbage collection mechanism that helps manage memory by reclaiming memory occupied 
by objects that are no longer in use. The garbage collector runs in the background and identifies objects 
that are no longer reachable from any references in the program. Once identified, these objects are marked
for deletion, and their memory is freed up for future allocations. 

// how garbage collection works in java?
The garbage collection process in Java typically involves the following steps:
1. Marking: The garbage collector identifies all live objects that are still reachable from the roots (e.g., local variables, static fields).
2. Sweeping: The garbage collector traverses the heap and collects all unmarked objects, reclaiming their memory.
3. Compacting: In some garbage collection algorithms, the remaining live objects are compacted to reduce fragmentation and improve memory allocation efficiency.
*/

/*
// Question - Memory types in java context and the how those are used. (stack, heap and method area)

memory in Java is divided into several areas, each serving a specific purpose: 

1. Stack Memory: Stack memory is used for storing local variables and method call information.
                 Each thread in a Java program has its own stack, which grows and shrinks as methods are called and returned. 
                 Stack memory is managed automatically, and variables stored in the stack are deallocated when they go out of scope.

2. Heap Memory: Heap memory is used for dynamic memory allocation, where objects are created using the "new" keyword.
                The heap is shared among all threads in a Java program, and it is managed by the garbage collector.
                Objects stored in the heap remain in memory until they are no longer reachable and are collected by the garbage collector.

3. Method Area: The method area, also known as the "permanent generation" in older versions of Java, is used to store class-level data such
                as class definitions, static variables, and method bytecode.
                The method area is shared among all threads in a Java program and is also managed by the garbage collector.

4. Native Method Stack: The native method stack is used for executing native (non-Java) methods, typically written in languages like C or C++.
                        Each thread has its own native method stack, which is separate from the Java stack.

5. Program Counter (PC) Register: The PC register is a small memory area that keeps track of the current instruction being executed by each thread.
                                  Each thread has its own PC register.
                        These memory areas work together to manage the execution of Java programs efficiently, 
                        ensuring that memory is allocated and deallocated as needed while maintaining the integrity of the program's data.

/*
Context APIs: 
What are Context APIs? 
Context APIs are a set of programming interfaces that provide access to contextual information about the environment in which an application is running.
They allow developers to retrieve and manipulate data related to the application's state, user preferences, device settings, and other relevant information.
Context APIs are commonly used in mobile app development, web development, and other software applications to enhance user experience and provide personalized functionality.


Context APIs in Java ? with examples : In Java, Context APIs are often associated with frameworks and libraries that provide context-aware functionality. 
For example, in Android development, the Context class is a fundamental component that provides access to application-specific resources and services.
Here are some examples of how Context APIs are used in Java: 

2. Java EE Context API Example:
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class JNDIExample {  
    public void lookupDataSource() throws NamingException {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDataSource");
        // Use the DataSource to get a connection
    }
}


                                       

*/ 
// What are real world usage cases of Stack?
// Real-world usage cases of stack data structure include:
// 1. Function Call Management: Stacks are used to manage function calls and returns in programming languages.
// 2. Expression Evaluation: Stacks are used to evaluate mathematical expressions and convert infix expressions to postfix or prefix notation.
// 3. Undo/Redo Functionality: Stacks are used to implement undo and redo functionality in applications like text editors and graphic design software.
// 4. Syntax Parsing: Stacks are used in compilers and interpreters to parse programming languages and validate syntax.
// 5. Backtracking Algorithms: Stacks are used in backtracking algorithms to explore possible solutions, such as in maze solving or puzzle solving.
// 6. Browser History Management: Stacks are used to manage the history of visited web pages in web browsers.

//Implementation a queue using two stacks
class MyQueue {
    private java.util.Stack<Integer> stack1; // for enqueue operation
    private java.util.Stack<Integer> stack2; // for dequeue operation

    public MyQueue() {
        stack1 = new java.util.Stack<>(); 
        stack2 = new java.util.Stack<>(); 
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x); // Always push to stack1 
    }
    
    //
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}


/*
private -  accessible only within the same class.
protected - accessible within the same package and by subclasses.
public - accessible from any other class.
default (no modifier) - accessible only within the same package.

default and protected difference:
is that default access allows access only within the same package, 
while protected access allows access within the same package and also by subclasses, 
even if they are in different packages.

when we choose one over the other? Explain with examples.

private - use when you want to encapsulate data and prevent access from outside the class. eg:
class Example {
    private int data; // private variable

    private void displayData() { // private method
        System.out.println(data);
    }
}
protected - use when you want to allow access to subclasses or classes within the same package. eg:
class Parent {
    protected void showMessage() {
        System.out.println("Hello from Parent class");
    }
}
class Child extends Parent {
    public void display() {
        showMessage(); // Accessing protected method from Parent class
    }
}
public - use when you want to allow access from any other class. eg:
public class PublicExample {
    public int data; // public variable

    public void displayData() { // public method
        System.out.println(data);
    }
}
default - use when you want to restrict access to classes within the same package. eg:
class DefaultExample {
    int data; // default variable

    void displayData() { // default method
        System.out.println(data);
    }
}
*/

