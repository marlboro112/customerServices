package service.customer.api.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Component
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountDTO extends BaseDTO {


    private String accountNumber;
    private List<CorrespondentBankDTO> correspondentBank;
    private CustomerDTO customer;
    
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public List<CorrespondentBankDTO> getCorrespondentBank() {
        return correspondentBank;
    }
    public void setCorrespondentBank(List<CorrespondentBankDTO> correspondentBank) {
        this.correspondentBank = correspondentBank;
    }
    public CustomerDTO getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    
}
