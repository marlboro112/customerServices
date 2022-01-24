package service.customer.api.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "Requisites")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequisitesEntity extends BaseEntity {
    
	private static final long serialVersionUID = 6503465558218778130L;
	
	private String bankName;
    private String bankAddress;
    private String bankCode;
    private String bankTaxId;
    private String bankCorrespondentAccount;
    private String bankSwift;
    private String customerName;
    private String customerAccountNumber;
    private String currency;
    
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankAddress() {
        return bankAddress;
    }
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
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
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }
    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    
}
