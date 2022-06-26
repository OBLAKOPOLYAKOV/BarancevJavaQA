package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("Petr");
        hello("Alex");
        hello("World");

        double len = 5;
        System.out.println("Площадь квадрата со сторонной" + len+ " = " + area(len));
        double a = 4;
        double b = 5;
        System.out.println("Площать прямоугольника со сторонами "+a + " и "+ b " = "+area(a,b));
    }

    public static void hello(String name){
        System.out.println("Hello, "+name + "!");
    }

    public static double area (double i){
        return i*i;
    }

    public static double area(double a, double b){
        return a*b;
    }
}

