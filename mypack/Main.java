package mypack;

public class Main {
        public static void main(String[] args) {
           bikeRentalSystem rentalSystem = new bikeRentalSystem();
            Bike bike1 = new Bike("C001", "Honda", "Splender", 60.0); 
            Bike bike2 = new Bike("C002", "Hero", "Activa", 70.0);
            Bike bike3 = new Bike("C003", "TVS", "Jupiter", 150.0);
            rentalSystem.addBike(bike1);
            rentalSystem.addBike(bike2);
            rentalSystem.addBike(bike3);
    
            rentalSystem.menu();
        }
    
    
}
