
import java.util.LinkedList;
import java.util.Queue;

public class QueueveLinkedList {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();
        System.out.println("Queue is empty : " + queue.isEmpty());
        queue.offer("Java");
        queue.offer("Python");
        queue.offer("Php");
        queue.offer("C++");

        //System.out.println(queue.peek());
        for (String s : queue) {
            System.out.println(s);

        }
        System.out.println("Queue is empty : " + queue.isEmpty());
        System.out.println("********************************************");

        while (!queue.isEmpty()) {
            System.out.println("Eleman cikariliyor : " + queue.poll());
        }
        System.out.println("Eleman cikariliyor : " + queue.poll());
    }

}
