package queue;

final class Main {

    public static void main(String[] args) {

        ArrayQueue ad = new ArrayQueue();
        ad.enqueue(10);
        ad.enqueue(20);
        ad.enqueue(30);
        ad.enqueue(40);
        ad.enqueue(50);
        System.out.println(ad.dequeue());
        System.out.println(ad);
        System.out.println("count: " + ad.count);
        System.out.println("front: " + ad.front);
        System.out.println("rear: " + ad.rear);
        ad.enqueue(60);
        System.out.println(ad);


        StackQueue sq = new StackQueue();
        sq.enqueue(10);
        sq.enqueue(20);
        sq.enqueue(30);
        System.out.println(sq);
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
        System.out.println(sq);

        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(10);
        pq.enqueue(20);
        pq.enqueue(30);
        System.out.println(pq);
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq);

    }

}
