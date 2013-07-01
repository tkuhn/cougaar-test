package ch.tkuhn.cougaar.test;

import org.cougaar.core.plugin.AnnotatedSubscriptionsPlugin;

public class Food extends AnnotatedSubscriptionsPlugin implements Locatable {

	private int posX, posY;

	@Override
	public void load() {
		super.load();
		this.posX = (int) getParameter("posX", 0);
		this.posY = (int) getParameter("posY", 0);
	}

	@Override
	protected void execute() {
		super.execute();
		log.shout("There is food at " + posX + "," + posY);
		// Blackboard only works within the same agent...
		getBlackboardService().publishAdd(this);
	}

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}

}
