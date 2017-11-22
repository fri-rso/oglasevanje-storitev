package si.jaklic.adverts;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService(value = "adverts-service", ttl = 20, pingInterval = 15, version = "1.0.0", singleton = false)
@ApplicationPath("/")
public class AdvertsApplication extends Application {
}
