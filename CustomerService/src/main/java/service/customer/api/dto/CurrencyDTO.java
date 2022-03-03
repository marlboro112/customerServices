package service.customer.api.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Component
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CurrencyDTO {
    
    private String currencyName;
    private AccountDTO account;
    
    public String getCurrencyName() {
        return currencyName;
    }
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    public AccountDTO getAccount() {
        return account;
    }
    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    

}
