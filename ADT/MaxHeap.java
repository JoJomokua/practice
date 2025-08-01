//heapADT
package ADT;
import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;
//setting the capacity of each heap
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
//insert fn
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
//get root fn
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return max;
    }
//heapify down
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }
//peek
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }
//print the heap
    public void display() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        //heap creation
        MaxHeap heap = new MaxHeap(10);
//adding elements
        heap.insert(40);
        heap.insert(20);
        heap.insert(30);
        heap.insert(10);
        heap.insert(50);
        //printing elements

        System.out.println("Heap elements:");
        heap.display();

        System.out.println("Maximum element: " + heap.peek());

        System.out.println("Extracted max: " + heap.extractMax());
        heap.display();

        System.out.println("Extracted max: " + heap.extractMax());
        heap.display();
  }

}
