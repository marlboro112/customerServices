package service.customer.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "currencyName", length = 10, nullable = false, unique = true)
    private String currencyName;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

}
