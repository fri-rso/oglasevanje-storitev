package si.jaklic.adverts;

import si.jaklic.adverts.models.Advert;

import javax.persistence.*;
import java.util.Date;

public class RelatedOrder {
    private Integer id;

    public RelatedOrder(Integer id, Date orderDate, Integer quantity, Integer advert_id, String advert_title, String advert_description, String advert_author) {
        this.id = id;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.advert_id = advert_id;
        this.advert_title = advert_title;
        this.advert_description = advert_description;
        this.advert_author = advert_author;
    }

    private Date orderDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAdvert_id() {
        return advert_id;
    }

    public void setAdvert_id(Integer advert_id) {
        this.advert_id = advert_id;
    }

    public String getAdvert_title() {
        return advert_title;
    }

    public void setAdvert_title(String advert_title) {
        this.advert_title = advert_title;
    }

    public String getAdvert_description() {
        return advert_description;
    }

    public void setAdvert_description(String advert_description) {
        this.advert_description = advert_description;
    }

    public String getAdvert_author() {
        return advert_author;
    }

    public void setAdvert_author(String advert_author) {
        this.advert_author = advert_author;
    }

    private Integer quantity;

    private Integer advert_id;

    private String advert_title;

    private String advert_description;

    private String advert_author;


}
