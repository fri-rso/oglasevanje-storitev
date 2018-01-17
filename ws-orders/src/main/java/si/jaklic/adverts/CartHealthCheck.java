package si.jaklic.adverts;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.inject.Inject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class CartHealthCheck implements HealthCheck {
    private static final Logger LOG = Logger.getLogger(CartHealthCheck.class.getSimpleName());

    @Inject
    private OrdersProperties ordersProperties;

    @Override
    public HealthCheckResponse call() {
        try {
            String url = ordersProperties.getCartUrl();
            HttpURLConnection connection = (HttpURLConnection) new URL(url + "/cart").openConnection();
            connection.setRequestMethod("HEAD");

            if (connection.getResponseCode() == 200) {
                return HealthCheckResponse.named(CartHealthCheck.class.getSimpleName()).up().build();
            }
        } catch (Exception exception) {
            LOG.severe(exception.getMessage());
        }

        return HealthCheckResponse.named(CartHealthCheck.class.getSimpleName()).down().build();
    }
}