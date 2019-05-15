/*Задача на программирование повышенной сложности: наибольшая невозрастающая подпоследовательность

        Дано целое число 1≤n≤10^5и массив A[1…n], содержащий неотрицательные целые числа, не превосходящие 10^9.
        Найдите наибольшую невозрастающую подпоследовательность в A. В первой строке выведите её длину k, во второй—
        её индексы 1≤i1<i2<…<ik≤n (таким образом, A[i1]≥A[i2]≥…≥A[in]).*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinSubsequence {
    private int[] D;

    private int binSearch(int a, int maxj) {
        int l = 0;
        int r = maxj;
        int m = 0;
        while (l < r) {
            m = (l + r) >> 1;
            if (a <= D[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return m;
    }

    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] A = new int[n];
        String[] tokens = input.readLine().split(" ");
        int i;
        for (i = 0; i < n; i++) {
            A[i] = Integer.parseInt(tokens[i]);
        }
        D = new int[n];
        Arrays.fill(D, -1);
        D[0] = A[0];
        int j;
        int maxj = 1;
        int[] p = new int[n];
        Arrays.fill(p, -1);
        p[0] = 0;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        for (i = 1; i < n; i++) {
            j = binSearch(A[i], maxj);
            if (A[i] <= D[j]) {
                D[j + 1] = A[i];
                p[j + 1] = i;
                prev[i - 1] = p[j];
                if (j + 1 == maxj) {
                    maxj++;
                }
            } else {
                D[j] = A[i];
                p[j] = i;
                if (j > 0) {
                    prev[i - 1] = p[j - 1];
                }
            }
        }
        // восстанавливаем последовательность
        int[] ans = new int[maxj];
        ans[maxj - 1] = p[maxj - 1];
        i = maxj - 2;
        while (i >= 0) {
            ans[i] = prev[ans[i + 1] - 1];
            i--;
        }
        System.out.println(maxj);
        for (i = 0; i < maxj; i++) {
            System.out.print(ans[i] + 1 + " ");
        }
        input.close();
    }

    public static void main(String[] args) throws IOException {
        new MinSubsequence().run();
    }
}

