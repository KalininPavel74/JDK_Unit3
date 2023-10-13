package org.example;

/**
 * Java Development Kit (семинары)
 * Урок 3. Обобщенное программирование
 * Калинин Павел. 13.10.2023
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("1.1. " + Calculator.sum(2, 3));
        System.out.println("1.1. " + Calculator.subtract(2, 3));
        System.out.println("1.1. " + Calculator.multiply(2, 3));
        System.out.println("1.1. " + Calculator.divide(2, 3));

        Main main = new Main();

        String[] ss1 = new String[]{"a", "b", "c"};
        String[] ss2 = new String[]{"a", "b", "c"};
        System.out.println("2.1. " + main.compareArrays(ss1, ss2));

        ss1 = new String[]{"a", "b", "c"};
        ss2 = new String[]{"a", "b"};
        System.out.println("2.2. " + main.compareArrays(ss1, ss2));

        ss1 = new String[]{"a", "b", "c"};
        ss2 = new String[]{"qqewqeqw", "dfdf", "123123"};
        System.out.println("2.3. " + main.compareArrays(ss1, ss2));

        Integer[] ii1 = new Integer[]{1, 2, 3};
        Integer[] ii2 = new Integer[]{1, 2, 3};
        System.out.println("2.4. " + main.compareArrays(ii1, ii2));

        System.out.println("3.1. " + main.build(1,2) );
        System.out.println("3.2. " + main.build("a","b") );

        System.out.println("Hello world!");
    }

    /**
     * 1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
     * sum(), multiply(), divide(), subtract().
     * Параметры этих методов – два числа разного типа (но необязательно разного между собой),
     * над которыми должна быть произведена операция.
     */
    private class Calculator {
        public static <N extends Number> double sum(N x, N y) {
            return x.doubleValue() + y.doubleValue();
        }

        public static <N extends Number> double subtract(N x, N y) {
            return x.doubleValue() - y.doubleValue();
        }

        public static <N extends Number> double multiply(N x, N y) {
            return x.doubleValue() * y.doubleValue();
        }

        public static <N extends Number> double divide(N x, N y) {
            return x.doubleValue() / y.doubleValue();
        }
    }

    /**
     * 2. Напишите обобщенный метод compareArrays(),
     * который принимает два массива и возвращает true, если они одинаковые, и false в противном случае.
     * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
     */
    private <T> boolean compareArrays(T[] ar1, T[] ar2) {
        if (ar1 == null && ar2 == null) return true;
        if (ar1.length != ar2.length) return false;
        for (int i = 0; i < ar1.length; i++)
            if (ar1[i] != ar2[i]) return false;
        return true;
    }

    /**
     * 3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
     * Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
     * а также переопределение метода toString(), возвращающее строковое представление пары.
     */

    private <T> Pair<T> build(T first, T second) { return new Pair<>(first, second); }
    private class Pair<T> {
        T first, second;
        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return null;
        }

        public T getSecond() {
            return null;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}