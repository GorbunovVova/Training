/*Задача на программирование: рюкзак

        Первая строка входа содержит целые числа 1≤W≤10^4 и 1≤n≤300 — вместимость рюкзака и число золотых слитков.
        Следующая строка содержит n целых чисел 0≤w1,…,wn≤10^5, задающих веса слитков. Найдите максимальный вес золота,
        который можно унести в рюкзаке.*/

import java.util.Scanner;

public class KnapSack {
    private void run() {
        Scanner input = new Scanner(System.in);
        int W = input.nextInt();
        int n = input.nextInt();
        int[] w = new int[n];
        int i, j;
        for (i = 0; i < n; i++) {
            w[i] = input.nextInt();
        }
        int[][] D = new int[n + 1][W + 1];
        for (i = 0; i < n + 1; i++) {
            D[i][0] = 0;
        }
        for (j = 0; j < W + 1; j++) {
            D[0][j] = 0;
        }
        for (i = 1; i < n + 1; i++) {
            for (j = 1; j < W + 1; j++) {
                D[i][j] = D[i - 1][j];
                if (w[i - 1] <= j) {
                    D[i][j] = Integer.max(D[i][j], D[i - 1][j - w[i - 1]] + w[i - 1]);
                }
            }
        }
        System.out.println(D[n][W]);
        input.close();
    }

    public static void main(String[] args) {
        new KnapSack().run();
    }
}