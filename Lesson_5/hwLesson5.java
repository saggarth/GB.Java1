/*
1.  Класс кота из прошлого ДЗ расширить функционалом потребления пищи. У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;
2.  Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней, а также методами наполнения и получения информации о количестве еды;
3.  Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски, уменьшая объём еды в ней;
4.  Предусмотрите проверку, при которой в миске не может получиться отрицательного количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);
5.  Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть (хватило еды), сытость = true;
    Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы);
6.  Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль;
7.  Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
*/

package Lesson_5;

abstract class Animal {
    int runMax, swimMax;
    double  jumpMax;

    public Animal(){
    }

    abstract void swim(int x);

    void jump(int distance){//умение прыгать
        System.out.println("jump: " + (distance <= jumpMax));
    }

    void run(int distance){//умение бегать
        System.out.println("run: " + (distance <= runMax));
    }

}

class Cat extends Animal{
    String  name;//имя кота
    int appetite;//аппетит кота
    boolean saturation;//сытость кота
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.saturation = false;
        this.runMax = 200;
        this.jumpMax = 2;
        this.swimMax = 0;
    }

    @Override
    public void swim(int distance){//умение плавать
        System.out.println("Кот не хочет плавать");
    }

    public void eat(Plate plate) {//еда из миски
        if (plate.getCurrentFoodValue() >= this.appetite) {
            plate.setCurrentFoodValue(this.appetite);
            this.saturation = true;
            System.out.println("Кот " + this.name + " поел и теперь пошел спать.");
            System.out.println("В миске осталось "+ plate.getCurrentFoodValue() + " еды из " + plate.getFoodVolume());
        } else {
            System.out.println("Еды в миске слишком мало для " + this.name + ".");
            plate.setCurrentFoodValue(plate.getFoodVolume());
            System.out.println("Миска наполнена.");
        }
    }
}

class Plate {//Кошачья миска
    private final int foodVolume;
    private int currentFoodValue;
    public Plate(int foodVolume){
        this.foodVolume = foodVolume;
        this.currentFoodValue = foodVolume;
    }

    public void setCurrentFoodValue(int value) {
        this.currentFoodValue -= value;
    }

    public int getCurrentFoodValue() {
        return currentFoodValue;
    }

    public int getFoodVolume() {
        return foodVolume;
    }
}

public class hwLesson5 {
    public static void main(String[] args) {
        Cat cat0 = new Cat("Мурзик", 15);
        Cat cat1 = new Cat("Барсик", 30);
        Cat cat2 = new Cat("Рыжик", 24);
        Cat cat3 = new Cat("Васька", 18);
        Cat cat4 = new Cat("Пушок", 16);
        Plate plate1 = new Plate(100);
        Cat[] catsArray = {cat0, cat1, cat2, cat3, cat4};
        for (Cat cat : catsArray) {
            cat.eat(plate1);
        }
    }
}