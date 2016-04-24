import java.awt.event.KeyEvent;

/**
 * Méthode permettant de récupérer un évènement clavier.
 * @author M2105-Team
 *
 */

public class MyKeyEvent implements Event {

	private KeyEvent keyEvent = null ;
	@Override
	public int getEventType() {
		return Event.KEY_EVENT ;
	}
	public KeyEvent getKeyEvent() {
		return keyEvent;
	}
	public MyKeyEvent(KeyEvent keyEvent) {
		super();
		this.keyEvent = keyEvent;
	}

}
