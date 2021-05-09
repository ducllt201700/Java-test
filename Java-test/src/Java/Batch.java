package Java;

import java.util.*;
import java.util.stream.Collectors;

public class Batch {
    static ArrayList<Cow> Cows;
    static ArrayList<Goat> Goats;
    String name;

    public Batch(String name){
        this.name = name;
        Cows = new ArrayList<Cow>();
        Goats = new ArrayList<Goat>();
    }

    //Add cattle to batch
    public void AddCows(String codeName, int age, float weight){
        Cow cow = new Cow(codeName, age, weight);
        Cows.add(cow);
    }
    public void AddGoat(String codeName, int age, float weight){
        Goat goat = new Goat(codeName, age, weight);
        Goats.add(goat);
    }

    // Find cattle with most milk
    public void MostProductiveCattle (){
        ArrayList<Float> cattleProductive = new ArrayList<Float>();
        for (Cow cow: Cows) {
            cattleProductive.add(cow.dailyMilk());
        }
        for (Goat goat: Goats) {
            cattleProductive.add(goat.dailyMilk());
        }

        float max = Collections.max(cattleProductive);
        System.out.println("The most milk produced in 1 day:" + max);
        for (int i = 0; i <= Cows.size()-1; i++) {
            if (Cows.get(i).dailyMilk() == max) {
                Cows.get(i).printInfo();
            }
        }
        for (int i = 0; i <= Goats.size()-1; i++) {
            if (Goats.get(i).dailyMilk() == max) {
                Goats.get(i).printInfo();
            }
        }

    }

    // Find by code
    public Cow FindCowByCode (String codeName){
        return Cows.stream().filter(cow -> codeName.equals(cow.codeName)).findFirst().orElse(null);
    }

    public Goat FindGoatByCode (String codeName){
        return Goats.stream().filter(goat -> codeName.equals(goat.codeName)).findFirst().orElse(null);
    }

    //Find by age
    public Cow FindCowByAge (int age){
        return Cows.stream().filter(cow -> String.valueOf(age).equals(String.valueOf(cow.age))).findAny().orElse(null);
    }

    public Goat FindGoatByAge (int age){
        return Goats.stream().filter(goat -> String.valueOf(age).equals(String.valueOf(goat.age))).findAny().orElse(null);
    }
    
    // total milk amount
    public int CowsMilkTotal(){
        int sum = 0;
        for (Cow cow: Cows
             ) {
            sum += cow.dailyMilk();
        }
        return sum;
    }
    public int GoatsMilkTotal() {
        int sum = 0;
        for (Goat goat : Goats
        ) {
            sum += goat.dailyMilk();
        }
        return sum;
    }

    //sort by milk amount
    public void SortByMilk(){
        ArrayList<Float> sortList = new ArrayList<>();
        for (Cow cow: Cows) {
            sortList.add(cow.dailyMilk());
        }
        for (Goat goat: Goats) {
            sortList.add(goat.dailyMilk());
        }

        List<Float> sortedList = sortList.stream().sorted().distinct().collect(Collectors.toList());
        for (int i = 0; i <= sortedList.size()-1; i++){
            for (int j = 0; j <= Cows.size()-1; j++){
                if (sortedList.get(i) == Cows.get(j).dailyMilk()){
                    System.out.println("Cow with code name: " + Cows.get(j).codeName + " milk amount: " + Cows.get(j).dailyMilk());
                }
            }
            for (int j = 0; j <= Goats.size()-1; j++){
                if (sortedList.get(i) == Goats.get(j).dailyMilk()){
                    System.out.println("Goat with code name: " + Goats.get(j).codeName + " milk amount: " + Goats.get(j).dailyMilk());
                }
            }
        }
    }

    //sort by age
    public void SortByAge(){
        ArrayList<Integer> sortList = new ArrayList<>();
        for (Cow cow: Cows) {
            sortList.add(cow.age);
        }
        for (Goat goat: Goats) {
            sortList.add(goat.age);
        }
        List<Integer> sortedList = sortList.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
        for (int i = 0; i <= sortedList.size()-1; i++){
            for (int j = 0; j <= Cows.size()-1; j++){
                if (sortedList.get(i) == Cows.get(j).age){
                    System.out.println("Cow with code name: " + Cows.get(j).codeName + " age: " + Cows.get(j).age);
                }
            }
            for (int j = 0; j <= Goats.size()-1; j++){
                if (sortedList.get(i) == Goats.get(j).age){
                    System.out.println("Goat with code name: " + Goats.get(j).codeName + " age: " + Goats.get(j).age);
                }
            }
        }
    }

}
