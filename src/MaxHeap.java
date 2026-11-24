public class MaxHeap {
    private Task[] heap;
    private int size;

    public MaxHeap() {
        heap = new Task[10];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Task task) {
        if (size == heap.length) {
            Task[] bigger = new Task[heap.length * 2];
            for (int i = 0; i < heap.length; i++) {
                bigger[i] = heap[i];
            }
            heap = bigger;
        }
        heap[size] = task;
        int i = size;
        size++;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[i].getPriority() > heap[parent].getPriority()) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    public Task peek() {
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }

    public Task extractMax() {
        if (isEmpty()) {
            return null;
        }
        Task max = heap[0];
        size--;
        heap[0] = heap[size];
        heap[size] = null;
        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if (left < size && heap[left].getPriority() > heap[largest].getPriority()) {
                largest = left;
            }
            if (right < size && heap[right].getPriority() > heap[largest].getPriority()) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            swap(i, largest);
            i = largest;
        }
        return max;
    }

    private void swap(int a, int b) {
        Task temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
