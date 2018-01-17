package si.jaklic.adverts;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class OrdersHealthCheck implements HealthCheck {
    private static final Logger LOG = Logger.getLogger(OrdersHealthCheck.class.getSimpleName());

    @Override
    public HealthCheckResponse call() {
        try {
            ConfigurationUtil configurationUtil = ConfigurationUtil.getInstance();
            String url = configurationUtil.get("orders.orders-url").orElse("");

            HttpURLConnection connection = (HttpURLConnection) new URL(url + "/orders").openConnection();
            connection.setRequestMethod("HEAD");

            if (connection.getResponseCode() == 200) {
                return HealthCheckResponse.named(OrdersHealthCheck.class.getSimpleName()).up().build();
            }
        } catch (Exception exception) {
            LOG.severe(exception.getMessage());
        }

        return HealthCheckResponse.named(OrdersHealthCheck.class.getSimpleName()).down().build();
    }
}