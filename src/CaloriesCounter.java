import java.util.Scanner;

public class CaloriesCounter {
    public static void main(String[] args) {

        ProductCatalog productCatalog = new ProductCatalog();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            printMeniu();
            option = scanner.nextInt();
            performSelectedOption(option, productCatalog, scanner);
        } while (option != 6);

    }

    public static void printMeniu() {
        System.out.println("MENIU: ");
        System.out.println("1. Adauga produs in calculator si calculeaza-i caloriile");
        System.out.println("2. Calculeaza caloriile pentru un produs fara a fi adaugat in catalog");
        System.out.println("3. Afiseaza toate produsele din catalog si caloriile pentru fiecare");
        System.out.println("4. Sterge un produs din catalog");
        System.out.println("5. Gaseste produs dupa nume");
        System.out.println("6. EXIT ");
        System.out.println("-----------------------------------");
        System.out.println("Alege actiunea cu numarul:");

    }

    public static void performSelectedOption(int option, ProductCatalog productCatalog, Scanner scanner) {
        switch (option) {
            case 1:
                //citim de la tastatura detaliile produsului
                // ne instantiem un produs cu aceste detalii
                //pasam obiectul creat la  metoda addProduct
                addProduct(productCatalog, scanner);
                break;
            case 2:
                computeCalories(scanner);
                break;
            case 3:
                productCatalog.printProducts();
                break;
            case 4:
                deleteProduct(productCatalog, scanner);
                break;
            case 5:
                searchProduct(productCatalog, scanner);
                break;
            case 6:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Optiunea este invalida, reintroduceti optiunea");
        }
    }

    private static void searchProduct(ProductCatalog productCatalog, Scanner scanner) {
        System.out.println("Ce produs cauti?");
        String name = scanner.next();
        Product product = productCatalog.getProductByName(name);
        if (product == null){
            System.out.println("produsul cu numele nu a fost gasit");
        }
        else {
            System.out.println(product);
        }
    }

    private static void deleteProduct(ProductCatalog productCatalog, Scanner scanner) {
        System.out.println("Nume: ");
        String name = scanner.next();
        boolean deleteResult = productCatalog.deleteProduct(name);
        if (deleteResult) {
            System.out.println("Produsul " + name + " +s-a sters");
        } else {
            System.out.println("Produsul " + name + " + nu s-a sters");
        }
        productCatalog.deleteProduct(name);
    }

    private static void computeCalories(Scanner scanner) {
        System.out.println("Grasimi:");
        double fats = scanner.nextDouble();
        System.out.println("Carbohidrati:");
        double carbs = scanner.nextDouble();
        System.out.println("Proteine:");
        double proteins = scanner.nextDouble();
        System.out.println(Product.computeCalories(fats, carbs, proteins));
    }
    private static void addProduct(ProductCatalog productCatalog, Scanner scanner) {
        String name = scanner.next();
        double fats = scanner.nextDouble();
        double carbs = scanner.nextDouble();
        double proteins = scanner.nextDouble();
        Product newProduct = new Product(name, fats, carbs, proteins);
        boolean result = productCatalog.addProduct(newProduct);
        if (result) {
            System.out.println("Produsul " + newProduct.name + " s-a adaugat");
        } else {
            System.out.println("Produsul " + newProduct.name + " + nu s-a adaugat");
        }
        productCatalog.printProducts();
    }

}