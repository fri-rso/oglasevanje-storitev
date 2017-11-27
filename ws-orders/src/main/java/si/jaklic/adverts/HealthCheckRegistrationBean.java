package si.jaklic.adverts;

import com.kumuluz.ee.health.HealthRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class HealthCheckRegistrationBean {

    private void initialize(@Observes @Initialized(ApplicationScoped.class) Object init) {
        HealthRegistry.getInstance().register(GithubHealthCheck.class.getSimpleName(), new GithubHealthCheck());
    }

    private void cleanup(@Observes @Destroyed(ApplicationScoped.class) Object init) {
    }
}