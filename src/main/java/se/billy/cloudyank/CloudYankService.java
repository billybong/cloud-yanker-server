package se.billy.cloudyank;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import se.billy.cloudyank.config.YankConfiguration;
import se.billy.cloudyank.healthcheck.YankerHealthCheck;
import se.billy.cloudyank.resource.SnippetResource;

public class CloudYankService extends Service<YankConfiguration>{

    public static void main(String[] args) throws Exception{
        new CloudYankService().run(args);
    }

    @Override
    public void initialize(Bootstrap<YankConfiguration> bootstrap) {
        bootstrap.setName("CloudYanker");
    }

    @Override
    public void run(YankConfiguration configuration, Environment environment) throws Exception {
        environment.addHealthCheck(new YankerHealthCheck("cloudYanker"));
        environment.addResource(new SnippetResource());
    }
}