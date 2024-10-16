package mypack;
public class Customer {
    private String customerId;
    private String name;
    Customer(String customerId,String name)
    {
        this.customerId=customerId;
        this.name=name;

    }
    public String getCustomerId()
    {
        return customerId;
    }
    public String getName()
    {
        return name;
    }
}
