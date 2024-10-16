package mypack;

public class Bike
{
    private String bikeId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;
    
     Bike(String bikeId,String brand, String model, double basePricePerDay ) //,boolean isAvailable
        {
            this.bikeId=bikeId;
            this.brand=brand;
            this.model=model;
            this.basePricePerDay=basePricePerDay;
            this.isAvailable=true;
        }

    public String getBikeId()
    {
        return bikeId;
    }
    public void setBikeId(String bikeId)
    {
        this.bikeId=bikeId;
    }
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand=brand;
    }
// price set method
    public double calculatePrice(int rentalDay)
    {
        return basePricePerDay*rentalDay;
    }
    public void  setBasePricePerDay( double basePricePerDay)
    {
        this.basePricePerDay=basePricePerDay;
    }
    public boolean  getIsAvailable()
    {
        return isAvailable;
    }
   
    public void rent()
    {
        isAvailable=false;
    }
    public void returnBike()
    {
        isAvailable=true;
    }
    public String getModel()
    {
        return model;
    }
}