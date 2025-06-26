public class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Size limit reached.");
            return;
        }

        heap[size] = val;
        int current = size;
        size++;

        while (current > 0 && heap[current] > heap[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    public int peek() {
        if (size == 0) {
            System.err.println("Empty Heap");
            return -1;

        }
        return heap[0];
    }

    public int remove() {
        if (size == 0) {
            System.err.println("Heap Empty");
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxify(0);
        return max;
    }

    private void maxify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(largest, i);
            maxify(largest);
        }

    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MaxHeap h = new MaxHeap(10);
        h.insert(5);
        h.insert(2);
        h.insert(8);
        h.insert(1);

        h.printHeap(); // Should print a valid min-heap
        System.out.println(h.remove()); // 1
        h.printHeap();
    }

}
