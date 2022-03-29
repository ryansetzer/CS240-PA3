
/**
 * Improved MergeSort class.
 */

public class MergeSortsImproved {

  /**
   * Merge sort the provided array using an improved merge operation.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort1(T[] items) {
    // Unfortunately, it is not possible to create an array of T's, this is the workaround.
    T[] temp = (T[]) new Comparable[items.length];
    mergeSort(items, temp, 0, items.length - 1);
  }

  /**
   * Recursive helper method for the merge sort algorithm.
   *
   * @param items The array to sort
   * @param temp  Temporary array for merge operation
   * @param left  Index of the left end of the region to sort
   * @param right Index of the right end of the region to sort.
   */
  private static <T extends Comparable<T>> void mergeSort(T[] items, T[] temp, int left, int right) {
    if (left >= right) {
      return; // Region has one record
    }

    int mid = (left + right) / 2; // Select midpoint
    mergeSort(items, temp, left, mid); // Mergesort first half
    mergeSort(items, temp, mid + 1, right); // Mergesort second half
    merge(items, temp, left, mid, right);

  }

  private static <T extends Comparable<T>> void merge(T[] items, T[] temp, int left, int mid, int right) {

    for (int i = left; i <= mid; i++) {
      temp[i] = items[i];// Copy sub-array to temp
    }

    int i1 = left;
    int i2 = mid + 1;

    for (int curr = left; curr <= right; curr++) {
      if (i1 == mid + 1) { // Left sub-array exhausted
        items[curr] = items[i2++];
      } else if (i2 > right) { // Right sub-array exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
    }
  }


  /**
   * Merge sort the provided array by using an improved merge operation and
   * switching to insertion sort for small sub-arrays.
   */
  public static <T extends Comparable<T>> void mergeSort2(T[] items) {
    mergeSort2(items, 0, items.length - 1);
  }

  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the
   * fallback method used by introspective sort.
   */
  public static <T extends Comparable<T>> void mergeSort2(T[] items, int start, int end) {

    // You will need to call the insertion sort method from BasicSorts.java:
    //   insertionSort(T[] items, int start, int end)


  }

  private static <T extends Comparable<T>> void merge2(T[] items, T[] temp, int left, int mid, int right) {

    for (int i = left; i <= mid; i++) {
      temp[i] = items[i];// Copy sub-array to temp
    }

    int i1 = left;
    int i2 = mid + 1;

    for (int curr = left; curr <= right; curr++) {
      if (i1 == mid + 1) { // Left sub-array exhausted
        items[curr] = items[i2++];
      } else if (i2 > right) { // Right sub-array exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
    }
  }

}
