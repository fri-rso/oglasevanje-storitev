package si.jaklic.adverts.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Igor Fele <igor.fele@result.si>
 * @since $VERSION
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;

  @ManyToOne
  @JoinColumn(name="advert_id")
  private Advert advert;

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
}
