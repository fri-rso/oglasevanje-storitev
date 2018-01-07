package si.jaklic.adverts;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ConfigBundle("orders")
@ApplicationScoped
public class OrdersProperties {

  private String advertsUrl = "http://localhost:8080";

  @ConfigValue(watch = true)
  private String stringProperty;

  public String getAdvertsUrl() {
    return advertsUrl;
  }

  public void setAdvertsUrl(final String advertsUrl) {
    this.advertsUrl = advertsUrl;

  }

  public String getStringProperty() {
    return stringProperty;
  }

  public void setStringProperty(String stringProperty) {
    this.stringProperty = stringProperty;
  }
}
