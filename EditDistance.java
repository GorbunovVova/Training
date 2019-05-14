/*Задача на программирование: расстояние редактирования.

        Вычислите расстояние редактирования двух данных непустых строк длины не более 102,
        содержащих строчные буквы латинского алфавита.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = input.readLine().toCharArray();
        char[] str2 = input.readLine().toCharArray();
        int n = str1.length;
        int m = str2.length;
        int[][] D = new int[n + 1][m + 1];
        int i, j;
        for (i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }
        int c;
        for (i = 1; i < n + 1; i++) {
            for (j = 1; j < m + 1; j++) {
                c = (str1[i - 1] == str2[j - 1]) ? 0 : 1;
                D[i][j] = Integer.min(Integer.min(D[i - 1][j], D[i][j - 1]) + 1, D[i - 1][j - 1] + c);
            }
        }
        System.out.println(D[n][m]);
        input.close();
    }

    public static void main(String[] args) throws IOException {
        new EditDistance().run();
    }
}
