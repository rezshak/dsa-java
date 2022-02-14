package array;

final class DynamicArray {

    int[] items;
    int count; // Write ptr

    DynamicArray(int length) {
        items = new int[length];
        count = 0;
    }

    void insert(int n) {
        items[count++] = n;
    }

    void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index invalid");
        }
        resizeIfRequired();
        for (int i = index; i < count; i++) items[i] = items[i + 1];
        count--;
    }

    int getLength() {
        return items.length;
    }

    int indexOf(int n) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == n) return i;
        }
        return -1;
    }

    void print() {
        System.out.print("[ ");
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + (i == count - 1 ? "" : ", "));
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(4);
        System.out.println("Length: " + arr.getLength());
        arr.insert(10);
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.removeAt(0);
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

    void resizeIfRequired() {
        if (count == items.length) {
            int[] items2 = new int[count * 2];
            for (int i = 0; i < count; i++) items2[i] = items[i];
            items = items2;
        }
    }

}
