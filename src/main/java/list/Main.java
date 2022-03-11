package list;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(90);
        list.addLast(10);
        list.addFirst(80);
        list.addLast(100);
        list.print();
        list.printMiddle();
        System.out.println(list.hasLoop());
    }

}
