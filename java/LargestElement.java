public class LargestElement {
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 30, 25};
        System.out.println("Largest element: " + findLargest(arr));
    }
}
