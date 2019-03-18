package Factory;

import Bouncer.*;

abstract class ShapeFactory {
    public abstract Circle createCircle(int maxPosX, int maxPosY, int maxSize);
    public abstract Square createSquare(int maxPosX, int maxPosY, int maxSize);
}
