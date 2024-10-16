package mypack;

public class Rental {
    private Bike bike;
    private Customer customer;
    private int days;

     Rental(Bike bike,Customer customer,int days)
    {
        this.customer=customer;
        this.bike=bike;
        this.days=days;

    }
    public Bike getBike()
    {
        return bike;

    }
    public Customer getCustomer()
    {
        return customer;
    }
    public int getDays()
    {
        return days;
    }
}
