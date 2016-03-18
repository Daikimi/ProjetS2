import java.awt.event.MouseEvent;

public class MyMouseEvent implements Event {

	private int x ;
	private int y ;
	private MouseEvent mouseEvent ;
	public MyMouseEvent(int x, int y, MouseEvent mouseEvent) {
		super();
		this.x = x;
		this.y = y;
		this.mouseEvent = mouseEvent ;
	}
	@Override
	public int getEventType() {
		return Event.MOUSE_EVENT ;
	}
	public int getX() { return x ; } ;
	public int getY() { return y ; } ;
	public MouseEvent getmouseEvent() { return mouseEvent ; }
	@Override
	public String toString() {
		return "MyMouseEvent [x=" + x + ", y=" + y + ", mouseEvent="
				+ mouseEvent + "]";
	}
}
