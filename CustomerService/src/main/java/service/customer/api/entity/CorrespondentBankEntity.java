package service.customer.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "CorrespondentBank")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CorrespondentBankEntity extends BaseEntity{

    @Column(name = "bankName", length = 255, nullable = false, unique = false)
    private String bankName;
    
    @Column(name = "bankSwift", length = 255, nullable = false, unique = false)
    private String bankSwift;

    @Column(name = "correspondentAccountOrIBAN", length = 255, nullable = false, unique = false)
    private String correspondentAccountOrIBAN;

    @Column(name = "bankCode", length = 255, nullable = true, unique = false)
    private String bankCode;

    @Column(name = "bankTaxId", length = 255, nullable = true, unique = false)
    private String bankTaxId;

    @Column(name = "bankAddress", length = 255, nullable = true, unique = false)
    private String bankAddress;

    @ManyToOne
	@JoinColumn(name = "account_id")
    private AccountEntity account;

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

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    
    
    

}
