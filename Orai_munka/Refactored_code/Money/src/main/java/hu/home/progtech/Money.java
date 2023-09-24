package hu.home.progtech;

import java.util.Currency;

public class Money {
    
    public double value;
    public Currency currency;

    public Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money add(Money moneyToAdd, BankService bankService) {
        Money convertedMoney = bankService.convertMoney(moneyToAdd, this.getCurrency())
                .orElse(new Money(0, this.currency));
        this.value += convertedMoney.getValue();
        return this;
    }

    private Money convertMoney(Money moneyToConvert) {
        if (!this.currency.equals(moneyToConvert.getCurrency())) {
            if (this.getCurrency().equals(Currency.getInstance("USD")) && moneyToConvert.getCurrency().equals(Currency.getInstance("HUF"))) {
                moneyToConvert = new Money(moneyToConvert.value * 0.0034, Currency.getInstance("USD"));
            }
            else if (this.getCurrency().equals(Currency.getInstance("HUF")) && moneyToConvert.getCurrency().equals(Currency.getInstance("USD"))) {
                moneyToConvert = new Money(moneyToConvert.value * 249.3, Currency.getInstance("HUF"));
            }
            else {
                return null;
            }
        }
        return moneyToConvert;
    }

    public Integer compareTo(Money moneyToCompare) {
        moneyToCompare = getMoney(moneyToCompare);
        if (moneyToCompare == null) return null;
        return Double.compare(this.getValue(), moneyToCompare.getValue());
    }

    private Money getMoney(Money moneyToCompare) {
        moneyToCompare = convertMoney(moneyToCompare);
        if (moneyToCompare == null) return null;
        return moneyToCompare;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Money{");
        sb.append("value=").append(value);
        sb.append(", currency=").append(currency);
        sb.append('}');
        return sb.toString();
    }
}
