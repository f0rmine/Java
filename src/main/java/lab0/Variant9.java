package lab0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Variant9 {
    // Завдання 1: integer
    // Дано тризначне число. Використовуючи одну операцію ділення націло, вивести першу цифру цього числа (сотні).
    public int integerTask(int number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException("Число має бути тризначним");
        }
        return number / 100;
    }

    // Завдання 2: boolean
    // Дано два цілих числа: A, B. Перевірити істинність висловлювання: «Хоча б одне з чисел A і B непарне».
    public boolean booleanTask(int a, int b) {
        return a % 2 != 0 || b % 2 != 0;
    }

    // Завдання 3: if
    // Дано дві змінні дійсного типу: A, B. Перерозподілити значення даних змінних так, щоб в A опинилося менше зі значень, а в B - більше. Вивести нові значення змінних A і B.
    public double[] ifTask(double a, double b) {
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        return new double[]{a, b};
    }
    // Завдання 4: case
    // Дано два цілих числа: D (день) і M (місяць), що визначають правильну дату невисокосного року. Вивести значення D і M для дати, наступної за вказаною.
    public int[] caseTask(int d, int m) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (d < 1  || m < 1 || m > 12 || d > daysInMonth[m - 1]) {
            throw new IllegalArgumentException("Некорректна дата");
        }

        d++;
        if (d > daysInMonth[m - 1]) {
            d = 1;
            m++;
        }
        if (m > 12) {
            m = 1;
        }
        return new int[]{d, m};
    }

    // Завдання 5: for
    // Дано два цілих числа A і B (A < B). Знайти суму квадратів усіх цілих чисел від A до B включно.
    public int forTask(int a, int b) {
        if (a >= b) {
            throw new IllegalArgumentException("A повинно бути менше B");
        }
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i * i;
        }
        return sum;
    }

    // Завдання 6: while
    // Дано ціле число N (> 1). Знайти найменше ціле число K, за якого виконується нерівність 3^K > N.
    public int whileTask(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("N повинно бути більше 1");
        }
        int k = 0;
        int power = 1;
        while (power < n) {
            k++;
            power *= 3;
        }
        return k;
    }



    public static void main(String[] args) {
        System.out.println("Variant9 виконаний успішно!");
    }
}
