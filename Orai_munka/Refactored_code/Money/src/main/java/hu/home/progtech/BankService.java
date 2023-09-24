package hu.home.progtech;

import java.util.Currency;
import java.util.Optional;

public interface BankService {
    Optional<Money> convertMoney(Money moneyToConvert, Currency toCurrency);

}
