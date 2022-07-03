package ru.stqa.pft.sandbox;

public class getDistance {

    public static void main(String[] args) {
        Point p1 = new Point(3.0, 4.0);
        Point p2 = new Point(5.0, 3.0);

        System.out.println("Расстояние между точками"+p1.x+"/"+p1.y + " и "+ p2.x+"/"+p2.y +" равно:" +p1.distance(p2));
    }

}
