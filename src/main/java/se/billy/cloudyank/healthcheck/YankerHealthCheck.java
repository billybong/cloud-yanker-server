package se.billy.cloudyank.healthcheck;

import com.yammer.metrics.core.HealthCheck;

public class YankerHealthCheck extends HealthCheck {

    public YankerHealthCheck(String name) {
        super(name);
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy("Ready to yank!");
    }

}