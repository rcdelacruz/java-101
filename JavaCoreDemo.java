import java.io.*;
import java.util.*;

public class JavaCoreDemo {
    public static void main(String[] args) {
        // Demonstration of basic data types
        int[] numbers = {1, 2, 3, 4, 5};
        char aCharacter = 'A';
        boolean aBoolean = true;

        // Control structures
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }

        int count = 0;
        while (count < 5) {
            System.out.println("Count is: " + count);
            count++;
        }

        do {
            System.out.println("This is executed at least once");
        } while (false);

        if (aBoolean) {
            System.out.println("Boolean is true");
        } else {
            System.out.println("Boolean is false");
        }

        switch (aCharacter) {
            case 'A':
                System.out.println("A as in Alice");
                break;
            case 'B':
                System.out.println("B as in Bob");
                break;
            default:
                System.out.println("Some other character");
        }

        // Demonstration using double
        double circleRadius = 10;  // Example radius of a circle
        double circleArea = Math.PI * circleRadius * circleRadius;  // Area = πr²
        System.out.println("Area of the circle with radius " + circleRadius + " is " + circleArea);

        // Using Collections with Generics
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("Names List: " + names);

        // Using Set to ensure no duplicates
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Alice"); // This will not add "Alice" again
        System.out.println("Unique Names: " + uniqueNames);

        // Using Map to associate additional attributes
        Map<String, Integer> nameAges = new HashMap<>();
        nameAges.put("Alice", 25);
        nameAges.put("Bob", 30);
        nameAges.put("Charlie", 35);
        System.out.println("Names and Ages: " + nameAges);

        // Object-oriented demonstration with inheritance and encapsulation
        Animal cat = new Cat();
        Animal dog = new Dog();
        cat.makeSound();
        dog.makeSound();

        System.out.println("Original cat sound:");
        cat.makeSound();

        // Changing the cat's sound
        cat.setSound("Purr");
        System.out.println("Modified cat sound:");
        cat.makeSound();

        // Exception Handling
        try {
            processFile("input.txt");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }

        // Concurrency with Lambda expressions
        Runnable task = () -> {
            System.out.println("Running in a thread!");
        };
        new Thread(task).start();

        // Using interface and lambda for functional programming
        Greetable morningGreeting = (name) -> "Good morning, " + name + "!";
        System.out.println(morningGreeting.greet("Alice"));
    }

    // Demonstrates file I/O using try-with-resources and file checking
    static void processFile(String fileName) throws IOException {
        File file = new File(fileName);
        // Check if the file exists, create and write to it if it doesn't
        if (!file.exists()) {
            createSampleFile(file);
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    // Helper method to create a sample file
    static void createSampleFile(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Hello, this is a sample content for the input.txt file.");
            writer.newLine();
            writer.write("Add more lines as needed.");
        }
    }
}

// Basic object-oriented programming with abstract classes
abstract class Animal {
    private String sound; // Encapsulated field

    // Constructor to initialize the sound
    protected Animal(String sound) {
        this.sound = sound;
    }

    void makeSound() {
        System.out.println(getSound());
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}

class Cat extends Animal {
    Cat() {
        super("Meow"); // Initializing sound via constructor
    }
}

class Dog extends Animal {
    Dog() {
        super("Woof"); // Initializing sound via constructor
    }
}

// Demonstrating interface usage
interface Greetable {
    String greet(String name);
}
