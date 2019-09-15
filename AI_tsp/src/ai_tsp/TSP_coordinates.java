package ai_tsp;

import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

public class TSP_coordinates
{
    public  String test1 = "C:\\Users\\brand\\Desktop\\test1tsp.txt";
    public  String test2 = "C:\\Users\\brand\\Desktop\\test2atsp.txt";
    public  String test3 = "C:\\Users\\brand\\Desktop\\test3atsp.txt";
    public  String everything;
    public  City city = new City(0,0,0);
    public ArrayList<City> cities = new ArrayList<>();
    public ArrayList<Integer> name = new ArrayList<>();
    public ArrayList<Double> X = new ArrayList<>();
    public ArrayList<Double> Y = new ArrayList<>();
    public ArrayList<Integer> CityDtls = new ArrayList<>();
    
   //reads the tesxt file provided
    public void textReader(String path) throws FileNotFoundException, IOException
    {
        //retrieves the file
        File file = new File(path);
        try {
            //reads the file
            Scanner input = new Scanner(file);
            //while there is another character in the file
            while (input.hasNext())
            {
                //for the ammount of integers in the file
                for (int i = 0; input.hasNext(); i++)
                { 
                   
                    //stores the data in its respective ArrayList
                    name.add(input.nextInt()); 
                    X.add(input.nextDouble());
                    Y.add(input.nextDouble());
                }
            }

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        //for every city 
        for(int i = 0; i < name.size(); i++)
        {
            
            //store a city with its respective X and Y coordinate in an ArrayList
            City tempCity = new City(name.get(i), X.get(i), Y.get(i));
            
            cities.add(tempCity);
        }
        
    }

    //runs the above mentioned file reader and returns the populated ArrayList of Cities
    public ArrayList<City> returnCities(String path) throws IOException
    {
        textReader(path);
        
        return cities;
    }
    
    
}

