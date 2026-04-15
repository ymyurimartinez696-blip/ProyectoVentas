package proyectoventas;
import java.io.*;
import java.util.*;

/**
 * Clase principal que procesa los archivos de ventas
 */
public class Main {

    public static void main(String[] args) {

        // Mapas para almacenar información
        Map<String, Integer> totalVendedores = new HashMap<>();
        Map<String, Integer> totalProductos = new HashMap<>();
        Map<String, Integer> precios = new HashMap<>();

        try {
            // =========================
            // 1. LEER ARCHIVO PRODUCTOS
            // =========================
            BufferedReader brProductos = new BufferedReader(new FileReader("productos.txt"));
            String linea;

            while ((linea = brProductos.readLine()) != null) {
                String[] datos = linea.split(";");
                precios.put(datos[0], Integer.parseInt(datos[2]));
            }
            brProductos.close();

            // =========================
            // 2. LEER ARCHIVOS DE VENTAS
            // =========================
            File carpeta = new File(".");
            File[] archivos = carpeta.listFiles();

            for (File archivo : archivos) {

                if (archivo.getName().startsWith("ventas_")) {

                    BufferedReader br = new BufferedReader(new FileReader(archivo));
                    String primeraLinea = br.readLine();

                    String[] vendedorData = primeraLinea.split(";");
                    String idVendedor = vendedorData[1];

                    int totalVenta = 0;

                    // =========================
                    // 3. PROCESAR CADA VENTA
                    // =========================
                    while ((linea = br.readLine()) != null) {

                        String[] datos = linea.split(";");
                        String idProducto = datos[0];
                        int cantidad = Integer.parseInt(datos[1]);

                        int precio = precios.getOrDefault(idProducto, 0);
                        int subtotal = precio * cantidad;

                        totalVenta += subtotal;

                        totalProductos.put(idProducto,
                                totalProductos.getOrDefault(idProducto, 0) + cantidad);
                    }

                    totalVendedores.put(idVendedor, totalVenta);
                    br.close();
                }
            }

            // =========================
            // 4. ORDENAR VENDEDORES
            // =========================
            List<Map.Entry<String, Integer>> listaVendedores =
                    new ArrayList<>(totalVendedores.entrySet());

            listaVendedores.sort((a, b) -> b.getValue() - a.getValue());

            // =========================
            // 5. CREAR REPORTE VENDEDORES
            // =========================
            FileWriter writerVendedores = new FileWriter("reporte_vendedores.csv");

            for (Map.Entry<String, Integer> entry : listaVendedores) {
                writerVendedores.write("Vendedor " + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            writerVendedores.close();

            // =========================
            // 6. ORDENAR PRODUCTOS
            // =========================
            List<Map.Entry<String, Integer>> listaProductos =
                    new ArrayList<>(totalProductos.entrySet());

            listaProductos.sort((a, b) -> b.getValue() - a.getValue());

            // =========================
            // 7. CREAR REPORTE PRODUCTOS
            // =========================
            FileWriter writerProductos = new FileWriter("reporte_productos.csv");

            for (Map.Entry<String, Integer> entry : listaProductos) {
                writerProductos.write("Producto " + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            writerProductos.close();

            System.out.println("✔ Reportes generados correctamente");

        } catch (Exception e) {
            System.out.println("❌ Error en el procesamiento");
        }
    }
}