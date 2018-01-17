package si.jaklic.adverts;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.inject.Inject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class AdvertsHealthCheck implements HealthCheck {
    private static final Logger LOG = Logger.getLogger(AdvertsHealthCheck.class.getSimpleName());

    @Inject
    private OrdersProperties ordersProperties;

    @Override
    public HealthCheckResponse call() {
        try {
            String url = ordersProperties.getAdvertsUrl();
            HttpURLConnection connection = (HttpURLConnection) new URL(url + "/adverts").openConnection();
            connection.setRequestMethod("HEAD");

            if (connection.getResponseCode() == 200) {
                return HealthCheckResponse.named(AdvertsHealthCheck.class.getSimpleName()).up().build();
            }
        } catch (Exception exception) {
            LOG.severe(exception.getMessage());
        }

        return HealthCheckResponse.named(AdvertsHealthCheck.class.getSimpleName()).down().build();
    }
}