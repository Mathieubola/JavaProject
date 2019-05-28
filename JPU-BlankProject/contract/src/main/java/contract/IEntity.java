package contract;

public interface IEntity {

	boolean isPlayer();

	boolean isFalling();

	char getSprite();

	boolean isDigable();

	int update();

}
