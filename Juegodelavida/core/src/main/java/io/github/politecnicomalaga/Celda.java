
package io.github.politecnicomalaga;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Representa una única célula en el Juego de la Vida.
 */
public class Celda {
    private boolean estaViva;
    private final int posX, posY;
    private final int ancho, alto;

    public Celda(int posX, int posY, int ancho, int alto) {
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
        this.estaViva = false;
    }

    public void dibujar(ShapeRenderer shapeRenderer) {
        if (estaViva) {
            shapeRenderer.setColor(0.1f, 0.9f, 0.2f, 1); // Color para célula viva
        } else {
            shapeRenderer.setColor(0.2f, 0.2f, 0.2f, 1); // Color para célula muerta
        }
        shapeRenderer.rect(posX * ancho, posY * alto, ancho, alto);

        // También dibujamos el borde para que la rejilla sea visible
        shapeRenderer.setColor(0.4f, 0.4f, 0.4f, 1); // Color del borde (gris)
        shapeRenderer.rectLine(posX * ancho, posY * alto, posX * ancho + ancho, posY * alto, 2);
        shapeRenderer.rectLine(posX * ancho, posY * alto, posX * ancho, posY * alto + alto, 2);

    }

    public boolean getEstaViva() {
        return estaViva;
    }

    public void setEstaViva(boolean estaViva) {
        this.estaViva = estaViva;
    }
}

