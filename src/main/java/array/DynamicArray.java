package array;

final class DynamicArray {

    int[] arr;
    int length;
    int count; // Write ptr

    DynamicArray(int length) {
        this.length = length;
        arr = new int[length];
        count = 0;
    }

    void insert(int n) {
        if (count == length) {
            int[] arr2 = new int[length * 2];
            for (int i = 0; i < length; i++) arr2[i] = arr[i];
            arr = arr2;
            length *= 2;
        }
        arr[count++] = n;
    }

    void removeAt(int index) {
        if (index > length) return;
        int[] arr2 = new int[length - 1];
        int idx = 0, idx2 = 0;
        while (idx2 < length - 1 && idx < length) {
            if (idx == index) {
                idx++;
                continue;
            }
            arr2[idx2++] = arr[idx++];
        }
        length -= 1;
        arr = arr2;
    }

    int getLength() {
        return length;
    }

    int indexOf(int n) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == n) return i;
        }
        return -1;
    }

    void print() {
        System.out.print("[ ");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + (i == length - 1 ? "" : ", "));
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(3);
        System.out.println("size: " + arr.getLength());
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.print();
        arr.insert(50);
        System.out.println("size: " + arr.getLength());
        arr.removeAt(2);
        arr.print();
        System.out.println(arr.indexOf(50));
        System.out.println(arr.indexOf(20));
    }

}
