package graph_pq;

import java.util.Scanner;

public class pizza {

    public Scanner inn = new Scanner(System.in);

    public String toppings;
    public int charge = 0;
    public pizza arr[] = new pizza[5];

    public pizza() {

        arr[0] = new pizza("cheese", 55);
        arr[1] = new pizza("chicken", 65);
        arr[2] = new pizza("barbeque", 70);
        arr[3] = new pizza("vegetrians", 50);
        arr[4] = new pizza("seafood", 90);

    }

    public pizza(String toppings, int charge) {
        this.toppings = toppings;
        this.charge = charge;
    }

    public String gettopings() {
        return toppings;
    }

    public int getcharge() {
        return charge;
    }

    public void printToppings() {
        System.out.println("here is our menu" + "\n");
        for (int i = 0; i < 5; i++) {

            System.out.println(arr[i].gettopings());

        }
        
    }

    public int charge() {
        System.out.println("");
        String top = inn.nextLine();
        int x=0;
        for (int i = 0; i < 5; i++) {
            if (top.equals(arr[i].toppings)) {
                System.out.println("your order charge is: ");
                System.out.println(arr[i].getcharge() + "LE" + "\n");
                x = arr[i].getcharge();
            }

//             else {
//                System.out.println("sorry, this Toppings doesn't available");
//                break;
//            }
        }
        return x;
    }

}
