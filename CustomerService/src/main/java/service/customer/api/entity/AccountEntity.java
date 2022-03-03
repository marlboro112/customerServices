package service.customer.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "Account")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountEntity extends BaseEntity {
    
    @Column(name = "accountNumber", length = 255, nullable = false, unique = true)
    private String accountNumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<CorrespondentBankEntity> correspondentBank;

    @ManyToOne
	@JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<CorrespondentBankEntity> getCorrespondentBank() {
        return correspondentBank;
    }

    public void setCorrespondentBank(List<CorrespondentBankEntity> correspondentBank) {
        this.correspondentBank = correspondentBank;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    


}
