package contract;

public interface IViewPanel {

	void setScore(int score);

	void repaint();

	void setEntitys(IEntity[][] entitys);

	void setDirection(ControllerOrder controllerOrder);

}
