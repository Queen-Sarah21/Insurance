package Insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    private double money = 100000;
    private double totalPayoutFromClaims = 0;
    private double totalPayoutFromCancellations = 0;
    private double totalIncome = 0;
    private static final int MAX_AGREEMENTS = 20;


    private List<InsuranceAgreement> agreements;
    private ArrayList<Double> yearlyNetProfits = new ArrayList<>();

    public User(){
        this.agreements = new ArrayList<>();
        Random random = new Random();
        this.money = random.nextInt(80000, 200000);
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public double getMoney() {
        return money;
    }
    public void addMoney(double amount) {
        this.money += amount;
    }
    public void subtractMoney(double amount) {

            this.money -= amount;

    }

    public List<InsuranceAgreement> getAgreements() {
        return agreements;
    }
    public void addAgreement(InsuranceAgreement agreement) {
        if (this.agreements.size() < MAX_AGREEMENTS) {
            this.agreements.add(agreement);
        } else {
            System.out.println("Maximum number of insurance agreements reached.");
        }
    }




    public double getTotalPayoutFromClaims() {
        return totalPayoutFromClaims;
    }
    public void setTotalPayoutFromClaim(double amount){this.totalPayoutFromClaims+=amount;}

    public double getTotalPayoutFromCancellations() {
        return totalPayoutFromCancellations;
    }
    public void setTotalPayoutFromCancellations(double amount){this.totalPayoutFromCancellations+=amount;}

    public double getTotalIncome() {
        return totalIncome;
    }
    public void setTotalIncome(double amount){this.totalIncome+=amount;}

    public double getAverageNetProfit() {
        double sum = 0;
        for (double profit : yearlyNetProfits) {
            sum += profit;
        }
        if(yearlyNetProfits.size() == 0) {
            return 0; // Or some default value indicating no data.
        }
        return sum / yearlyNetProfits.size();
    }


    public void addYearlyNetProfit(double profit) {
        yearlyNetProfits.add(profit);
    }


    public void displayYearlyNetProfits() {
        System.out.println("\tYearly Net Profits:");
        for (int i = 0; i < yearlyNetProfits.size(); i++) {
            System.out.println("\t\t" + String.format("  Year %d: $%.2f", i+1, yearlyNetProfits.get(i)));
        }
    }


}