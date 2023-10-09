import java.util.*;

class mergesort {
  public static void print(int[] numbers) {
    for (int i : numbers) {
      System.out.print(i + " ");
    }
  }

  public static void mergeSort(int[] numbers) {


    int inputLength = numbers.length;
    if (inputLength < 2)
      return;
    int midIndex = inputLength / 2;
    int[] left = new int[midIndex];
    int[] right = new int[inputLength - midIndex];
    for (int i = 0; i < midIndex; i++) {
      left[i] = numbers[i];
    }
    for (int i = midIndex; i < inputLength; i++) {
      right[i - midIndex] = numbers[i];
    }
    mergeSort(left);
    mergeSort(right);
    merge(numbers, left, right);
  }

  public static void merge(int[] numbers, int[] left, int[] right) {
    int leftsize = left.length;
    int rightsize = right.length;
    int i = 0, j = 0, k = 0;
    while (i < leftsize && j < rightsize) {
      if (left[i] <= right[j]) {
        numbers[k] = left[i];
        i++;
      } else {
        numbers[k] = right[j];
        j++;

      }
      k++;
    }
    while (i < leftsize) {
      numbers[k] = left[i];
      i++;
      k++;
    }
    while (j < rightsize) {
      numbers[k] = right[j];
      j++;
      k++;
    }

  }

  public static void main(String[] args) {
    System.out.println("Mergesort");
    System.out.println("Enter the size of array");
    Scanner sc = new Scanner(System.in);
    int no = sc.nextInt();
    int[] numbers = new int[no];
    for (int i = 0; i < no; i++) {
      numbers[i] = sc.nextInt();
    }
    System.out.println("before merge sort");
    print(numbers);
    mergeSort(numbers);
    System.out.println("\nafter merge sort");
    print(numbers);
  }
}
