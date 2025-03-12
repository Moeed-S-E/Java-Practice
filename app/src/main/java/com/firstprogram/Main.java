package com.firstprogram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = new Calc();
        System.out.print("Enter a Number: ");
        int input = scanner.nextInt();
        calc.seta(input);
        System.out.print("Enter a Number: ");
        input = scanner.nextInt();
        calc.setb(input);

        System.out.println(calc.geta()+"\n "+calc.getb());


        scanner.close();
    }
}
class Calc {
    private int a;
    private int b;
    //getter
    public int geta() {
        return a;
    }
    public int getb() {
        return b;
    }
    //setter
    public void seta(int A) {
        a=A;
    }
    public void setb(int B) {
        b=B;
    }
}