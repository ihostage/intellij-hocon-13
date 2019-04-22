package org.taymyr.lagom.name;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.taymyr.lagom.name.api.NameService;

import java.util.Random;

import static java.util.concurrent.CompletableFuture.completedFuture;

public class NameServiceImpl implements NameService {

    private final Logger log = LoggerFactory.getLogger(NameServiceImpl.class);

    private static final String[] NAMES = {
            "Oliver", "Jack", "Harry", "Jacob", "Charlie", "Thomas", "George", "Oscar", "Oscar", "William",
            "Amelia", "Olivia", "Isla", "Emily", "Poppy", "Ava", "Isabella", "Jessica", "Lily", "Sophie"
    };

    private final Random random = new Random();

    @Override
    public ServiceCall<NotUsed, String> name() {
        return request -> {
            String name = NAMES[random.nextInt(NAMES.length)];
            log.info("Name: {}", name);
            return completedFuture(name);
        };
    }

}
