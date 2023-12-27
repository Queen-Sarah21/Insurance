package Builder;

import Insurance.InsuranceAgreement;

import java.util.Random;

public class RegularInsBuilder implements IBuilder{
    private InsuranceAgreement insuranceAgreement;
    private Random random = new Random();
    public RegularInsBuilder(){insuranceAgreement = new InsuranceAgreement();}

    @Override
    public void setRisk(){
        int risk = random.nextInt(20, 60);
        insuranceAgreement.setRisk(risk);
    }
    public void setFee(){
        int fee = random.nextInt(1000, 2000);
        insuranceAgreement.setYearlyFee(fee * ( 1 + insuranceAgreement.getRisk()/100));
    }
    @Override
    public void setNetProfit(){
        insuranceAgreement.setNetProfit(0);
    }
    @Override
    public void setName() {
        insuranceAgreement.setName("regular agreement");
    }
    public void setClientName(String clientName){
        insuranceAgreement.setClientName(clientName);}
    @Override
    public InsuranceAgreement getAgreement(){
        return this.insuranceAgreement;
    }
}
