package si.jaklic.adverts;

import com.kumuluz.ee.health.HealthRegistry;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.util.AnnotationLiteral;
import java.util.Set;

/**
 * Health check registration class.
 *
 * @author Marko Škrjanec
 * @since 1.0.0
 */
public class HealthCheckInitializationExtension implements Extension {
    public <T> void registerHealthChecks(@Observes @Initialized(ApplicationScoped.class) Object init, BeanManager
            beanManager) {

        // register classes that implement health checks
        // ConfigurationUtil configurationUtil = ConfigurationUtil.getInstance();
        HealthRegistry healthCheckRegistry = HealthRegistry.getInstance();

        // healthCheckRegistry.register(GithubHealthCheck.class.getSimpleName(), new GithubHealthCheck());
        healthCheckRegistry.register(OrdersHealthCheck.class.getSimpleName(), new OrdersHealthCheck());
        healthCheckRegistry.register(AdvertsHealthCheck.class.getSimpleName(), new AdvertsHealthCheck());

        Set<Bean<?>> beans = beanManager.getBeans(HealthCheck.class, new AnnotationLiteral<Health>() {});

        for (Bean bean : beans) {
            HealthCheck healthCheckBean = (HealthCheck) beanManager.getReference(bean, HealthCheck.class,
                    beanManager.createCreationalContext(bean));
            HealthRegistry.getInstance().register(bean.getBeanClass().getSimpleName(), healthCheckBean);
        }
    }
}