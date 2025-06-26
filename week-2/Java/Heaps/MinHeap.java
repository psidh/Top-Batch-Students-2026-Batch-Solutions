public class MinHeap {

    int heap[];
    int size;
    int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        this.size = 0;

    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Size full!");
            return;
        }

        heap[size] = val;
        int current = size;
        size++;
        while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    public int peek() {
        if (size == 0)
            throw new RuntimeException("Heap empty");
        return heap[0];
    }

    public int removeMin() {
        if (size == 0) {
            System.out.println("No elements in heap.");
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(10);
        h.insert(5);
        h.insert(2);
        h.insert(8);
        h.insert(1);

        h.printHeap(); // Should print a valid min-heap
        System.out.println(h.removeMin()); // 1
        h.printHeap();

    }
}