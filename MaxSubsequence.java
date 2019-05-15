/*Задача на программирование: наибольшая последовательнократная подпоследовательность
        Дано целое число 1≤n≤10^3 и массив A[1…n] натуральных чисел, не превосходящих 2⋅10^9.
        Выведите максимальное 1≤k≤n, для которого найдётся подпоследовательность 1≤i1<i2<…<ik≤n длины k,
        в которой каждый элемент делится на предыдущий (формально: для  всех 1≤j<k, A[ij]|A[ij+1]).*/

import java.util.Scanner;

public class MaxSubsequence {
    private void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = s.nextInt();
        }
        int[] D = new int[n];
        for (int i = 0; i < n; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i] && A[i] % A[j] == 0 && D[j] + 1 > D[i]) {
                    D[i] = D[j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (D[i] > ans) {
                ans = D[i];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new MaxSubsequence().run();
    }
}
