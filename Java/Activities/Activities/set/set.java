package Activities.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class set {
    public static void main(String[] args)
    {
        List<Integer> listNumbers = Arrays.asList(3, 9, 1, 5, 3, 9, 1, 3, 8, 6);
System.out.println("List: " + listNumbers);
//[3, 9, 1, 5, 3, 9, 1, 3, 8, 6]

//Create Set from List
Set<Integer> uniqueNumbers = new HashSet<>(listNumbers);
System.out.println("Set: " + uniqueNumbers);
//[1, 3, 5, 6, 8, 9]
    }
}
