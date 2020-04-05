import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
 нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока
 - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
 в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
  сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
 фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
  а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 1");
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"Cat", "Dog", "Parrot"} ;
        changePlace(arr1,4,1);
        changePlace(arr2,0,2);

        System.out.println("Задание 2");

        String[] arrayOfStrings = {"Кот", "Котишка", "Котяра", "Котэ"};
        asList(arrayOfStrings);

        System.out.println("Задание 2");
        //Создаём коробки
        Box<Orange> or1 = new Box<>();
        Box<Orange> or2 = new Box<>();
        Box<Apple> ap1 = new Box<>();
        Box<Apple> ap2 = new Box<>();
        //Закидываем фрукты в коробки:
        or1.addFruit(new Orange(),10);
        or2.addFruit(new Orange(),7);
        ap1.addFruit(new Apple(),15);
        ap2.addFruit(new Apple(),7);
        System.out.println("Вес коробок:");
        System.out.println("Коробка 1: "+or1.getWeight());
        System.out.println("Коробка 2: "+or2.getWeight());
        System.out.println("Коробка 3: "+ap1.getWeight());
        System.out.println("Коробка 4: "+ap2.getWeight());
        System.out.println("Сравниваем коробки:");
        System.out.println("Коробка 1 и коробка 3: "+or1.compare(ap1));
        System.out.println("Коробка 2 и коробка 4: "+or2.compare(ap2));
        System.out.println("Ссыпаем с двух коробок в одну:");
        or1.pourTo(or2);
        ap1.pourTo(ap2);
        System.out.println("Коробка 1: "+or1.getWeight());
        System.out.println("Коробка 2: "+or2.getWeight());
        System.out.println("Коробка 3: "+ap1.getWeight());
        System.out.println("Коробка 4: "+ap2.getWeight());
    }
    public static void changePlace(Object[] arr, int n1, int n2){
        System.out.println("Исходный массив: "+Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=sw;
        System.out.println("Перемена мест элементов: "+Arrays.toString(arr));
    }
    public static <T> void asList(T[]arr){
        ArrayList<T> arlist = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Преобразование в arraylist: "+arlist);
    }
}