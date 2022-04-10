package queue;

final class Main {

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        System.out.println(aq);

        aq.enqueue(10);
        aq.enqueue(20);
        aq.enqueue(30);
        System.out.println(aq);

        System.out.println(aq.dequeue());

        System.out.println(aq);

        System.out.println(aq.dequeue());

        System.out.println(aq);
    }
}
