package ch.tkuhn.cougaar.test;

import org.cougaar.core.blackboard.IncrementalSubscription;
import org.cougaar.core.plugin.AnnotatedSubscriptionsPlugin;
import org.cougaar.core.service.BlackboardService;
import org.cougaar.util.UnaryPredicate;

public class Agent extends AnnotatedSubscriptionsPlugin implements Locatable {

	private int posX, posY;
	private BlackboardService bbs;
	private IncrementalSubscription<?> nearbyFoodSubscription; 

	private UnaryPredicate<?> nearbyFoodPredicate;

	@Override
	public void load() {
		super.load();

		posX = (int) getParameter("posX", 0);
		posY = (int) getParameter("posY", 0);

		// Blackboard only works within the same agent...
		bbs = getBlackboardService();

		log.shout("Hi!");
		log.shout("I am at " + posX + "," + posY);
	}

	@Override
	public void execute() {
		super.execute();
		if (nearbyFoodSubscription.hasChanged()) {
			for (Object obj : nearbyFoodSubscription.getAddedCollection()) {
				if (!(obj instanceof Food)) continue;
				log.shout("Yummi!");
			}
		}
	}

	@Override
	public void unload() {
		super.unload();
		log.shout("Byebye!");
	}

	@Override
	protected void setupSubscriptions() {

		nearbyFoodPredicate = new UnaryPredicate<Object>() {

			private static final long serialVersionUID = 8822584339571541316L;

			@Override
			public boolean execute(Object obj) {
				if (obj instanceof Food) {
					return Utils.areNear(Agent.this, (Food) obj);
				} else {
					return false;
				}
			}
		};

		nearbyFoodSubscription = (IncrementalSubscription<?>) bbs.subscribe(nearbyFoodPredicate);
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
