/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph_pq;

import java.util.Scanner;

/**
 *
 * @author zain
 */
public class customer {

    public Scanner data = new Scanner(System.in);

    public int phone;
    public String name;
    public String address;
    public String location;

    public customer arr[] = new customer[3];
    public customer array[] = new customer[9];

    public customer() {

        arr[0] = new customer(123, "saleh", "Nasr city");

        arr[1] = new customer(1234, "mayar", "maady");

        arr[2] = new customer(12345, "mario", "sakr");

        array[0] = new customer("Nasr city");
        array[1] = new customer("Al-shorouk");
        array[2] = new customer("Al-salam");
        array[3] = new customer("sakr");
        array[4] = new customer("mokatam");
        array[5] = new customer("maady");
        array[6] = new customer("badr");
        array[7] = new customer("rahab");
        array[8] = new customer("tagamoa");
//        arr[0].phone = 123;
//        arr[0].name = "saleh";
//        arr[0].address = "Nasr city";
//
//        arr[1].phone = 1234;
//        arr[1].name = "mayar";
//        arr[1].address = "maady";
//        arr[2].phone = 12345;
//        arr[2].name = "mario";
//        arr[2].address = "sakr";
//        array[0] = "Nasr city";
//        array[1] = "Al-shorouk";
//        array[2] = "Al-salam";
//        array[3] = "sakr";
//        array[4] = "mokatam";
//        array[5] = "maady";
//        array[6] = "badr";
//        array[7] = "rahab";
//        array[8] = "tagamoa";
    }

    public customer(int phone, String name, String address) {
        this.phone = phone;
        this.name = name;
        this.address = address;
    }

    public customer(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getphone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getaddrs() {
        return address;
    }

    public void customerData() throws Exception {
        System.out.println("enter your phone number please");
        Object t = data.nextInt();
        for (int i = 0; i < 3; i++) {
            if (t.equals(arr[i].getphone())) {
                System.out.println("here is your data: " + "\n"+"\n"
                        + "your phone: " + arr[i].getphone() + "\n"
                        + "your Name: " + arr[i].getName() + "\n"
                        + "your Adddress: " + arr[i].getaddrs() + "\n");
                break;
            }

            System.out.println("Do you want to change your address? 'yes' or 'No'" + "\n");
            String c = data.nextLine();
            if (c.equals("yes")) {
                arr[i].address = c;
                break;
            } else if (c.equals("no")) {
                System.out.println("please, enter your data for registraion" + "\n");

                arr[4].phone = (int) t;

                System.out.println("enter your name" + "\n");
                String r = data.nextLine();
                arr[4].name = r;

                System.out.println("enter your address" + "\n");
                String w = data.nextLine();
                arr[4].address = w;
            }
        }

    }

    public void printLocations() throws Exception {
        System.out.println("here is our accepted Delivery Locations" + "\n");
        for (int i = 0; i < 9; i++) {
            System.out.println(array[i].getLocation());
        }
    }

}
