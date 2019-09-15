package ai_tsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OPT_2
{
    public TSP_coordinates tsp_coords = new TSP_coordinates();
    public ArrayList<City> cities = new ArrayList<>();
    public ArrayList<City> orderedCities = new ArrayList<>();
    public boolean changeFound = false;
    public double path1;
    public double newDistance;
    public double bestDistance;

    public OPT_2() throws IOException
    {
       
    }   
    
    public void algorithm(String path) throws IOException
    {
        
        cities = tsp_coords.returnCities(path);
        
        for(int i = 0; i < cities.size() ;i++)
        {
            int counter = 0;
            int counter1 = (counter + 1);
            
             double temp = Math.sqrt(Math.pow((cities.get(counter).getX() - cities.get(counter1).getX()), 2) + Math.pow((cities.get(counter).getY() - cities.get(counter1).getY()), 2));
             
             path1 = (path1 + temp);
             
             counter++;
        }
        
       long startTimer = System.nanoTime();
        
       do
       {
           changeFound = false;
           
           bestDistance = path1;
           
           for(int i = 0; i < cities.size()-1; i++)
           {
               for(int j = 0/*(i+1)*/; j < cities.size()-1; j++)
               {
                   
                   Collections.swap(cities, i, j);
                   
                   int counter = 0;
                   
                   for(int x = 0; x < cities.size() ;x++)
                   {
                       
                       int counter1 = (counter + 1);

                       double temp = Math.sqrt(Math.pow((cities.get(counter).getX() - cities.get(counter1).getX()), 2) + Math.pow((cities.get(counter).getY() - cities.get(counter1).getY()), 2));

                       newDistance = (newDistance + temp);

                       counter++;
                   }
                   
                   

                   if ( newDistance < bestDistance ) 
                   {


                       for (int z = 0; z < cities.size(); z++)
                       {
                           cities.set(z, cities.get(z));
                       }

                       bestDistance = newDistance;
                       changeFound = true;

                   }
                   else
                   {
                       Collections.swap(cities, i, j);
                   }
               }
           }
       }
       while(changeFound = true);
       
       Long endTimer = System.nanoTime();
       
       long finalTime = endTimer - startTimer;
        
       System.out.println("shortest distance : " + bestDistance + " shortest time: " + finalTime + " ms");
       
    }
    
    public void Swap(int i, int j)
    {
        double distance1 = path1;
        
        for(int x = 0; x <= i - 1; ++x)
        {
            orderedCities.set(x, cities.get(x));
        }
        
        int counter = 0;
        for(int x = i; x <= j; ++x)
        {
            orderedCities.set(x, cities.get(j - counter));
            counter++;
        }
        
        for(int x = j + 1; x < distance1; ++x)
        {
            orderedCities.set(x, cities.get(x));
        }
    }
    
    

}