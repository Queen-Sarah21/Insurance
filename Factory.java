package Factory;

import Builder.*;

public abstract class Factory {

    private static Engineer factory = null;
    public static Engineer factoryMethod(String type){
        IBuilder iBuilder = null;
        switch (type){
            case "premium":
                iBuilder = new PremiumInsBuilder();
                break;
            case "regular":
                iBuilder = new RegularInsBuilder();
                break;

        }

        factory = new Engineer(iBuilder);
        factory.createAgreement();
        return factory;
    }
}


