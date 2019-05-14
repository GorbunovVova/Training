/*Задача на программирование повышенной сложности: огромное число Фибоначчи по модулю

        Даны целые числа 1≤n≤10*18 и 2≤m≤10*5, необходимо найти остаток от деления n-го числа Фибоначчи на m.*/

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int m = s.nextInt();
        int d0 = 0;
        int d1 = 1;
        int a = 0;
        int i = 2;
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        while (((a != 1) || (d0 != 0)) & (i <= n + 2)) {
            a = ((d0 + d1) % m);
            list.add(a);
            d0 = d1;
            d1 = a;
            i++;
        }
        int mod = (i <= n) ? list.get((int) (n % (i - 2))) : list.get((int) (n));
        System.out.println(mod);
    }
}

