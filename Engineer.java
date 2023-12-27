package Builder;
import Insurance.InsuranceAgreement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Engineer {
     private IBuilder iBuilder;
    public Engineer(IBuilder iBuilder){
        this.iBuilder = iBuilder;

    }
    private String findName(){
        List<String> firstName=new ArrayList<>();

        List<String> lastName= new ArrayList<>();
        firstName.add("Tu"); firstName.add("Miguel");firstName.add("Queen");
        firstName.add("Aurélien");lastName.add("Anh");lastName.add("Cortes");
        lastName.add("Anumu");lastName.add("Ebeng");
        Random random = new Random();
        String clientName=firstName.get(random.nextInt(0,firstName.size()));
        clientName+=" "+lastName.get(random.nextInt(0,lastName.size()));
        return clientName;
    }
    public void createAgreement(){
        iBuilder.setName();
        iBuilder.setRisk();
        iBuilder.setFee();
        iBuilder.setNetProfit();
        iBuilder.getAgreement();
        iBuilder.setClientName(findName());
    }


    public InsuranceAgreement getAgreement(){
        return iBuilder.getAgreement();
    }
}


