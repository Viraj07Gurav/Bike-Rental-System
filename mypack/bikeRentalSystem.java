package mypack;

import java.util.*;

public class bikeRentalSystem {
      private List<Bike> bikes; //create Bike type List 
    private List<Customer> customers; // create Customer type list
    private List<Rental> rentals;
    
    bikeRentalSystem()
    {
        bikes=new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();
    }
    public void addBike(Bike bike)
    {
        bikes.add(bike); //add operation on bikes
        
    }
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }

    public void rentBike(Bike bike,Customer customer,int days)
    {
        if(bike.getIsAvailable())
        {
            bike.rent();
            rentals.add(new Rental(bike,customer,days));
        }
        else
        {
            System.out.println("Bike is not available for rent.");
        }
    }

    public void returnBike(Bike bike)
    {
        bike.returnBike();
        Rental rentalToRemove=null;
        for(Rental rental:rentals)
        {
            if(rental.getBike()==bike)
            {
                rentalToRemove=rental;
                    break;           
            }

        }
        if(rentalToRemove!=null)
        {
            rentals.remove(rentalToRemove);
            System.out.println("bike return successfully.");

        }
        else{
            System.out.println("bike was not returned.");
        }
    }
    public void menu()
    {

        Scanner sc=new Scanner(System.in);
         
        while (true) 
        { 
            System.out.println("-----------------------------------------");
            System.out.println("|   *****Bike Retanl system******       |");
            System.out.println("-----------------------------------------");
            System.out.println("|        1. Rent a Bike.                |");
            System.out.println("-----------------------------------------");
            System.out.println("|        2. Return a Bike               |");
            System.out.println("-----------------------------------------");
            System.out.println("|        3.Exit                         |");
            System.out.println("-----------------------------------------");
            System.out.print("         Enter your Choice:> ");
            // System.out.println("-----------------------------------------");
            
            int choice=sc.nextInt();
            sc.nextLine();
            System.out.println("|---------------------------------------|\n\n");



            if(choice==1)
            {
                System.out.println("|======================================|");
                System.out.println("\n**Rent a Bike**");
                System.out.print("\nEnter your Name: ");
                String customerName=sc.nextLine();

                System.out.println("Available Bikes:");
                for(Bike bike:bikes)
                {
                    if(bike.getIsAvailable())
                    {
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println("  "+bike.getBikeId()+"  -  "+bike.getBrand()+"  -  "+bike.getModel());
                        System.out.println("|-------------------------------------------------------------|");
                    }
                }
                
                System.out.print("\n\nEnter the car ID you want to rent:");
                String bikeId=sc.nextLine();

                System.out.print("\nEnter the number of days for renatal:");
                int rentalDays=sc.nextInt();
                System.out.println("\n\n");
                sc.nextLine();
                

                Customer newCustomer= new Customer("CUS"+(customers.size()+1),customerName);

                addCustomer(newCustomer);

                Bike selectedBike=null;
                for(Bike bike:bikes)
                {
                    if(bike.getBikeId().equals(bikeId)&&bike.getIsAvailable())
                    {
                        selectedBike=bike;
                        break;
                    }
                }
                if(selectedBike!=null)
                {
                    double totalPrice=selectedBike.calculatePrice(rentalDays);
                    System.out.println("   ******Rental Informaation*******");
                    System.out.println("|-----------------------------------------|");
                    System.out.println("CustomerId:    "+newCustomer.getCustomerId());
                    System.out.println("|-----------------------------------------|");
                    System.out.println("Customer Name: "+newCustomer.getName());
                    System.out.println("|-----------------------------------------|");
                    System.out.println("Bike:         "+selectedBike.getBrand()+" "+selectedBike.getModel());
                    System.out.println("|-----------------------------------------|");
                    System.out.println("Rental Days:   "+rentalDays);
                    System.out.println("|-----------------------------------------|");
                    System.out.println("Total Price   $"+totalPrice);
                    System.out.println("|-----------------------------------------|");
                    System.out.print("Confrim rental (Y/N): ");
                    String confirm=sc.nextLine();
                    System.out.println("|-----------------------------------------|");
                    
                    if(confirm.equalsIgnoreCase("Y"))
                    {
                        rentBike(selectedBike, newCustomer, rentalDays);
                        System.out.println("\n rented successfully.\n");

                    }
                    else
                    {
                        System.out.println("\nCar rental cancele.\n");
                    }
                   
                }
                else {
                    System.out.println("Invalid Bike selection or Bike not available for rent\n");
                }
            }

            // option 2 else if
            else if(choice==2)
            {
                System.out.println("==Return a Bike====");

                System.out.println("Enter the Bike ID you want to return: ");
                String bikeId=sc.nextLine();

                Bike bikeToReturn=null;
                for(Bike bike:bikes)  //for each loop iterate for bikes arraylist 
                {
                    if(bike.getBikeId().equals(bikeId) && !bike.getIsAvailable()) //check any bike was rented or not
                    {
                        bikeToReturn=bike;      //!bike.getIsAvailable() it checks is bike available or not
                        break;
                    }
                }
                if(bikeToReturn !=null)   //store bike in bikeToReturn variable 
                {
                    Customer customer = null; //customer variable initally null
                    for(Rental rental:rentals) //for each loop
                    {
                        if(rental.getBike()==bikeToReturn) //check rented bike and bike which customer return same or not
                        {
                        customer=rental.getCustomer(); //get customer name from rental arrayList
                        break;
                        }
                    }
                    if (customer != null) {
                        returnBike(bikeToReturn);
                        System.out.println("Bike returned successfully by : " + customer.getName());
                        double totalPrice=selectedBike.calculatePrice(rentalDays);
                    }
                    else {
                        System.out.println("Bike was not rented or rental information is missing.");
                    }
                }
                else {
                    System.out.println("Invalid car ID or bike is not rented.");
                }

            }
            //option 3 exit
            else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    System.out.println("\nThank you for using the Bike Rental System!");

   

    }
}
   
    

