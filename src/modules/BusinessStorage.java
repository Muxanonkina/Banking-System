package modules;

import java.util.ArrayList;

public class BusinessStorage {

    private ArrayList<String> businesses = new ArrayList<>();

    public BusinessStorage() {
        businesses.add("IT Company");
        businesses.add("Restaurant Business");
        businesses.add("Clothing Store");
        businesses.add("Construction Company");
        businesses.add("Transport Company");
        businesses.add("Pharmacy Business");
        businesses.add("Fitness Center");
        businesses.add("Agriculture Business");
        businesses.add("Online Shop");
    }

    void addBusiness(String newBusiness) {
        businesses.add(newBusiness);
        System.out.println("Business added.");
    }

    void showAllBusiness() {
        for (String business : businesses) {
            System.out.println(business);
        }
    }

    void findBusiness(int number) {
        if (number >= 0 && number < businesses.size()) {
            System.out.println("Search result: " + businesses.get(number));
        } else {
            System.out.println("Business not found.");
        }
    }

    void removeBusiness(int removeIndex) {
        if (removeIndex >= 0 && removeIndex < businesses.size()) {
            businesses.remove(removeIndex);
            System.out.println("Business removed.");
        } else {
            System.out.println("Wrong index.");
        }
    }
}