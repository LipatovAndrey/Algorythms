public class SiftDownSolution {
    public static int siftDown(int[] heap, int idx) {
        int left = 2 * idx;
        int right = 2 * idx + 1;
        if (heap.length < left) {
            return idx;
        }
        int indexLargest = 0;
        int elemIndex = idx;
        if (right <= heap.length && heap[left] < heap[right]) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }
        if (heap[idx] < heap[indexLargest]) {
            int old = heap[idx];
            heap[idx] = heap[indexLargest];
            heap[indexLargest] = old;
            elemIndex = siftDown(heap, indexLargest);
        }
        return elemIndex;
    }

    public static void main(String[] d) {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        System.out.println( siftDown(sample, 2));
    }
}

