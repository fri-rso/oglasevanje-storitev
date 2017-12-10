package si.jaklic.adverts;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService(value = "ws-adverts", ttl = 20, environment = "dev")
@ApplicationPath("/")
public class AdvertsApplication extends Application {
}
