import java.util.ArrayList;
import java.util.Scanner;

public class DelMonteInventory {

    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- DEL MONTE INVENTORY ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. View Products");
            System.out.println("4. Archive Product");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            String input = sc.nextLine();

            if (input.isEmpty()) {
                System.out.println("Please enter a choice.");
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    archiveProduct();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addProduct() {
        System.out.print("Product name: ");
        String pname = sc.nextLine();

        if (pname.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        try {
            System.out.print("Price: ");
            double price = Double.parseDouble(sc.nextLine());

            System.out.print("Quantity: ");
            int qty = Integer.parseInt(sc.nextLine());

            inventory.add(new Product(pname, price, qty));
            System.out.println("Product added.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
    }

    static void viewProducts() {
        System.out.println("\n--- PRODUCT LIST ---");
        boolean found = false;

        for (Product p : inventory) {
            if (!p.isArchived()) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found.");
        }
    }

    static void updateProduct() {
        System.out.print("Enter product ID: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            for (Product p : inventory) {
                if (p.getId() == id && !p.isArchived()) {

                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    System.out.println("3. Quantity");
                    System.out.print("Choose to update: ");

                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.print("New name: ");
                            p.setPname(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("New price: ");
                            p.setPrice(Double.parseDouble(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("New quantity: ");
                            p.setQty(Integer.parseInt(sc.nextLine()));
                            break;
                        default:
                            System.out.println("Invalid option.");
                            return;
                    }

                    System.out.println("Product updated.");
                    return;
                }
            }

            System.out.println("Product not found.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    static void archiveProduct() {
        System.out.print("Enter product ID to archive: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            for (Product p : inventory) {
                if (p.getId() == id) {
                    p.setArchived(true);
                    System.out.println("Product archived.");
                    return;
                }
            }

            System.out.println("Product not found.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }
}

/* ================= PRODUCT CLASS ================= */

class Product {

    private static int idCounter = 1;

    private int id;
    private String pname;
    private double price;
    private int qty;
    private boolean archived;

    public Product(String pname, double price, int qty) {
        this.id = idCounter++;
        this.pname = pname;
        this.price = price;
        this.qty = qty;
        this.archived = false;
    }

    public int getId() {
        return id;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + pname +
               " | Price: " + price +
               " | Qty: " + qty;
    }
}
