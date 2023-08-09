public class Product {

    String name;
    double fats;
    double carbs;
    double proteins;

    public Product(String name; double fats; double carbs; double proteins){
        this.name = name;
        this.fats = fats;
        this.carbs = carbs;
        this.proteins = proteins;
    }

    public computeCalories(double fats; double carbs; double proteins){
       double calories = fats*9 + carbs*4 + proteins*4;
       return calories;

    }

}
