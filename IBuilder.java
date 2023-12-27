package Builder;

import Insurance.InsuranceAgreement;

public interface IBuilder {
     void setFee();
     void setRisk();
     void setNetProfit();
     void setClientName(String clientName);
     void setName();

     InsuranceAgreement getAgreement();
}
