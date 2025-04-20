package 排序;

/**
 * @author 李华宪
 * @Description 冒泡排序
 * @create 2025-01-22 16:48
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 1, 9, 7, 4, 6};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 将前 arr.length - 1- i 中最大的放到 arr.length - 1 - i 位置
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
