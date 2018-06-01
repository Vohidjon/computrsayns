package sorting;

import queue.LinkedQueue;

public class BucketSort {
    /**
     * Stable - YES
     * Time - O(n)
     * @param array
     * @param maxKey
     */
    public static void sort(int[] array, int maxKey) {
        LinkedQueue[] queues = new LinkedQueue[maxKey + 1];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedQueue();
        }

        for (int i = 0; i < array.length; i++) {
            queues[array[i]].enqueue(array[i]);
        }

        int k = 0;
        for (int i = 0; i < queues.length; i++) {
            LinkedQueue queue = queues[i];
            while (!queue.isEmpty()) array[k++] = (int)queue.dequeue();
        }
    }
}
