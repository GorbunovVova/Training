/*Задача на программирование: сортировка подсчётом

        Первая строка содержит число 1≤n≤104, вторая — n натуральных чисел, не превышающих 10.
        Выведите упорядоченную по неубыванию последовательность этих чисел.*/

import java.util.Scanner;

public class CountingSort {
    private void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] num = new int[11];
        int i;
        for (i = 0; i < n; i++) {
            a[i] = s.nextInt();
            num[a[i]]++;
        }
        for (i = 1; i < 11; i++) {
            num[i] = num[i] + num[i - 1];
        }
        int[] asorted = new int[n];
        for (i = n - 1; i >= 0; i--) {
            asorted[num[a[i]] - 1] = a[i];
            num[a[i]]--;
        }
        for (i = 0; i < n; i++) {
            System.out.print(asorted[i] + " ");
        }
    }

    public static void main(String[] args) {
        new CountingSort().run();
    }
}
