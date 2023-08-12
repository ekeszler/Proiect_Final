public class ProductCatalog {

    Product[] products;
    final int maxNumberOfProducts = 100;
    int numberOfProducts;

    public ProductCatalog() {
        this.products = new Product[maxNumberOfProducts];
        this.numberOfProducts = 0;
    }

    public void printProducts() {
        for (int i = 0; i < maxNumberOfProducts; i++) {
            System.out.println(products[i].toString());
        }
    }

    public boolean addProduct(Product product) {
            if (getProductByName(product.name) != null || maxNumberOfProducts == numberOfProducts) {
                return false;
            } else {
                products[numberOfProducts] = product;
                numberOfProducts++;
                return true;

            }

    }

    public Product getProductByName(String name) {
        if (numberOfProducts == 0) {
            return null;
        }
        for (int i = 0; i < numberOfProducts; i++) {
            if (name.equals(products[i].name)) {
                return products[i];
            }
        }
        return null;
    }

    public int getProductIndexByName(String name) {
        if (numberOfProducts == 0) {
            return -1;
        }
        for (int i = 0; i < numberOfProducts; i++) {
            if (name.equals(products[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteProduct(String name) {
        int index = getProductIndexByName(name);
        if (index == -1) {
            return false;
        }

        for (int i = index; i < numberOfProducts - 1; i++) {
            products[i] = products[i + 1];
        }
        numberOfProducts--;
        products[numberOfProducts] = null;
        return true;
    }
}


