/**
 * Gökay_Şahin 31.03.2020 041901032
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gökay_Şahin {
    public static void main(String args[]) {
        String citiesFileName = "city.txt";
        String tripFileName = "trip5.txt";
        try {
            File cityDataBase = new File(citiesFileName);
            ArrayList<City> cityDatas = cityDataReader(cityDataBase);
            File tripDataBase = new File(tripFileName);
            ArrayList<City> tripDatas = tripFileReader(tripDataBase, cityDatas);
            tripPrinter(tripDatas);
        } catch (FileNotFoundException fnex) {
            System.out.println("System couldn't find files.");
        }
    }

    public static ArrayList<City> cityDataReader(File cityDataFile) throws FileNotFoundException {
        ArrayList<City> cityArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(cityDataFile);
        while (scanner.hasNext()) {
            try {
                String wholeData = scanner.nextLine();
                if (wholeData.contains("Latitude")) {
                    continue;
                }
                String[] wholeDataArray = wholeData.split(";");
                String name = wholeDataArray[0];
                int latitude = Integer.parseInt(wholeDataArray[1], 10);
                int longtitude = Integer.parseInt(wholeDataArray[2], 10);
                String country = wholeDataArray[3];
                int population = Integer.parseInt(wholeDataArray[4], 10);
                City createdCity = new City(name, latitude, longtitude, country, population);
                cityArrayList.add(createdCity);
            } catch (NegativeArraySizeException ngex) {
            }

        }
        scanner.close();
        return cityArrayList;
    }

    public static ArrayList<City> tripFileReader(File tripDataFile, ArrayList<City> cityArrayList) throws FileNotFoundException {
        ArrayList<String> tripDestinations = new ArrayList<>();
        ArrayList<City> tripCities = new ArrayList<>();
        Scanner scanner = new Scanner(tripDataFile);
        while (scanner.hasNextLine()) {
            String destinationCity = scanner.nextLine();
            tripDestinations.add(destinationCity);
        }
        scanner.close();
        for (int i = 0; i < tripDestinations.size(); i++) {
            boolean isMatched = false;
            for (int j = 0; j < cityArrayList.size(); j++) {
                if (tripDestinations.get(i).equals(cityArrayList.get(j).getName())) {
                    tripCities.add(cityArrayList.get(j));
                    isMatched = true;
                }
            }
            if (!isMatched) {
                System.out.println("City database loaded with " + cityArrayList.size() + " cities.\n " + tripDestinations.get(i) + " is not found in the city database. Incorrect city name in the trip file.\n " +
                        "Exiting the program. ");
                System.exit(0);
            }
        }
        return tripCities;
    }

    public static double distanceCalculator(City inputCityOne, City inputCityTwo) {
        double firstLatitude = (inputCityOne.getLatitude() / 10000.0) * 111.0;//111
        double secondLatitude = (inputCityTwo.getLatitude() / 10000.0) * 111.0;
        double firstLongtitude = (inputCityOne.getLongitude() / 10000.0) * 85.0;//85
        double secondLongtitude = (inputCityTwo.getLongitude() / 10000.0) * 85.0;
        double distance = Math.sqrt(Math.pow((secondLatitude - firstLatitude), 2)
                + Math.pow((secondLongtitude - firstLongtitude), 2));
        return distance;
    }

    public static void tripPrinter(ArrayList<City> inputTripDestinations) {
        double totalDistance = 0;
        System.out.println("TRIP DETAILS");
        for (int i = 0; i < inputTripDestinations.size() - 1; i++) {
            System.out.println(inputTripDestinations.get(i).getName() + " [x:" + inputTripDestinations.get(i).getLongitude() + ", y:" + inputTripDestinations.get(i).getLatitude() + "] --> " +
                    inputTripDestinations.get(i + 1).getName() + " [x:" + inputTripDestinations.get(i + 1).getLongitude() + ", y:" + inputTripDestinations.get(i + 1).getLatitude() + "]" + " Distance: " + (int) distanceCalculator(inputTripDestinations.get(i), inputTripDestinations.get(i + 1)) + " km");// didn't understand how to format from oracle doc
            totalDistance += distanceCalculator(inputTripDestinations.get(i), inputTripDestinations.get(i + 1));
        }
        System.out.println("Total trip distance:" + (int) totalDistance + " km");
    }
}