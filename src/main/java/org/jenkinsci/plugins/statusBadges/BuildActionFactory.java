package org.jenkinsci.plugins.statusBadges;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BallColor;
import hudson.model.TransientProjectActionFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

@Extension
public class BuildActionFactory extends TransientProjectActionFactory {

    private final ImageResolver iconResolver;

    public BuildActionFactory() {
        iconResolver = new ImageResolver();
    }

    @Override
    public Collection<? extends Action> createFor(AbstractProject target) {
        return Collections.singleton(new BuildAction(this,target));
    }

    public StatusImage getImage(BallColor color) throws IOException {
        return iconResolver.getImage(color);
    }

}
