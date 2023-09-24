package hu.home.progtech;

import java.util.Currency;
import java.util.Optional;

public class StaticBank implements BankService {

    private static final Currency USD = Currency.getInstance("USD");
    private static final Currency HUF = Currency.getInstance("HUF");

    @Override
    //Csak visszatérési értékként lehet használni az Optionalt!!!
    public Optional<Money> convertMoney(Money moneyToConvert, Currency toCurrency) {
        Optional<Money> money = Optional.ofNullable(moneyToConvert);
        if (money
                .map(e -> e.getCurrency() != null && e.getCurrency().equals(toCurrency))
                .orElse(false)
        ); {
            if (toCurrency.equals(USD) && moneyToConvert.getCurrency().equals(HUF)) {
                money = Optional.of(new Money(moneyToConvert.value * 0.0034, USD));
            }
            else if (toCurrency.equals(HUF) && moneyToConvert.getCurrency().equals(USD)) {
                money = Optional.of(new Money(moneyToConvert.value * 249.3, HUF));
            }
            else {
                return null;
            }
        }
        return money;
    }
}
