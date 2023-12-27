package Insurance;
public class InsuranceAgreement {

    private double yearlyFee;
    private int risk;
    private double netProfit;
    private String name;
    private String clientName;



    public void setYearlyFee(double yearlyFee) {
        this.yearlyFee = yearlyFee;
    }
    public double getYearlyFee() {return yearlyFee;}

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }
    public int getRisk() {return risk;}

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }
    public double getNetProfit(){return netProfit;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display(){
        System.out.println("\t\tClient Name: "+this.clientName);
        System.out.println("\t\tYearly fee : $" + this.yearlyFee);
        System.out.println("\t\tRisk : " + this.risk + "%");
        System.out.println("\t\tNet profit : $" + this.netProfit);
    }
}
