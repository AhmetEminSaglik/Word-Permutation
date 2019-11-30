
import java.util.PriorityQueue;
import java.util.Queue;

class Player implements Comparable<Player> { // player - player karşılaştırması (ikincisi comparable daki)

    private String isim;
    private int id;

    public Player(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }

    @Override
    public int compareTo(Player o) { // id küçük olan daha büyük önceliğe sahip olsun
        if (this.id < o.id) {
            return -1;
        } else if (this.id > o.id) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Player{" + "isim=" + isim + ", id=" + id + '}';
    }

}

public class Main {

    public static void main(String[] args) {
        /*
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(100);*/
 /*   System.out.println("Priorityqueue  de foreach-for dongusuyle yazdirirsak sirali gelmeyebilir");
        for (int q : queue) {

            System.out.println(q);
        }
        System.out.println("****************************");*/

 /* while (!queue.isEmpty()) {

            System.out.println("Eleman cikariliyor : " + queue.poll());
        }
         */
        Queue<Player> queue = new PriorityQueue<Player>();
        queue.offer(new Player("Ahmet Emin", 5));
        queue.offer(new Player("Mehmet ", 1));
        queue.offer(new Player("Ogus", 100));

        while (!queue.isEmpty()) {
            System.out.println("Eleman cikariliyor : " + queue.poll());
        }

    }

}
