
import java.util.Arrays;

public class TrenMinimumPlatform {

    public static void main(String[] args) {
        double[] arrival_Trains = {2.00, 2.10, 3.00, 3.20, 3.50, 5.00};
        double[] departure_Trains = {2.30, 3.40, 3.20, 4.30, 4.00, 5.20};

        Arrays.sort(arrival_Trains);
        Arrays.sort(departure_Trains);

        System.out.println("Arrival Trains: ");
        for (int i = 0; i < arrival_Trains.length; i++) {
            System.out.print(arrival_Trains[i]);
            System.out.print("\t");
        }
        System.out.println("");

        System.out.println("Departure Trains : ");
        for (int i = 0; i < arrival_Trains.length; i++) {
            System.out.print(departure_Trains[i]);
            System.out.print("\t");
        }
        //i for arrival 
        //j for departure

        int platform = 0;
        int i = 0;
        int j = 0;
        while (i < arrival_Trains.length && j < departure_Trains.length) {

            //{2.00, 2.10, 3.00, 3.20, 3.50, 5.00};
            //{2.30, 3.40, 3.20, 4.30, 4.00, 5.20};
            if (arrival_Trains[i] < departure_Trains[j]) {

                platform++;
            } else if (arrival_Trains[i] > departure_Trains[j]) {
                platform--;
            }
            
            if ((i + 1) < arrival_Trains.length && i + 1 < departure_Trains.length && arrival_Trains[i + 1] < departure_Trains[j + 1]) {
                i++;
            } else if ((i + 1) < arrival_Trains.length && i + 1 < departure_Trains.length && arrival_Trains[i + 1] > departure_Trains[j + 1]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        System.out.println("");
        System.out.println("Minimum platform sayisi : " + platform);

    }

}
