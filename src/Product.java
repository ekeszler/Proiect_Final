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
        this.calories = computeCalories(fats, carbs, proteins);
    }

    public static double computeCalories(double fats, double carbs, double proteins){
        return (fats*9) + (carbs*4) + (proteins*4);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", fats=" + fats +
                ", carbs=" + carbs +
                ", proteins=" + proteins +
                ", calories=" + calories +
                '}';
    }
}
