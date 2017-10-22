package si.jaklic.adverts.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author Igor Fele <igor.fele@result.si>
 * @since $VERSION
 */
@Entity
@Table(name = "adverts")
@NamedQuery(name = "Advert.findAll", query = "SELECT a from Advert a")
public class Advert {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  private String description;

  private String author;

  @OneToMany(mappedBy = "advert")
  private List<Order> advertOrders;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(final String author) {
    this.author = author;
  }

  public List<Order> getAdvertOrders() {
    return advertOrders;
  }

  public void setAdvertOrders(final List<Order> advertOrders) {
    this.advertOrders = advertOrders;
  }
}
