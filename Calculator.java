/*Задача на программирование: калькулятор.

        У вас есть примитивный калькулятор, который умеет выполнять всего три операции с текущим числом x:
        заменить x на 2x, 3x или x+1. По данному целому числу 1≤n≤10^5 определите минимальное число операций k,
        необходимое, чтобы получить n из 1. Выведите k и последовательность промежуточных чисел.*/

import java.util.Scanner;

public class Calculator {
    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] x = new int[n + 1];
        x[1] = 0;
        for (int i = 2; i <= n; i++) {
            int k1 = Integer.MAX_VALUE;
            int k2 = Integer.MAX_VALUE;
            int k3;
            if (i % 3 == 0) {
                k1 = x[i / 3];
            }
            if (i % 2 == 0) {
                k2 = x[i / 2];
            }
            k3 = x[i - 1];
            x[i] = Integer.min(Integer.min(k1, k2), k3) + 1;
        }
        int k = x[n];
        System.out.println(k);
        // восстанавливаем ответ
        int[] ans = new int[k + 1];
        while (n > 0) {
            ans[k] = n;
            k--;
            if (n % 3 == 0 && x[n / 3] == k) {
                n /= 3;
                continue;
            } else if (n % 2 == 0 && x[n / 2] == k) {
                n /= 2;
                continue;
            }
            n--;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        new Calculator().run();
    }
}
