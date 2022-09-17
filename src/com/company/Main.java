package com.company;
/**Створити програму, яка б для заданої основи системи числення p і числа N у цій системі

 отримувала б і виводила на екран число М - представлення числа N у системі числення з основою q.

 Вхідні дані: p,N,q (p,q ≤ 36).

 Вихідні дані: М.*/
public class Main {

    public static void main(String[] args) {
        Converting c = new Converting();
        c.getP();
        c.getN();
        c.getQ();
        c.toDecimal();
    }
}
