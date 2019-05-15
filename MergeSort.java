/*Задача на программирование: число инверсий

        Первая строка содержит число 1≤n≤10^5, вторая — массив A[1…n], содержащий натуральные числа,
        не превосходящие 10^9. Необходимо посчитать число пар индексов 1≤i<j≤n, для которых A[i]>A[j].
        (Такая пара элементов называется инверсией массива. Количество инверсий в массиве является в
        некотором смысле его мерой неупорядоченности: например, в упорядоченном по неубыванию массиве
        инверсий нет вообще, а в массиве, упорядоченном по убыванию, инверсию образуют каждые два элемента.)*/

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public long inv = 0;

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int[] Asort = mergeSort(A);
        System.out.println(inv);
    }

    private int[] mergeSort(int[] A) {
        int r = A.length;
        int m = r / 2;
        if (m > 0) {
            int[] Asort = merge(mergeSort(Arrays.copyOfRange(A, 0, m)), mergeSort(Arrays.copyOfRange(A, m, r)));
            return Asort;
        }
        return A;
    }

    private int[] merge(int[] a1, int[] a2) {
        int i = 0;
        int n = 0;
        int m = 0;
        int[] c = new int[a1.length + a2.length];
        while (m < a1.length && n < a2.length) {
            if (a1[m] <= a2[n]) {
                c[i] = a1[m];
                m++;
                i++;
            } else {
                c[i] = a2[n];
                n++;
                i++;
                // считаем кол-во инверсий
                inv += a1.length - m;
            }
        }
        while (m < a1.length) {
            c[i] = a1[m];
            m++;
            i++;
        }
        while (n < a2.length) {
            c[i] = a2[n];
            n++;
            i++;
        }
        return c;
    }

    public static void main(String[] args) {
        new MergeSort().run();
    }
}