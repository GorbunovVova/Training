/*
Задача на программирование: непрерывный рюкзак

Первая строка содержит количество предметов 1≤n≤10^3 и вместимость рюкзака 0≤W≤2⋅10^6. Каждая из следующих n строк задаёт
стоимость 0≤ci≤2⋅10^6 и объём 0<wi≤2⋅10^6 предмета (n, W, ci, wi — целые числа). Выведите максимальную стоимость частей
предметов (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся),
помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.*/

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
