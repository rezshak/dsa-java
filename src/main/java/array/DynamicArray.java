package array;

final class DynamicArray {

    int[] items;
    int size;

    DynamicArray(int length) {
        items = new int[length];
        size = 0;
    }

    void insert(int item) {
        items[size++] = item;
    }

    void removeAt(int index) {
        validateIndex(index);
        resizeIfRequired();
        for (int i = index; i < size; i++) items[i] = items[i + 1];
        size--;
    }

    int size() { return size; }

    int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i] == item) return i;
        }
        return -1;
    }

    void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + (i == size - 1 ? "" : ", "));
        }
        System.out.println(" ]");
    }

    int max() {
        int max = items[0];
        for (int i = 1; i < size; i++) {
            if (items[i] > max) max = items[i];
        }
        return max;
    }

    int get(int index) {
        validateIndex(index);
        return items[index];
    }

    DynamicArray intersect(DynamicArray other) {
        int size = this.size < other.size() ? this.size : other.size();
        DynamicArray intersect = new DynamicArray(size);
        for (int item : items) {
            if (other.indexOf(item) > 0) intersect.insert(item);
        }
        return intersect;
    }

    void reverse() {
        int left = 0, right = size - 1;
        while (left <= right) {
            swap(items, left++, right--);
        }
    }

    void insertAt(int index, int item) {
        validateIndex(index);
        resizeIfRequired();
        for (int i = size + 1; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        size++;
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(4);
        arr.insert(10);
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.removeAt(0);
        arr.print();
        arr.insert(50);
        arr.insert(60);
        arr.print();
        arr.removeAt(2);
        arr.print();
        System.out.println("indexOf(50): " + arr.indexOf(50));
        System.out.println("indexOf(20): " + arr.indexOf(20));
        System.out.println("max: " + arr.max());
        DynamicArray arr2 = new DynamicArray(2);
        arr2.insert(70);
        arr2.insert(30);
        arr.intersect(arr2).print();
        arr.print();
        arr.reverse();
        arr.print();
        arr.insertAt(0, 11);
        arr.print();
    }

    void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index invalid");
        }
    }

    void resizeIfRequired() {
        if (size == items.length) {
            int[] items2 = new int[size * 2];
            for (int i = 0; i < size; i++) items2[i] = items[i];
            items = items2;
        }
    }

    void swap(int[] items, int i, int j) {
        if (i == j) return;
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

}
