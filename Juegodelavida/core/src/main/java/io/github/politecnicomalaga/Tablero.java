package io.github.politecnicomalaga;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Representa la rejilla del juego y contiene la lógica principal.
 */
public class Tablero {
    private Celda[][] rejilla;
    private int columnas, filas;
    private int anchoCelda, altoCelda;

    public Tablero(int columnas, int filas, int anchoPantalla, int altoPantalla) {
        this.columnas = columnas;
        this.filas = filas;
        this.anchoCelda = anchoPantalla / columnas;
        this.altoCelda = altoPantalla / filas;

        rejilla = new Celda[columnas][filas];
        for (int i = 0; i < columnas; i++) {
            for (int y = 0; y < filas; y++) {
                rejilla[i][y] = new Celda(i, y, anchoCelda, altoCelda);
            }
        }
    }

    // Dibuja el tablero completo, célula por célula
    public void dibujar(ShapeRenderer shapeRenderer) {
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                rejilla[x][y].dibujar(shapeRenderer);
            }
        }
    }

    // Método para inicializar el tablero con un patrón aleatorio
    public void inicializarAleatoriamente() {
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                if (Math.random() > 0.7) { // 30% de probabilidad de que una célula empiece viva
                    rejilla[x][y].setEstaViva(true);
                }
            }
        }
    }

    // Actualizar el tablero
    public void actualizar() {
        // 1. Crea una nueva rejilla temporal para guardar los nuevos estados.
        boolean[][] nuevoEstado = new boolean[columnas][filas];


        for (int i = 0; i < columnas; i++) {
            for (int y = 0; y < filas; y++) {
                int vecinosVivos = contarVecinosVivos(i, y);
                boolean estadoActual = rejilla[i][y].getEstaViva();


                if (estadoActual && (vecinosVivos < 2 || vecinosVivos > 3)) {
                    nuevoEstado[i][y] = false;
                } else if (!estadoActual && vecinosVivos == 3) {
                    nuevoEstado[i][y] = true;
                } else {
                    nuevoEstado[i][y] = estadoActual;
                }
            }
        }


        for (int i = 0; i < columnas; i++) {
            for (int y = 0; y < filas; y++) {
                rejilla[i][y].setEstaViva(nuevoEstado[i][y]);
            }
        }
    }

    private int contarVecinosVivos(int x, int y) {
        int contador = 0;
        // Itera sobre las 8 células vecinas
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // No contarse a sí misma
                }
                int vecinoX = (x + i + columnas) % columnas; // Usamos módulo para un tablero "infinito"
                int vecinoY = (y + j + filas) % filas;

                if (rejilla[vecinoX][vecinoY].getEstaViva()) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
