package service.customer.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "equisitesForLocalCurrency")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequisitesForLocalCurrencyEntity extends BaseEntity {
    
<<<<<<< HEAD:CustomerService/src/main/java/service/customer/api/entity/RequisitesForLocalCurrencyEntity.java
    private String bankName;    
=======
	private static final long serialVersionUID = 6503465558218778130L;
	
	private String bankName;
    private String bankAddress;
>>>>>>> f3330d20ad216fa0fc3e7d77bea229263bebfcb7:CustomerService/src/main/java/service/customer/api/entity/RequisitesEntity.java
    private String bankCode;
    private String bankTaxId;
    private String bankCorrespondentAccount;
    private String bankSwift;
    private String bankAddress;
    private String customerAccountNumber;
    private List <CurrencyEntity> currency;
    
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
    public List<CurrencyEntity> getCurrency() {
        return currency;
    }
    public void setCurrency(List<CurrencyEntity> currency) {
        this.currency = currency;
    }
    
    

    
}
