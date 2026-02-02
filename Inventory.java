import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    static ArrayList<Product> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nINVENTORY");
            System.out.println("1 Add");
            System.out.println("2 View");
            System.out.println("3 Update");
            System.out.println("4 Archive");
            System.out.println("5 Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    archive();
                    break;
                case 5:
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    static void add() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Qty: ");
        int qty = sc.nextInt();
        sc.nextLine();

        list.add(new Product(id, name, price, qty));
        id++;

        System.out.println("Added");
    }

    static void view() {
        for (Product p : list) {
            if (!p.archived) {
                System.out.println(p.id + " " + p.name + " " + p.price + " " + p.qty);
            }
        }
    }

    static void update() {
        System.out.print("ID: ");
        int search = sc.nextInt();
        sc.nextLine();

        for (Product p : list) {
            if (p.id == search && !p.archived) {

                System.out.println("1 Name");
                System.out.println("2 Price");
                System.out.println("3 Qty");
                System.out.print("Choice: ");

                int ch = sc.nextInt();
                sc.nextLine();

                if (ch == 1) {
                    System.out.print("New name: ");
                    p.name = sc.nextLine();
                } else if (ch == 2) {
                    System.out.print("New price: ");
                    p.price = sc.nextDouble();
                } else if (ch == 3) {
                    System.out.print("New qty: ");
                    p.qty = sc.nextInt();
                }

                System.out.println("Updated");
                return;
            }
        }

        System.out.println("Not found");
    }

    static void archive() {
        System.out.print("ID: ");
        int search = sc.nextInt();
        sc.nextLine();

        for (Product p : list) {
            if (p.id == search) {
                p.archived = true;
                System.out.println("Archived");
                return;
            }
        }

        System.out.println("Not found");
    }
}

class Product {

    int id;
    String name;
    double price;
    int qty;
    boolean archived;

    Product(int i, String n, double p, int q) {
        id = i;
        name = n;
        price = p;
        qty = q;
        archived = false;
    }
}