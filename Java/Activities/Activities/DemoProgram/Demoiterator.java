package Activities.DemoProgram;

import java.util.*;


public class Demoiterator {
    public static void main(String[] args)
    {
        // Create an ArrayList
List<String> listStrings = new ArrayList<String>();
// Add values to it
listStrings.add("One");
listStrings.add("Two");
listStrings.add("Three");

//Create an Iterator
Iterator<String> iterator = listStrings.iterator();

// Use it to loop through the ArrayList
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
    }
}
