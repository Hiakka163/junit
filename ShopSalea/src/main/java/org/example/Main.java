package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        static Basket bsk = new Basket();

        public static void main(String[] args) {
            while (true) {
                try {
                    mainMenu();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static void mainMenu() throws NumberFormatException, IOException {
            System.out.printf("1. Добавить товар\n2. Удалить товар\n3. Вывести содержимое корзины\n4. Выйти из программы\n\n");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = in.readLine();

            if (input.equals("4"))
                System.exit(0);

            else if (input.equals("1")) {
                System.out.print("Название товара: ");
                String name = in.readLine();
                System.out.print("Количество: ");
                int amount = Integer.parseInt(in.readLine());
                if (!bsk.add(new Product(name, amount)))
                    System.out.println("Некорректно введены название или количество товара");
            } else if (input.equals("2")) {
                System.out.print("Название товара: ");
                String name = in.readLine();
                System.out.print("Количество: ");
                int amount = Integer.parseInt(in.readLine());
                if (!bsk.remove(new Product(name, amount)))
                    System.out.println("Неверно введены данные товара, либо товар отсутствует в корзине");
            } else if (input.equals("3")) {
                String out = bsk.toString();
                if (out.isBlank())
                    out = "\nКорзина пуста";
                System.out.printf("%s\n\n", out);
            } else
                System.out.println("Введите число от 1 до 4");
        }
    }