import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6, 3, 7, 8, 4};

        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Сортируем последние пять элементов. Используем Math.max если длина массива меньше 5
        int startIndex = Math.max(0, array.length - 5);
        quickSortDescending(array, startIndex, array.length - 1);


        System.out.println("Массив после сортировки последних пяти элементов: " + Arrays.toString(array));
    }
//
    public static void quickSortDescending(int[] array, int low, int high) {
        if (low < high) {
            // Разделяем массив относительно опорного элемента
            int pi = partition(array, low, high);

            // Рекурсивно сортируем подмассивы слева и справа от опорного элемента
            quickSortDescending(array, low, pi - 1);
            quickSortDescending(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Выбираем последний элемент как опорный
        int i = (low - 1); // i - индекс элемента, меньшего чем опорный

        for (int j = low; j < high; j++) {
            // Если текущий элемент больше опорного (сортировка по убыванию!)
            if (array[j] > pivot) {
                i++;
                swap(array, i, j); // Меняем местами array[i] и array[j]
            }
        }

        // Ставим опорный элемент на свое место
        swap(array, i + 1, high);
        return i + 1; // Возвращаем индекс опорного элемента
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}