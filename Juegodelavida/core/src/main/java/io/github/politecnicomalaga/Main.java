package io.github.politecnicomalaga;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private Tablero tablero;

    // Velocidad
    private float tiempoDesdeUltimaActualizacion = 0f;
    private final float TIEMPO_DE_ACTUALIZACION = 0.1f; // 10 actualizaciones

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        int anchoPantalla = Gdx.graphics.getWidth();
        int altoPantalla = Gdx.graphics.getHeight();

        // Crear un tablero de 40x30 celdas
        tablero = new Tablero(40, 30, anchoPantalla, altoPantalla);
        tablero.inicializarAleatoriamente(); // Darle un estado inicial
    }

    @Override
    public void render() {
        // Limpiar la pantalla
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Actualizar la lógica del juego a intervalos de tiempo fijos
        tiempoDesdeUltimaActualizacion += Gdx.graphics.getDeltaTime();
        if (tiempoDesdeUltimaActualizacion >= TIEMPO_DE_ACTUALIZACION) {
            tablero.actualizar();
            tiempoDesdeUltimaActualizacion = 0f;
        }

        // Dibujar el tablero
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        tablero.dibujar(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
