package com.example.helloworld.cli

import com.example.helloworld.HelloWorldConfiguration;
import com.google.common.base.Optional;
import com.yammer.dropwizard.cli.ConfiguredCommand;
import com.yammer.dropwizard.config.Bootstrap;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: kboon
 * Date: 11/14/12
 */
class RenderCommand extends ConfiguredCommand<HelloWorldConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RenderCommand.class);

    public RenderCommand() {
        super("render", "Render the template data to console");
    }

    @Override
    public void configure(Subparser subparser) {
        super.configure(subparser);
        subparser.addArgument("-i", "--include-default")
                .action(Arguments.storeTrue())
                .dest("include-default")
                .help("Also render the template with the default name");
        subparser.addArgument("names").nargs("*");
    }

    @Override
    protected void run(Bootstrap<HelloWorldConfiguration> bootstrap,
                       Namespace namespace,
                       HelloWorldConfiguration configuration) throws Exception {

    }
}