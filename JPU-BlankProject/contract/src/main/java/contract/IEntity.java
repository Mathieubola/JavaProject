package contract;

public interface IEntity {

	boolean isPlayer();

	boolean isFalling();

	char getSprite();

	boolean isDigable();
	
	boolean isPushable();

	int update();

}
