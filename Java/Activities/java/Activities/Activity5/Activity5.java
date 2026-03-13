package Activities.Activity5;
abstract class Book {

    String title;

    abstract void setTitle(String booktitle);

    String getTitle() {
        return title;
    }
}

class MyBook extends Book {

    void setTitle(String booktitle) {
        title = booktitle;
    }
}

public class Activity5 {

    public static void main(String[] args) {

        MyBook newNovel = new MyBook();

        newNovel.setTitle("Java Programming");

        System.out.println("The title is: " + newNovel.getTitle());
    }
}