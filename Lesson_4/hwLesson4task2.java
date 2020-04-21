package Lesson_4;

abstract class Animal {
    int runMax, swimMax;
    double  jumpMax;

    public Animal(){
    }

    abstract void swim(int x);

    void jump(int distance){
        System.out.println("jump: " + (distance <= jumpMax));
    }

    void run(int distance){
        System.out.println("run: " + (distance <= runMax));
    }

}

class Cat extends Animal{

    public Cat() {
        this.runMax = 200;
        this.jumpMax = 2;
        this.swimMax = 0;
    }

    @Override
    public void swim(int distance){
        System.out.println("Кот не хочет плавать");
    }
}

class Dog extends Animal{
    public Dog(int runMax) {
        super.runMax = runMax;
        this.jumpMax = 0.5;
        this.swimMax = 10;
    }

    @Override
    public void swim(int distance){
        System.out.println("swim: " + (distance <= swimMax));
    }
}

public class hwLesson4task2 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Dog dog1 = new Dog(400);
        Dog dog2 = new Dog(700);
        cat1.swim(10);
        cat1.jump(1);
        cat1.run(150);
        dog1.swim(10);
        dog1.jump(1);
        dog1.run(150);
        dog2.run(150);
    }
}
