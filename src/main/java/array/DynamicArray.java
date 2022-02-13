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
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index invalid");
        }
        for (int i = index; i < count - 1; i++) arr[i] = arr[i + 1];
        count--;
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
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + (i == count - 1 ? "" : ", "));
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(4);
        System.out.println("Length: " + arr.getLength());
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.print();
        arr.insert(50);
        arr.insert(60);
        arr.print();
        System.out.println("Length: " + arr.getLength());
        arr.removeAt(2);
        arr.print();
        System.out.println(arr.indexOf(50));
        System.out.println(arr.indexOf(20));
    }

}
