package ch.tkuhn.cougaar.test;

import org.cougaar.core.plugin.AnnotatedSubscriptionsPlugin;

public class TestPlugin extends AnnotatedSubscriptionsPlugin {

	@Override
	public void execute() {
		super.execute();
		log.shout("Hello World!");
	}

}
