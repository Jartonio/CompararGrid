package com.example.comparargrid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final double MIN_LATITUDE = -90.0;
    private static final double MAX_LATITUDE = 90.0;

    private static final double MIN_LONGITUDE = -180.0;
    private static final double MAX_LONGITUDE = 180.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        main();
    }


    public static double latitudAleatoria() {
        Random random = new Random();
        return MIN_LATITUDE + (MAX_LATITUDE - MIN_LATITUDE) * random.nextFloat();
    }

    public static double longitudAleatoria() {
        Random random = new Random();
        return MIN_LONGITUDE + (MAX_LONGITUDE - MIN_LONGITUDE) * random.nextFloat();

    }

    private String calcularGrid(double longitud, double latitud) {

        //Este metodo calcula el Grid Locator de Maidenhead a partir de una latitud y una tlongiud.
        //Entrega un Grid en formato: AA00AA00AA00 (18x10x24x10x24x10).

        double miLongitud = longitud + 180;
        double miLatitud = latitud + 90;

        double grados, totalCuadros, ultimo, diferenciaCuadros;
        int cuadrosAnteriores, numeroGrid, divisiones;

        char[] grid = new char[12];

        // longitud cuadricula 1
        divisiones = 18;
        grados = 360f / divisiones;
        totalCuadros = miLongitud / grados;
        numeroGrid = (int) totalCuadros;
        grid[0] = (char) ('A' + numeroGrid);
        ultimo = totalCuadros;

        //longitud cuadricula 2
        divisiones = 10;
        grados = grados / divisiones;
        totalCuadros = miLongitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[2] = (char) ('0' + numeroGrid);
        ultimo = totalCuadros;

        //longitud cuadricula 3
        divisiones = 24;
        grados = grados / divisiones;

        totalCuadros = miLongitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[4] = (char) ('A' + numeroGrid);
        ultimo = totalCuadros;

        //longitud cuadricula 4
        divisiones = 10;
        grados = grados / divisiones;
        totalCuadros = miLongitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[6] = (char) ('0' + numeroGrid);
        ultimo = totalCuadros;

        //longitud cuadricula 5
        divisiones = 24;
        grados = grados / divisiones;
        totalCuadros = miLongitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[8] = (char) ('A' + numeroGrid);
        ultimo = totalCuadros;

        //longitud cuadricula 6
        divisiones = 10;
        grados = grados / divisiones;
        totalCuadros = miLongitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[10] = (char) ('0' + numeroGrid);


        // latitud cadricula 1
        divisiones = 18;
        grados = 180f / divisiones;
        totalCuadros = miLatitud / grados;
        numeroGrid = (int) totalCuadros;
        grid[1] = (char) ('A' + numeroGrid);
        ultimo = totalCuadros;

        //latitud cuadricula 2
        divisiones = 10;
        grados = grados / divisiones;
        totalCuadros = miLatitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[3] = (char) ('0' + numeroGrid);
        ultimo = totalCuadros;

        //latitud cuadricula 3
        divisiones = 24;
        grados = grados / divisiones;
        totalCuadros = miLatitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[5] = (char) ('A' + numeroGrid);
        ultimo = totalCuadros;

        //latitud cuadricula 4
        divisiones = 10;
        grados = grados / divisiones;
        totalCuadros = miLatitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[7] = (char) ('0' + numeroGrid);
        ultimo = totalCuadros;

        //latitud cuadricula 5
        divisiones = 24;
        grados = grados / divisiones;
        totalCuadros = miLatitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[9] = (char) ('A' + numeroGrid);
        ultimo = totalCuadros;

        //latitud cuadricula 6
        divisiones = 10;
        grados = grados / divisiones;
        totalCuadros = miLatitud / grados;
        cuadrosAnteriores = ((int) (ultimo)) * divisiones;
        diferenciaCuadros = totalCuadros - cuadrosAnteriores;
        numeroGrid = (int) diferenciaCuadros;
        grid[11] = (char) ('0' + numeroGrid);

        System.out.println("YO:  " + String.valueOf(grid));
        return String.valueOf(grid);
    }


    public void main() {
        long numCoordinates = 1000;
        String resultadoGrid;
        String resultadoGridGPT;
        int diferencias = 0;

        // Generar 1000 pares de latitudes y longitudes
        Random random = new Random();
        System.out.println("Procesando " + numCoordinates + " combinaciones.........");

        for (int i = 0; i < numCoordinates; i++) {
            // Generar latitud entre -90 y 90
            double latitud = latitudAleatoria();
            // Generar longitud entre -180 y 180
            double longitud = longitudAleatoria();

            // Calcular grid con ambas funciones
            resultadoGrid = calcularGrid(longitud, latitud);
            resultadoGridGPT = calcularGridGPT(longitud, latitud);


            // Comparar resultados
            if (!resultadoGrid.equals(resultadoGridGPT)) {
                diferencias++;
            }
        }

        // Visualizar el total de diferencias
        System.out.println("Total de diferencias: " + diferencias);
    }

    private String calcularGridGPT(double longitud, double latitud) {
        // Ajustamos longitud y latitud para que estén en un rango positivo
        double miLongitud = longitud + 180;
        double miLatitud = latitud + 90;

        int[] divisiones = {18, 10, 24, 10, 24, 10};  // Divisiones de cada cuadrícula
        char[] grid = new char[12];  // Resultado final del Grid

        // Variables temporales de grados y cuadros previos para longitud y latitud
        double gradosLongitud = 360.0;
        double gradosLatitud = 180.0;
        double ultimoLongitud = 0, ultimoLatitud = 0;

        // Cálculo para cada par de coordenadas (longitud-latitud) en cada nivel
        for (int i = 0; i < divisiones.length; i++) {
            // Actualizamos el valor de grados para este nivel de división
            gradosLongitud /= divisiones[i];
            gradosLatitud /= divisiones[i];

            // Cálculo del carácter de grid para longitud
            int numeroGridLongitud = (int) (miLongitud / gradosLongitud);
            int cuadrosAnterioresLongitud = ((int) (ultimoLongitud)) * divisiones[i];
            int diferenciaCuadrosLongitud = numeroGridLongitud - cuadrosAnterioresLongitud;
            grid[i * 2] = (char) ((i % 2 == 0 ? 'A' : '0') + diferenciaCuadrosLongitud);
            ultimoLongitud = numeroGridLongitud;

            // Cálculo del carácter de grid para latitud
            int numeroGridLatitud = (int) (miLatitud / gradosLatitud);
            int cuadrosAnterioresLatitud = ((int) (ultimoLatitud)) * divisiones[i];
            int diferenciaCuadrosLatitud = numeroGridLatitud - cuadrosAnterioresLatitud;
            grid[i * 2 + 1] = (char) ((i % 2 == 0 ? 'A' : '0') + diferenciaCuadrosLatitud);
            ultimoLatitud = numeroGridLatitud;
        }

        System.out.println("GPT: " + String.valueOf(grid));
        return String.valueOf(grid);
    }
}