package ru.geekbrains.lessons.lesson4;

public class EmployeeData {

    public static void main(String[] args) {


      Employee[] EmployeeArr = {
        new Employee("Ivanov Ivan", "Engineer", "ii@mailbox.com", "8123456789", 30000, 30),
        new Employee("Petrov Petr", "Engineer", "pp@mailbox.com", "8987654321", 35000, 35),
        new Employee("Dmitriev Dmitriy", "Sales Manager", "dd@mailbox.com", "8741852963", 40000, 40),
        new Employee("Mikhailov Mikhail", "Chief Engineer", "mm@mailbox.com", "8369258147", 45000, 45),
        new Employee("Valeryev Valery", "Chief Executive", "vv@mailbox.com", "8147258369", 50000, 50)
      };

      olderThan40(EmployeeArr);

      for (Employee e : EmployeeArr) {
          if (e.getAge() >40) {
                  System.out.println(e.getInfo());
          }
      }

    }

    private static void olderThan40 (Employee [] arr) {
        for (int i = 0; i < arr.length ; i++) {
          if (arr[i].getAge() > 40){
              System.out.println(arr[i]);
          }
        }
    }
}
