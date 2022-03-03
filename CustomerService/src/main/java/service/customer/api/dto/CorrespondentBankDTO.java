package service.customer.api.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Component
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CorrespondentBankDTO {

    private String bankName;
    private String bankSwift;
    private String correspondentAccountOrIBAN;
    private String bankCode;
    private String bankTaxId;
    private String bankAddress;
    private AccountDTO account;
    
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankSwift() {
        return bankSwift;
    }
    public void setBankSwift(String bankSwift) {
        this.bankSwift = bankSwift;
    }
    public String getCorrespondentAccountOrIBAN() {
        return correspondentAccountOrIBAN;
    }
    public void setCorrespondentAccountOrIBAN(String correspondentAccountOrIBAN) {
        this.correspondentAccountOrIBAN = correspondentAccountOrIBAN;
    }
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public String getBankTaxId() {
        return bankTaxId;
    }
    public void setBankTaxId(String bankTaxId) {
        this.bankTaxId = bankTaxId;
    }
    public String getBankAddress() {
        return bankAddress;
    }
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }
    public AccountDTO getAccount() {
        return account;
    }
    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    
    
}
