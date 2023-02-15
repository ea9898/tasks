package jm.two.ten;

public class Main {

    public static void main(String[] args) {
        merge(new int[]{0, 2, 2}, new int[]{1, 3});
    }

    public static void merge(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];

        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;

        while (aIndex < arrayA.length && bIndex < arrayB.length) { // Ни один из массивов не пуст
            if (arrayA[aIndex] < arrayB[bIndex]) {
                arrayC[cIndex++] = arrayA[aIndex++];
            } else {
                arrayC[cIndex++] = arrayB[bIndex++];
            }
        }

        while (aIndex < arrayA.length) {         // Массив arrayB пуст
            arrayC[cIndex++] = arrayA[aIndex++]; // в arrayA остались элементы
        }

        while (bIndex < arrayB.length) {         // масив arrayA пуст,
            arrayC[cIndex++] = arrayB[bIndex++]; // в arrayB остались элементы
        }

        for (int i = 0; i < arrayC.length; i++) {
            System.out.print(arrayC[i] + " ");
        }
    }

    // Метод merge()
    // содержит три цикла while. Первый цикл перебирает массивы arrayA и arrayB, сравнивает
    // элементы и копирует меньший из них в arrayC. Второй цикл используется в ситуации,
    // в которой из массива arrayB уже были извлечены все элементы, а в массиве arrayA
    // элементы все еще остаются. Цикл просто копирует оставшиеся элементы из arrayA
    // в arrayC. Третий цикл решает аналогичную задачу, когда все элементы были извлечены
    // из массива arrayA, а массив arrayB еще не пуст; оставшиеся элементы копируются в arrayC
}
