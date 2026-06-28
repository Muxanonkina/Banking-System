public enum CreditPlane {
    START(1000.0,0.20),
    STANDART(10000.0,0.15),
    PREMIUM(100000.0,0.12);

    private final double creditLimit;
    private final double interestRate;

    CreditPlane(double creditLimit, double interestRate){
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }
    public double getCreditLimit(){
        return  creditLimit;
    }
    public double getInterestRate(){
        return interestRate;
    }

}
