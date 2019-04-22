package org.taymyr.lagom.name;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import org.taymyr.lagom.name.api.NameService;

public class NameModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {
        bindService(NameService.class, NameServiceImpl.class);
    }
}
