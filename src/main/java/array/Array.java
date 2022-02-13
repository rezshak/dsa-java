package array;

public class Array {

    int[] arr;
    int size;
    int ptr = 0;

    Array(int size) {
        this.size = size;
        arr = new int[size];
    }

    void insert(int n) {
        if (ptr == size) {
            int[] arr2 = new int[size * 2];
            for (int i = 0; i < size; i++) arr2[i] = arr[i];
            arr = arr2;
            size *= 2;
        }
        arr[ptr++] = n;
    }

    void removeAt(int index) {
        if (index > size) return;
        int[] arr2 = new int[size - 1];
        int idx = 0, idx2 = 0;
        while (idx2 < size - 1 && idx < size) {
            if (idx == index) {
                idx++;
                continue;
            }
            arr2[idx2++] = arr[idx++];
        }
        size -= 1;
        arr = arr2;
    }

    int getSize() {
        return size;
    }

    int indexOf(int n) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == n) return i;
        }
        return -1;
    }

    void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print( arr[i] + (i == size - 1 ? "" : ", "));
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Array arr = new Array(3);
        System.out.println("size: " + arr.getSize());
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.print();
        arr.insert(50);
        System.out.println("size: " + arr.getSize());
        arr.removeAt(2);
        arr.print();
        System.out.println(arr.indexOf(50));
        System.out.println(arr.indexOf(20));
    }

}
