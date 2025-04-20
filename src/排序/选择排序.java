package 排序;

/**
 * @author 李华宪
 * @Description 每次从未排序的序列中找到最小的放到相应位置
 * @create 2025-01-22 17:01
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {12, 5, 9, 18, 3, 1, 10};
        selectSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
