package Interview.other;
import java.util.List;

public class Solutionq {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Solutionq sol = new Solutionq();
        List<List<String>> countryPairs = new java.util.ArrayList<>();
        countryPairs.add(java.util.Arrays.asList("SL", "IND"));
        countryPairs.add(java.util.Arrays.asList("PAK", "USA"));
        countryPairs.add(java.util.Arrays.asList("IND", "JPN"));
        countryPairs.add(java.util.Arrays.asList("JPN", "PAK"));
        List<String> travelOrder = sol.getCountryTravelOrder(countryPairs);
        System.out.println(travelOrder);

    }

    /*  [[SL, IND] , [PAK, USA], [IND, JPN], [JPN, PAK]] From this list
      get the order to go from the starting country to the destination. 
      In this case SL, IND, JPN, PAK, USA is the order.
      create the function
        Input: List of country pairs
        Output: List of countries in travel order


    */
    public List<String>getCountryTravelOrder( List<List<String>> countryPairs) {
        java.util.Map<String, String> travelMap = new java.util.HashMap<>();
        java.util.Set<String> destinations = new java.util.HashSet<>();
        for (List<String> pair : countryPairs) {
            travelMap.put(pair.get(0), pair.get(1));
            destinations.add(pair.get(1));
        }
        String startCountry = null;
        for (String country : travelMap.keySet()) {
            if (!destinations.contains(country)) {
                startCountry = country;
                break;
            }
        }
        List<String> travelOrder = new java.util.ArrayList<>();
        while (startCountry != null) {
            travelOrder.add(startCountry);
            startCountry = travelMap.get(startCountry);
        }
        return travelOrder;
    }
}

