
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker implements Runnable {

    private String isim;
    private int taskId;

    public Worker(String isim, int taskId) {
        this.isim = isim;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Worker " + isim + " " + taskId + " işe basladi..");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Worker " + isim + " " + taskId + " işi bitirdi..");
    }

}
