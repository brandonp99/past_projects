package ai_tsp;

public class City 
{
    public int name;
    public double x;
    public double y;
    
    public City city;
    
    //new City with a name and X,Y coordinate
    public City(int name, double x, double y) 
    {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    

    //sets the X,Y coordinate of a City
    public void setCity(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    //sets the name of a City
    public void setName(int name)
    {
        this.name = name;
    }
    
    //sets the X coordinate of a City
    public void setX(double x)
    {
        this.x = x;
    }
    
    //sets the Y coordinate of a City
    public void setY(double y)
    {
        this.y = y;
    }
    
    //gets the X coordinate of a City
    public double getX()
    {
        return x;
    }
    
    //gets the Y coordinate of a City
    public double getY()
    {
        return y;
    }
    
    //gets the name of a City
    public Integer getName()
    {
        return name;
    }

    //gets a City object with its respective name and X,Y coordinate
    public City getCity()
    {
        
        return city;
    }
    
    


    
}
