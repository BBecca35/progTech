package hu.home.progtech;


import java.util.Currency;

public class Main {
    public static void main(String[] args) {
        Money huf100 = new Money(100, Currency.getInstance("HUF"));
        Money huf1000 = new Money(1000, Currency.getInstance("HUF"));
        Money usd5 = new Money(5, Currency.getInstance("USD"));

        BankService bank = new StaticBank();

        //System.out.println(huf100.compareTo(huf1000));
        //System.out.println(huf100.add(huf1000));
        //System.out.println(huf100.add(huf1000, bank));
        //System.out.println(huf1000.add(usd5, bank));
        System.out.println(usd5.add(huf1000, bank));
        //System.out.println(usd5.add(null, bank));

    }
}
