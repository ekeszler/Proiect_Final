public class Product {

    String name;
    double fats;
    double carbs;
    double proteins;
    double calories;

    public Product(String name, double fats, double carbs, double proteins){
        this.name = name;
        this.fats = fats;
        this.carbs = carbs;
        this.proteins = proteins;
        this.calories = computeCalories();
    }

    public computeCalories(double fats, double carbs, double proteins){
       return (fats*9) + (carbs*4) + (proteins*4);
    }

}
