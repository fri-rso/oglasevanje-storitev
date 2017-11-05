package si.jaklic.adverts;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

import javax.enterprise.context.ApplicationScoped;

@ConfigBundle("orders")
@ApplicationScoped
public class OrdersProperties {
  private String advertsUrl = "http://localhost:8080";

  public String getAdvertsUrl() {
    return advertsUrl;
  }

  public void setAdvertsUrl(final String advertsUrl) {
    this.advertsUrl = advertsUrl;
  }
}
