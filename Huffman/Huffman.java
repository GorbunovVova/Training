/*Задача на программирование: кодирование Хаффмана

        По данной непустой строке s длины не более 104, состоящей из строчных букв латинского алфавита,
        постройте оптимальный беспрефиксный код. В первой строке выведите количество различных букв k,
        встречающихся в строке, и размер получившейся закодированной строки. В следующих k строках запишите
        коды букв в формате "letter: code". В последней строке выведите закодированную строку.*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Huffman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int ch, i, k;
        int codeSize = 0;
        int[] count = new int[26];
        List<Node> queue = new ArrayList<>();
        // считаем частоту употребления каждого символа в строке, записываем в массив.
        for (i = 0; i < n; i++) {
            ch = s.codePointAt(i);
            count[ch - 97]++;
        }
        k = 0;
        //считаем кол-во различных символов в строке, записываем вершины в список
        for (i = 0; i < 26; i++) {
            if (count[i] > 0) {
                queue.add(new Node(i, count[i]));
                k++;
            }
        }
        //создаем компаратор , сортирующий список вершин по частоте
        Comparator<Node> comparator = Comparator.comparing(node -> node.frequency);
        // строим дерево, перед добавлением каждой вершины сортируем
        for (i = 0; i < (2 * k - 2); i += 2) {
            queue.sort(comparator);
            codeSize += queue.get(i).frequency + queue.get(i + 1).frequency;
            queue.add(new Node(queue.get(i), queue.get(i + 1)));
        }
        if (k == 1) {
            codeSize = queue.get(0).frequency;
        }
        // выводим кол-во различных символов и длину закодированной строки
        System.out.println(k + " " + codeSize);
        // выводим код каждого символа
        Node top = queue.get(queue.size() - 1);
        String code;
        for (Integer letter : top.letters) {
            Node cursor = top;
            code = "";
            while (cursor.isLeaf() == false) {
                if (cursor.leftLeaf.letters.contains(letter)) {
                    code += "0";
                    cursor = cursor.leftLeaf;
                } else {
                    code += "1";
                    cursor = cursor.rightLeaf;
                }
            }
            if (k == 1) {
                code = "0";
            }
            System.out.println((char) (letter + 97) + ": " + code);
        }
        // выводим закодированную строку
        for (i = 0; i < n; i++) {
            ch = s.codePointAt(i);
            Node cursor = top;
            code = "";
            while (cursor.isLeaf() == false) {
                if (cursor.leftLeaf.letters.contains(ch - 97)) {
                    code += "0";
                    cursor = cursor.leftLeaf;
                } else {
                    code += "1";
                    cursor = cursor.rightLeaf;
                }
            }
            if (k == 1) {
                code = "0";
            }
            System.out.print(code);
        }
    }
}