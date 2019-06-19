public class J1HomeWork5 {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Semenov Oleg", "23423423", 28);
        persons[1] = new Person("Efremov Igor", "45723456", 30);
        persons[2] = new Person("Menshov Anton", "34598235", 40);
        persons[3] = new Person("Harlamov Dmitry", "92456754", 50);
        persons[4] = new Person("Zadolbalov Pridymov", "7823704", 16);
        for (Person a : persons) {
            if (a.getAge() > 40)
                a.printPerson();
        }
    }
}

class Person {
    private String name;
    private String phone;
    private int age;

    Person(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void printPerson() {
        System.out.println("Name:" + name + ", " + "Phone:" + phone + ", " + "Age:" + age);
    }
}
