package service.customer.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "Currency")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CurrencyEntity extends BaseEntity {

	private static final long serialVersionUID = -3578870718660905925L;
	
	@Column(name = "currencyName", length = 10, nullable = false, unique = true)
    private String currencyName;

    @OneToOne
	@JoinTable(name = "currency_account",
				joinColumns = {@JoinColumn(name = "currency_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")})
    private AccountEntity account;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    

}
