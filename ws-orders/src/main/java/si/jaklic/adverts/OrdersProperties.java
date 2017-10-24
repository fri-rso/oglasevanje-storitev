package si.jaklic.adverts;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

import javax.enterprise.context.ApplicationScoped;

@ConfigBundle("orders")
@ApplicationScoped
public class OrdersProperties {
  private String catalogueUrl = "http://localhost:3000";

  public String getCatalogueUrl() {
    return catalogueUrl;
  }

  public void setCatalogueUrl(final String catalogueUrl) {
    this.catalogueUrl = catalogueUrl;
  }
}
