package Builder;

import Insurance.InsuranceAgreement;

import java.util.Random;

public class PremiumInsBuilder implements IBuilder{
    private InsuranceAgreement insuranceAgreement;
    private Random random = new Random();

    public PremiumInsBuilder(){insuranceAgreement = new InsuranceAgreement();}

    @Override
    public void setRisk(){
        int risk = random.nextInt(50, 80);
        insuranceAgreement.setRisk(risk);
    }

    @Override
    public void setName() {
        insuranceAgreement.setName("premium agreement");
    }

    @Override
    public void setFee(){
        int fee = random.nextInt(3000, 8000);
        insuranceAgreement.setYearlyFee(fee);
        insuranceAgreement.setYearlyFee(fee * (insuranceAgreement.getRisk()/10));
    }
    @Override
    public void setNetProfit(){
        insuranceAgreement.setNetProfit(0);
    }
    public void setClientName(String clientName){
        insuranceAgreement.setClientName(clientName);}
    @Override
    public InsuranceAgreement getAgreement(){
        return this.insuranceAgreement;
    }

}
