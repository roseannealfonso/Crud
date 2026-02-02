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