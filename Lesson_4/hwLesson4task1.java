package Lesson_4;

class Person {
    String fullName, position, email, phone, salary;
    int age;
    Person(String fullName, String position, String email, String phone, String salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printPerson(){
        System.out.println(this.fullName + ", " + this.position);
    }
}

public class hwLesson4task1 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иван Иванов", "Инженер", "ivanov@mail.com", "88000000001", "30000", 32);
        persArray[1] = new Person("Петр Петров", "Технолог", "petrov@mail.com", "88000000002", "27000", 35);
        persArray[2] = new Person("Сидр Сидоров", "Рабочий", "sidorov@mail.com", "88000000003", "22000", 41);
        persArray[3] = new Person("Сергей Сергеев", "Мастер", "sergeev@mail.com", "88000000004", "28000", 52);
        persArray[4] = new Person("Антон Антонов", "Дворник", "antonov@mail.com", "88000000005", "15000", 58);

        System.out.println("Сотрудники старше 40 лет:");

        for (int i = 0; i < persArray.length; i++){
            if (persArray[i].age > 40){
                persArray[i].printPerson();
            }
        }
    }
}