package org.taymyr.lagom.name.api;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

public interface NameService extends Service {

    ServiceCall<NotUsed, String> name();

    @Override
    default Descriptor descriptor() {
        return named("name")
            .withCalls(
                    pathCall("/name", this::name)
            ).withAutoAcl(true);
    }
}
