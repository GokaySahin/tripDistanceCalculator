/**
 * @author Gökay_Şahin 041901032
 */
public class City {
    private String name;
    private int latitude;
    private int longitude;
    private String country;
    private int population;

    public City() {}

    /**
     * To get a name of city
     *
     * @return city name
     */
    public String getName() {
        return name;
    }

    /**
     * To set  name to a city
     *
     * @param name a new city name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * To get a Latitude of city
     *
     * @return city's latitude
     */
    public int getLatitude() {
        return latitude;
    }

    /**
     * To set latitude to a city
     *
     * @param latitude a new city's latitude
     */
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    /**
     * To get a longtitude of city
     *
     * @return city's longitutde
     */
    public int getLongitude() {
        return longitude;
    }

    /**
     * To set longitude to a city
     *
     * @param longitude a new city's longitude
     */
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    /**
     * To get a country name of city
     *
     * @return country which contains the city
     */
    public String getCountry() {
        return country;
    }

    /**
     * To set country name to a city
     *
     * @param country a new city's country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * To get population of city
     *
     * @return population of a city
     */
    public int getPoupulation() {
        return poupulation;
    }

    /**
     * @param poupulation a new city's population
     */
    public void setPoupulation(int poupulation) {
        this.poupulation = poupulation;
    }

    /**
     * a constructor with all parameters
     *
     * @param inputName       city's name
     * @param inputLatitude   city's latitude
     * @param inputLongitude  city's longitude
     * @param inputCountry    country which contains the city
     * @param inputPopulation city's population
     */
    public City(String inputName, int inputLatitude, int inputLongitude, String inputCountry, int inputPopulation) {
        this.name = inputName;
        this.latitude = inputLatitude;
        this.longitude = inputLongitude;
        this.country = inputCountry;
        this.poupulation = inputPopulation;
    }
}
