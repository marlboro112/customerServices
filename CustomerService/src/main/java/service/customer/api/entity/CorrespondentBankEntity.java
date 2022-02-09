package service.customer.api.entity;

import javax.persistence.Entity;
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

    private String bankName;
    private String bankSwift;
    private String correspondentAccount;
    
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
    public String getCorrespondentAccount() {
        return correspondentAccount;
    }
    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    

}
