package hu.nye.w2.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Renderer renderer = new Renderer();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Adj meg egy nevet! ");
        String nev = keyboard.nextLine();
        System.out.println("Adja meg az országot! ");
        //Ha üresen szeretné hagyni, akkor írjon be bármilyen karaktert.
        String orszag = keyboard.nextLine();
        keyboard.close();
        System.out.println(renderer.render(generator.geni(orszag) + " " + nev + "!"));
    }
}