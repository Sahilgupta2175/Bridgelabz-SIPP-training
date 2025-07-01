class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + " years");
    }
}

class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
}

class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }

    public void climb() {
        System.out.println(name + " is climbing the tree!");
    }
}

class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }

    public void fly() {
        System.out.println(name + " is flying high in the sky!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        System.out.println("=== Animal Hierarchy Demonstration ===\n");

        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        Animal[] animals = { dog, cat, bird };

        System.out.println("1. Polymorphic behavior with makeSound():");
        for (Animal animal : animals) {
            animal.displayInfo();
            animal.makeSound();
            System.out.println();
        }

        System.out.println("2. Unique behaviors for each animal:");

        if (dog instanceof Dog) {
            ((Dog) dog).fetch();
        }

        if (cat instanceof Cat) {
            ((Cat) cat).climb();
        }

        if (bird instanceof Bird) {
            ((Bird) bird).fly();
        }

        System.out.println("\n=== End of Animal Hierarchy Demo ===");
    }
}
