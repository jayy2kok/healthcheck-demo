package com.healthcheck.example.healthcheckdemo.health;

import java.util.UUID;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
@ConditionalOnEnabledHealthIndicator("service")
public class ServiceHealthIndicator implements ReactiveHealthIndicator {
    // @Autowired
    // private ServerWebExchange exchange;

    private String site = "local";

    @Override
    public Mono<Health> health() {
        return Mono.fromSupplier(() -> {
            Health.Builder status = Health.status("local-UP").withDetail("uuid", UUID.randomUUID());
            return status.build();
        });
    }

}
