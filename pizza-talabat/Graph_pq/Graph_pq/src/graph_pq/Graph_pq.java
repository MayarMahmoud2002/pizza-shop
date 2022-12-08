package Graph_pq;

import graph_pq.customer;
import graph_pq.pizza;
import java.util.*;

class Graph_pq {

    static class ListNode {

        int vertex, weight;

        ListNode(int v, int w) {
            vertex = v;
            weight = w;
        }

        int getVertex() {
            return vertex;
        }

        int getWeight() {
            return weight;
        }
    }

    // Function to find the shortest distance of all the
    // vertices from the source vertex S.
    public static int[] dijkstra(int V, ArrayList<ArrayList<ListNode>> graph, int src) {
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new ListNode(src, 0));

        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            for (ListNode n : graph.get(current.getVertex())) {
                if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                    distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                    pq.add(new ListNode(n.getVertex(), distance[n.getVertex()]));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        try {

            Scanner inn = new Scanner(System.in);

            pizza p = new pizza();
            customer c = new customer();

            int V = 9;
            ArrayList<ArrayList<ListNode>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }
            System.out.println("welcome to our pizza shop" + "\n");

            System.out.println("please, choose your favourite pizza Toppings: " + "\n");

            p.printToppings();
            int x = p.charge();

            c.customerData();
            c.printLocations();
            System.out.println("please, enter your Nearst Delivery Location" + "\n");
            String loc = inn.nextLine();

            int source = 0;
            graph.get(0).add(new ListNode(1, 4));
            graph.get(0).add(new ListNode(7, 8));
            graph.get(1).add(new ListNode(2, 8));
            graph.get(1).add(new ListNode(7, 11));
            graph.get(1).add(new ListNode(0, 7));
            graph.get(2).add(new ListNode(1, 8));
            graph.get(2).add(new ListNode(3, 7));
            graph.get(2).add(new ListNode(8, 2));
            graph.get(2).add(new ListNode(5, 4));
            graph.get(3).add(new ListNode(2, 7));
            graph.get(3).add(new ListNode(4, 9));
            graph.get(3).add(new ListNode(5, 14));
            graph.get(4).add(new ListNode(3, 9));
            graph.get(4).add(new ListNode(5, 10));
            graph.get(5).add(new ListNode(4, 10));
            graph.get(5).add(new ListNode(6, 2));
            graph.get(6).add(new ListNode(5, 2));
            graph.get(6).add(new ListNode(7, 1));
            graph.get(6).add(new ListNode(8, 6));
            graph.get(7).add(new ListNode(0, 8));
            graph.get(7).add(new ListNode(1, 11));
            graph.get(7).add(new ListNode(6, 1));
            graph.get(7).add(new ListNode(8, 7));
            graph.get(8).add(new ListNode(2, 2));
            graph.get(8).add(new ListNode(6, 6));
            graph.get(8).add(new ListNode(7, 1));

            int[] distance = dijkstra(V, graph, source);
            // Printing the Output

//        for (int i = 0; i < V; i++) {
//            System.out.println(" \t\t " + "delivery time: " + distance[i] * 2 + " minutes");
//        }
            System.out.println("DO you want to confirm your order? 'yes' or 'No'");
            String conf = inn.nextLine();
            if (conf.equals("yes")) {
                for (int i = 0; i < 9; i++) {

                    if (loc.equals(c.array[i].getLocation())) {
                        int tot = x + distance[i];
                        System.out.println("delivery time: " + distance[i] * 2 + " minutes" + "\n"
                                + "delivery charge: " + distance[i] + "LE" + "\n"
                                + "total price: " + tot + "LE"
                        );
                    }
                }
            } else if (conf.equals("no")) {
                System.out.println("Thanks For your Time");
            }

        } catch (Exception e) {
            System.out.println(" Error  in line 128 ");
        }

    }
}

//        if (top.equals("cheese")) {
//            System.out.println("order charge: " + 55 + "LE");
//        }
//
//        if (top.equals("chicken")) {
//            System.out.println("order charge: " + 65 + "LE");
//        }
//
//        if (top.equals("vegetrians")) {
//            System.out.println("order charge: " + 50 + "LE");
//        }
//
//        if (top.equals("barbeque")) {
//            System.out.println("order charge: " + 70 + "LE");
//        }
//
//        if (top.equals("seafood")) {
//            System.out.println("order charge: " + 90 + "LE");
//        }
//
//            if (loc.equals("Nasr city")) {
//                System.out.println("delivery time: " + distance[0] * 2 + " minutes" + "\n"
//                        + "delivery price: " + distance[0] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[0] + "LE"
//                );
//
//            }
//
//            if (loc.equals("Al-shorouk")) {
//                System.out.println("delivery time: " + distance[1] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[1] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[1] + "LE"
//                );
//            }
//
//            if (loc.equals("Al-salam")) {
//                System.out.println("delivery time: " + distance[2] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[2] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[2] + "LE"
//                );
//            }
//
//            if (loc.equals("sakr")) {
//                System.out.println("delivery time: " + distance[3] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[3] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[3] + "LE");
//            }
//
//            if (loc.equals("mokatam")) {
//                System.out.println("delivery time: " + distance[4] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[4] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[4] + "LE");
//            }
//
//            if (loc.equals("maady")) {
//                System.out.println("delivery time: " + distance[5] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[5] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[5] + "LE");
//            }
//
//            if (loc.equals("Badr")) {
//                System.out.println("delivery time: " + distance[6] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[6] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[6] + "LE");
//            }
//
//            if (loc.equals("rahab")) {
//                System.out.println("delivery time: " + distance[7] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[7] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[7] + "LE");
//            }
//
//            if (loc.equals("tagamoa")) {
//                System.out.println("delivery time: " + distance[8] * 2 + " minutes" + "\n"
//                        + "delivery charge: " + distance[8] + "LE" + "\n"
//                        + "total price: " + p.charge() + distance[8] + "LE"
//                );
//            }
//        System.out.println("please, choose your favourite pizza Toppings: " + "\n"
//                + "cheese" + "\n"
//                + "chicken" + "\n"
//                + "barbeque" + "\n"
//                + "vegetrians" + "\n"
//                + "seafood" + "\n");
//        System.out.println("here is our accepted locations: " + "\n"
//                + " Nasr city" + "\n"
//                + " Al-shorouk" + "\n"
//                + " Al-salam" + "\n"
//                + " sakr" + "\n"
//                + " mokatam" + "\n"
//                + " maady" + "\n"
//                + " badr" + "\n"
//                + " rahab" + "\n"
//                + " tagamoa" + "\n");
