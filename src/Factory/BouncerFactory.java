/**
 * @file BouncerFactory.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */

package Factory;

import Bouncer.*;

/**
 * Factory Abstraite, elle defini qu'elle peut construire des Objet Cercle et carré
 */
abstract class BouncerFactory {
    public abstract Circle createCircle(int maxPosX, int maxPosY, int maxSize);
    public abstract Square createSquare(int maxPosX, int maxPosY, int maxSize);
}
