/*Задача на программирование: очередь с приоритетами

        Первая строка входа содержит число операций 1≤n≤10^5. Каждая из последующих n строк задают операцию
        одного из следующих двух типов:

        Insert x, где 0≤x≤10^9 — целое число;
        ExtractMax.

        Первая операция добавляет число x в очередь с приоритетами, вторая —
        извлекает максимальное число и выводит его.*/

import java.util.Scanner;

class PriorityQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i, parent, temp, child1, child2;
        int j = 0;
        String s;
        int[] priorQueue = new int[n];
        for (i = 0; i < n; i++) {
            s = scanner.next();
            // если команда Insert, то добавляем элемент в конец очереди и просеиваем вверх
            if (s.equals("Insert")) {
                priorQueue[j] = scanner.nextInt();
                parent = (j - 1) / 2;
                child1 = j;
                while (parent >= 0 && priorQueue[child1] > priorQueue[parent]) {
                    temp = priorQueue[child1];
                    priorQueue[child1] = priorQueue[parent];
                    priorQueue[parent] = temp;
                    child1 = parent;
                    parent = (parent - 1) / 2;
                }
                j++;
                // если команда ExtractMax, то выводим 0-вой (максимальный) элемент очереди ,
                // ставим на его место последний элемент и просеиваем вниз
            } else {
                System.out.println(priorQueue[0]);
                // если очередь состоит не больше чем из одного элемента, то просеивать не нужно, просто удаляем его
                if (j <= 1) {
                    priorQueue[0] = 0;
                    j = 0;
                } else {
                    priorQueue[0] = priorQueue[j - 1];
                    priorQueue[j - 1] = 0;
                    parent = 0;
                    child1 = 1;
                    child2 = 2;
                    while (child1 <= j - 1) {
                        // если родитель итак больше детей , то выходим из цикла и не просеиваем
                        if (priorQueue[parent] >= priorQueue[child1] && priorQueue[parent] >= priorQueue[child2]) {
                            break;
                        } else {
                            if (priorQueue[child1] >= priorQueue[child2]) {
                                temp = priorQueue[child1];
                                priorQueue[child1] = priorQueue[parent];
                                priorQueue[parent] = temp;
                                parent = child1;
                            } else {
                                temp = priorQueue[child2];
                                priorQueue[child2] = priorQueue[parent];
                                priorQueue[parent] = temp;
                                parent = child2;
                            }
                            child1 = parent * 2 + 1;
                            child2 = parent * 2 + 2;
                        }
                    }
                    j--;
                }
            }
        }
    }
}
