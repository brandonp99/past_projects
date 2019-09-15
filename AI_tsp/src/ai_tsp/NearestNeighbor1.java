package ai_tsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NearestNeighbor1 
{
    public TSP_coordinates tsp_coords = new TSP_coordinates();
    public City city = new City(0,0,0);
    public ArrayList<City> cities = new ArrayList<>();
    public ArrayList<City> orderedCities = new ArrayList<>();
    public double distance;
    public int start = 0;
    public City thisCity = new City(0,0,0);
    public long startTimer;
    public long endTimer;
    
    //a new instance of the Nearest Neighbor Algorithm
    public NearestNeighbor1()
    {
        
    }
    
   
    //runs the Nearest Neaighbor algorithm
    public void algorithm(String path) throws IOException
    {
         startTimer = System.nanoTime();
        //retrieves an ArrayList of Cities and stores them
        cities = tsp_coords.returnCities(path);
        
        //assigns the starting City to a separate City object
        thisCity = cities.get(start);
        orderedCities.add(thisCity);
        cities.remove(start);
        //starts the timer
        
        
        
        
        //while the cities ArrayList is not empty
        while(!cities.isEmpty())
        {
            //declares a temporary variable for the shortest distance
            double shrt_dst = 0;
            //declares a temporary variable for th closest City
            City closest = new City(0, 0, 0);
            
            
            //for the ammount of cities in the ArrayList
            for(int i = 0; i <= cities.size()-1; i++)
            {
                //checks the distance between the current city and the rest of the cities
                distance = Math.sqrt(Math.pow((thisCity.getX() - cities.get(i).getX()), 2) + Math.pow((thisCity.getY() - cities.get(i).getY()), 2));
              
                //if the shortest distance is 0 or the distance checked is shorter than the current chortest distance
                if((shrt_dst == 0) || (distance < shrt_dst))
                {
                    //set the shortest distance as the current checked distance
                    shrt_dst = distance;
                    //set the closest city as the currnet checked city
                    closest = cities.get(i);
                  
                }
              
            }
            //adds the current closest city to a new Arraylist which contains the cities in the shortest order
            orderedCities.add(closest);
            //sets the closest city to the current city
            thisCity = closest;
            //removes the current city from the old ArrayList of cities
            cities.remove(thisCity);
        }
        
        
        //sets a new City object as the first city in the ordered ArrayList
        City firstCity = orderedCities.get(0);
        //sets a new City object as the last city in the ordered ArrayList
        City lastCity = orderedCities.get((orderedCities.size() - 1));
        //creates a new variable for the calculated distance
        double calcDist = 0;
        
       
        //for the ammount of cities in the ordered cities ArrayList
        for(int i = 0; i <= orderedCities.size() ;i++)
        {
            //creates two new temporary variables that are iterated, the second variable is always one more than the other
            int counter = 0;
            int counter1 = (counter + 1);
            
            //calculates the distance between all of the cities in the ordered cities ArrayList
            double temp = Math.sqrt(Math.pow((orderedCities.get(counter).getX() - orderedCities.get(counter1).getX()), 2) + Math.pow((orderedCities.get(counter).getY() - orderedCities.get(counter1).getY()), 2));
            
            calcDist = (calcDist + temp);
             
            counter++;

        }
        
        
        
        //adds the distance between the last city and the first city to the total distance
        double temp = Math.sqrt(Math.pow((firstCity.getX() - lastCity.getX()), 2) + Math.pow((firstCity.getY() - lastCity.getY()), 2));
        
        calcDist = (calcDist + temp);        
        
        //stops the timer and calculates the time passed
        endTimer = System.nanoTime();
        long time = endTimer - startTimer;
        long finalTime = TimeUnit.NANOSECONDS.toMillis(time);
        
        for(int i = 0; i < orderedCities.size(); i++)
        {
            
            System.out.println(orderedCities.get(i).getName()); 
        }
        
        //prints the total shortest distance and the time taken to calculate it
        System.out.println("shortest distance : " + calcDist + " shortest time: " + finalTime + " ms");
        
        
    }
    
}
