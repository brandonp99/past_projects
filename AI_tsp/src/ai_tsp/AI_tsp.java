package ai_tsp;

import java.io.IOException;
import java.util.InputMismatchException;

public class AI_tsp 
{
    public static String test1 = "C:\\Users\\brand\\Desktop\\test1tsp.txt";
    public static String test2 = "C:\\Users\\brand\\Desktop\\test2atsp.txt";
    public static String test3 = "C:\\Users\\brand\\Desktop\\test3atsp.txt";
    public static TSP_coordinates coordinates = new TSP_coordinates();
    public static City[] cities;
    public static NearestNeighbor1 NN = new NearestNeighbor1();
    public static OPT_2 OPT;


    public static void main(String[] args) throws IOException, Exception 
    {
        OPT = new OPT_2();
       
        //nearest neighbor algorithm
        NN.algorithm(test1);
        
        //2-OPT algorithm(is not functional)
        //OPT.algorithm(test1);


    }
    
}
