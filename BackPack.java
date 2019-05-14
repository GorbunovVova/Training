/*
Задача на программирование: рюкзак
        Первая строка входа содержит целые числа 1≤W≤104 и 1≤n≤300 — вместимость рюкзака и число золотых слитков.
        Следующая строка содержит n целых чисел 0≤w1,…,wn≤105, задающих веса слитков.
        Найдите максимальный вес золота, который можно унести в рюкзаке.
*/

import java.util.*;

class BackPack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int wbp = s.nextInt();
        int c, w, i, j;
        double unitCost;
        double costBackPack = 0;
        int[][] cw = new int[2][n];
        for (i = 0; i < n; i++) {
            cw[0][i] = s.nextInt();
            cw[1][i] = s.nextInt();
            // удельная стоимость следующего добавленного предмета
            unitCost = (double) cw[0][i] / cw[1][i];
            j = i - 1;
            // сразу встявляем наш эллемент на нужное место по удельной стоимости, чтоб потом не сортировать
            while (j >= 0 && unitCost > (double) cw[0][j] / cw[1][j]) {
                c = cw[0][j];
                w = cw[1][j];
                cw[0][j] = cw[0][j + 1];
                cw[1][j] = cw[1][j + 1];
                cw[0][j + 1] = c;
                cw[1][j + 1] = w;
                j--;
            }
        }
        // запихиваем в рюкзак самое дорогое
        i = 0;
        while (wbp > 0 && i < n) {
            if (cw[1][i] <= wbp) {
                costBackPack += cw[0][i];
                wbp -= cw[1][i];
            } else {
                costBackPack += (double) cw[0][i] / cw[1][i] * wbp;
                wbp = 0;
            }
            i++;
        }
        //выводим до 3-го знака после запятой
        System.out.printf("%.3f", costBackPack);
        s.close();
    }
}