package service.customer.api.entity;

import java.util.List;

import javax.persistence.Column;
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
    
	private static final long serialVersionUID = 4700626407295949960L;

	@Column(name = "bankName", length = 255, nullable = false, unique = false)
    private String bankName; 
    
    @Column(name = "bankCode", length = 255, nullable = false, unique = false)
    private String bankCode;

    @Column(name = "bankTaxId", length = 255, nullable = false, unique = false)
    private String bankTaxId;

    @Column(name = "bankCorrespondentAccount", length = 255, nullable = false, unique = false)
    private String bankCorrespondentAccount;

    @Column(name = "bankSwift", length = 255, nullable = false, unique = false)
    private String bankSwift;

    @Column(name = "bankAddress", length = 255, nullable = false, unique = false)
    private String bankAddress;

    @Column(name = "customerAccountNumber", length = 255, nullable = false, unique = true)
    private String customerAccountNumber;

    @Column(name = "currency", length = 255, nullable = false, unique = false)
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
