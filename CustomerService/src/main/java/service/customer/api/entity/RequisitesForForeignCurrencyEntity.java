package service.customer.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "RequisitesForForeignCurrency")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequisitesForForeignCurrencyEntity extends BaseEntity {
    
    private String bankName;    
    private String bankCode;
    private String bankTaxId;
    private String bankCorrespondentAccount;
    private String bankSwift;
    private String bankAddress;
    private String customerAccountNumber;
    private List <CurrencyEntity> currencyEntities;
    private List<CorrespondentBankEntity> correspondentBankEntities;
    
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
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
    public String getBankCorrespondentAccount() {
        return bankCorrespondentAccount;
    }
    public void setBankCorrespondentAccount(String bankCorrespondentAccount) {
        this.bankCorrespondentAccount = bankCorrespondentAccount;
    }
    public String getBankSwift() {
        return bankSwift;
    }
    public void setBankSwift(String bankSwift) {
        this.bankSwift = bankSwift;
    }
    public String getBankAddress() {
        return bankAddress;
    }
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }
    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }
    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }
    public List<CurrencyEntity> getCurrencyEntities() {
        return currencyEntities;
    }
    public void setCurrencyEntities(List<CurrencyEntity> currencyEntities) {
        this.currencyEntities = currencyEntities;
    }
    public List<CorrespondentBankEntity> getCorrespondentBankEntities() {
        return correspondentBankEntities;
    }
    public void setCorrespondentBankEntities(List<CorrespondentBankEntity> correspondentBankEntities) {
        this.correspondentBankEntities = correspondentBankEntities;
    }

    
}
