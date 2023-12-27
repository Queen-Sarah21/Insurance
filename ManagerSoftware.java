import Factory.Factory;
import Insurance.InsuranceAgreement;
import Insurance.User;

import java.text.SimpleDateFormat;
import java.util.*;

public class ManagerSoftware {
    private User user = new User();

    public void run(){


        Calendar currentDate = Calendar.getInstance(); // Initializes with the current date.
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        user.addAgreement(Factory.factoryMethod("regular").getAgreement());
        user.addAgreement(Factory.factoryMethod("regular").getAgreement());
        user.addAgreement(Factory.factoryMethod("premium").getAgreement());
        user.addAgreement(Factory.factoryMethod("regular").getAgreement());
        user.addAgreement(Factory.factoryMethod("premium").getAgreement());
        user.addAgreement(Factory.factoryMethod("regular").getAgreement());
        user.addAgreement(Factory.factoryMethod("premium").getAgreement());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n---------- Welcome----------");
            System.out.println("\tCurrent Date: " + dateFormat.format(currentDate.getTime()));
            System.out.println("\n\t* - Your current funds: $" + user.getMoney() + "\n");
            System.out.println("\t1 - Receive new applications");
            System.out.println("\t2 - See current agreements");
            System.out.println("\t3 - See financial breakdown");
            System.out.println("\t4 - Break an agreement");
            System.out.println("\t5 - Move time forward");
            System.out.println("\t6 - Quit\n");
            System.out.println("Please enter an option: ");

            if(scanner.hasNextInt()){
                int temp = scanner.nextInt();
                scanner.nextLine(); //consume newline
                switch (temp) {
                    case 1:
                        user= newApplications(user);
                        break;
                    case 2:
                        displayCurrentAgreements(user);
                        System.out.println("Press enter to go back");
                        scanner.nextLine();
                        break;
                    case 3:
                        displayFinancialBreakdown(user);
                        System.out.println("Press enter to go back");
                        scanner.nextLine();
                        break;
                    case 4:
                        user=breakAgreement(user);
                        break;
                    case 5:
                        currentDate.add(Calendar.YEAR, 1);
                        user=proceedOneYear(user);
                        System.out.println("Press enter to go back");
                        scanner.nextLine();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Invalid input. Please try again");
                        break;
                }
            } else {
                System.err.println("Invalid input. Please enter a number.");
                scanner.next(); //remove invalid input
            }
        }
    }

    public User newApplications(User user) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<InsuranceAgreement> agreements = new ArrayList<>();

        for (int i = 0; i < 3; i++) { // create three random regular insurances
            agreements.add(Factory.factoryMethod("regular").getAgreement());
        }

        for (int i = 3; i < 6; i++) { // create three random premium insurances
            agreements.add(Factory.factoryMethod("premium").getAgreement());
        }


        for (int i = 0; i < agreements.size(); i++) {
            System.out.println("\tApplication #" + (i + 1));
            if (i < 3) System.out.println("\t\tTier: Economy");
            else System.out.println("\t\tTier: Premium");
            agreements.get(i).display();
            System.out.println();
        }

        int choice = -1;
        while (choice < 1 || choice > agreements.size()) {
            System.out.println("\nSelect an application number to accept or 0 to go back: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice == 0) {
                    return user;
                } else if (choice > 0 && choice <= agreements.size()) {
                    if (user.getAgreements().size() < 21){
                        InsuranceAgreement selectedAgreement = agreements.get(choice - 1);
                        user.addAgreement(selectedAgreement); // Add the chosen agreement to user's list.
                        System.out.println("Application accepted and added to the user's inventory.");
                    }
                    else {
                        System.out.println("You have the maximum amount of agreements. Break some to get new ones.");
                    }
                } else {
                    System.err.println("Invalid choice. Please enter a number between 1 and " + agreements.size() + ".");
                }
            } else {
                System.err.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return user;
    }
    public void displayCurrentAgreements(User user) {

        if (user.getAgreements().isEmpty()) {
            System.out.println("The user has no current agreements.");
        } else {
            System.out.println("--------- User's Current Agreements ---------");
            for (int i = 0; i < user.getAgreements().size(); i++) {
                InsuranceAgreement agreement = user.getAgreements().get(i);
                System.out.println("\tAgreement #" + (i+1));
                agreement.display();
                System.out.println();
            }
        }
    }
    public void displayFinancialBreakdown(User user) {
        System.out.println("--------- Financial Breakdown ---------");
        System.out.println("\tTotal Payouts From Claims: $" + user.getTotalPayoutFromClaims());
        System.out.println("\tTotal Payouts From Cancellations: $" + user.getTotalPayoutFromCancellations());
        System.out.println("\tTotal Income Made: $" + user.getTotalIncome());
        user.displayYearlyNetProfits();
        System.out.println("\tAverage Net Profit: $" + user.getAverageNetProfit());
    }
    public User proceedOneYear(User user) {
        System.out.println("------ 1 Year goes by --------\n");

        Random random = new Random();
        List<String> claims = new ArrayList<>();
        double yearlyFee=0;
        double claimAmount=0;
        double yearlyTotalClaimAmount=0;
        double yearlyIncome=0;
        String claim="";

        for (InsuranceAgreement agreement : user.getAgreements()) {
            yearlyFee= agreement.getYearlyFee();
            agreement.setNetProfit(agreement.getNetProfit()+yearlyFee);

            claim="";


            // Company collects the yearly fee
            user.addMoney(yearlyFee);
            System.out.println("\tYou made $" + agreement.getYearlyFee() + " from a " + agreement.getName());
            yearlyIncome+=yearlyFee;
            if (random.nextInt(100) < agreement.getRisk()) {
                if(agreement.getName()=="regular agreement"){claimAmount = random.nextInt(1,5)*1000;}
                else {claimAmount = random.nextInt(10,50)*1000;}
                claim+="\tYou paid $" + claimAmount + " for a " + agreement.getName()+" claim";
                yearlyTotalClaimAmount+=claimAmount;
                claims.add(claim);
                agreement.setNetProfit(agreement.getNetProfit()-claimAmount);

            }

        }

        System.out.println();
        for(String i: claims){
            System.out.println(i);
        }
        System.out.println("\n\tThe company made a total of $"+yearlyIncome+" this year");

        user.addYearlyNetProfit(user.getMoney()+yearlyIncome-yearlyTotalClaimAmount);
        user.setMoney(user.getMoney()+yearlyIncome-yearlyTotalClaimAmount);
        user.setTotalPayoutFromClaim(yearlyTotalClaimAmount);
        user.setTotalIncome(yearlyIncome);
        return user;
    }
    public User breakAgreement(User user) {
        System.out.println("--------- Breaking Agreements ---------");
        displayCurrentAgreements(user);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an agreement number to break or 0 to go back: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice == 0) {
                    return user;
                } else if (choice > 0 && choice <= user.getAgreements().size()) {
                    InsuranceAgreement agreement = user.getAgreements().get(choice - 1);
                    double penaltyAmount = 10 * agreement.getYearlyFee(); //user pays 10x yearly fee to break agreement

                    // Validate if user has enough money
                    if (user.getMoney() >= penaltyAmount) {
                        user.subtractMoney(penaltyAmount); // Subtracting the money from user


                        user.setTotalPayoutFromCancellations(user.getTotalPayoutFromCancellations()+penaltyAmount);


                        // Remove the agreement from the company's and user's list
                        user.getAgreements().remove(choice - 1);

                        System.out.println("Agreement broken. You have paid the penalty of $" + penaltyAmount + ".");
                        return user;
                    } else {
                        System.err.println("You don't have enough funds to break this agreement.");
                    }
                } else {
                    System.err.println("Invalid choice. Please enter a number between 1 and " + user.getAgreements().size() + ".");
                }
            } else {
                System.err.println("Please enter a valid number.");
                scanner.next();  // Clear invalid input
            }
        }
    }
}
