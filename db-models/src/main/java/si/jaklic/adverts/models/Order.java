package si.jaklic.adverts.models;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name="quantity", columnDefinition="integer")
    private Integer quantity;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="advert_id")
    public Advert advert;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final Date dateTime) {
        this.orderDate = dateTime;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(final Advert advert) {
        this.advert = advert;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
