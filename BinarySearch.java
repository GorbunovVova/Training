/*Задача на программирование: двоичный поиск.
        В первой строке даны целое число 1≤n≤105 и массив A[1…n] из n различных натуральных чисел,
        не превышающих 109, в порядке возрастания, во второй — целое число 1≤k≤105 и k натуральных чисел b1,…,bk,
        не превышающих 109. Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n, для которого A[j]=bi,
        или −1, если такого j нет.*/

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i;
        int[] a = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] b = new int[k];
        for (i = 0; i < k; i++) {
            b[i] = scanner.nextInt();
        }
        int l, r, m;
        outer:
        for (i = 0; i < k; i++) {
            l = 0;
            r = n - 1;
            while (l <= r) {
                m = (r + l) / 2;
                if (a[m] == b[i]) {
                    System.out.print(m + 1 + " ");
                    continue outer;
                }
                if (a[m] > b[i]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            System.out.print("-1 ");
        }
    }
}
