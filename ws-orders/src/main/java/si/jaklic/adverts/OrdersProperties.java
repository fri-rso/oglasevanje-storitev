package si.jaklic.adverts;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;
import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ConfigBundle("orders")
@ApplicationScoped
public class OrdersProperties {
  @ConfigValue(watch = true)
  private String webPageTitle;

  @ConfigValue(watch = true)
  private String advertsUrl;

  @ConfigValue(watch = true)
  private String ordersUrl;

  @ConfigValue(watch = true)
  private String commentsUrl;

  @ConfigValue(watch = true)
  private String profilesUrl;

  @ConfigValue(watch = true)
  private String cartUrl;

  @ConfigValue(watch = true)
  private String servicesUrl;


  public String getWebPageTitle() {
    return webPageTitle;
  }

  public void setWebPageTitle(String webPageTitle) {
    this.webPageTitle = webPageTitle;
  }

  public String getAdvertsUrl() {
    return advertsUrl;
  }

  public void setAdvertsUrl(String advertsUrl) {
    this.advertsUrl = advertsUrl;
  }


  public String getOrdersUrl() {
    return ordersUrl;
  }

  public void setOrdersUrl(String ordersUrl) {
    this.ordersUrl = ordersUrl;
  }

  public String getCommentsUrl() {
    return commentsUrl;
  }

  public void setCommentsUrl(String commentsUrl) {
    this.commentsUrl = commentsUrl;
  }

  public String getProfilesUrl() {
    return profilesUrl;
  }

  public void setProfilesUrl(String profilesUrl) {
    this.profilesUrl = profilesUrl;
  }

  public String getCartUrl() {
    return cartUrl;
  }

  public void setCartUrl(String cartUrl) {
    this.cartUrl = cartUrl;
  }

  public String getServicesUrl() {
    return servicesUrl;
  }

  public void setServicesUrl(String servicesUrl) {
    this.servicesUrl = servicesUrl;
  }
}
