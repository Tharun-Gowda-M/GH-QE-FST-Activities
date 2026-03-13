package Activities;

public class Activity1 {
    public static void main(String[] args)
 {
        Car Hyundai = new Car();
        Hyundai.color = "Black";
        Hyundai.make = 2014;
        Hyundai.transmission = "Manual";

        Hyundai.displayCharacterstics();
        Hyundai.accelerate();
        Hyundai.brake();
 }
}

