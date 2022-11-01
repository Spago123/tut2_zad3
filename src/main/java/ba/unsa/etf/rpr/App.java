package ba.unsa.etf.rpr;

import java.util.*;


/**
 * Program that takes multiple number input nd return
 * min, max, mean value, average and standard deviation
 * @author Harun Spago
 * @version 1.0
 */
public class App {
    /**
     * main method is the entry method fot the program
     * @param args main method does not take any arguments
     */
    public static void main( String[] args ) {

        System.out.println("Please enter some numbers, when you're finished enter stop");

        List<Double> list = new ArrayList<>(getList());
        if(list.size() == 0){
            System.out.println("You've not typed in a single element, BYE!");
        } else {
            Collections.sort(list);
            System.out.println(list);
            System.out.println("The minimum element of the list is: " + getMin(list));
            System.out.println("The maximum element of the list is: " + getMax(list));
            System.out.println("The mean element of the list is: " + getMean(list));
            System.out.println("The average value of the list is: " + getAverageValueOfTheList(list));
            System.out.println("The standard deviation of the list is: " + getStandardDeviation(list));
        }

    }

    /**
     * A method tha lets you type in a List of numbers
     * @return List<Double>
     */
    private static List<Double> getList(){
        Scanner in = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        for(String userInput = in.nextLine(); !userInput.equals("stop"); userInput = in.nextLine()) {
            if(!isParsableToDouble(userInput))
                continue;
            list.add(Double.parseDouble(userInput));
        }
        return list;
    }

    /**
     * Method that checks if a String is parsable to Double
     * @param string that represents a number
     * @return true if parsable, false if not
     */
    private static boolean isParsableToDouble(String string){
        try{
            Double.parseDouble(string);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    /**
     * Method that return the minimum value of a List
     * @param list sorted list
     * @return minimum
     */
    private static Double getMin(List<Double> list){
        return list.get(0);
    }

    /**
     * Method that return the maximum value of a List
     * @param list sorted list
     * @return maximum
     */
    private static Double getMax(List<Double> list){
        return list.get(list.size()-1);
    }

    /**
     * Method that return the mean value of a List
     * @param list sorted list
     * @return mean
     */
    private static Double getMean(List<Double> list){
        return list.get((int)(list.size()/2.));
    }

    /**
     * Method that returns the average value of a list
     * @param list a collection of Doubles
     * @return average value of the list
     */
    private static Double getAverageValueOfTheList(List<Double> list){
        return getSumOfTheList(list)/list.size();
    }

    /**
     * Method that calculates the sum of the list
     * @param list a collection of Doubles
     * @return sum of the collection
     */
    private static double getSumOfTheList(List<Double> list){
        double suma = 0.;
        for(double elem : list)
            suma = suma + elem;
        return suma;
    }

    /**
     * Method that return standard deviation of a sorted list
     * @param list sorted list
     * @return standard deviation
     */
    private static Double getStandardDeviation(List<Double> list){
        return Math.sqrt(getSumOfSquaredDistancesFromAverageValue(list)/list.size());
    }

    /**
     * Method that returns squared distance between the mean value of the list and the list element
     * @param average mean value of the list
     * @param element element of the list
     * @return squared distance between the mean value and list element
     */
    private static Double getSquaredDistanceFromAverageValue(Double average, Double element){
        return (average - element) * (average - element);
    }

    /**
     * Sum of all squared distances from the average value of the list
     * @param list sorted list
     * @return sum of squared distances from average value
     */
    private static double getSumOfSquaredDistancesFromAverageValue(List<Double> list){
        double average = getAverageValueOfTheList(list);
        double suma = 0.;
        for (double elem : list)
            suma = suma + getSquaredDistanceFromAverageValue(average, elem);

        return suma;
    }
}
