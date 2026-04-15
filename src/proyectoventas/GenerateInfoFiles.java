package proyectoventas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Clase que genera archivos de prueba
 */
public class GenerateInfoFiles {

    /**
     * Genera archivo de productos
     */
    public static void createProductsFile(int productsCount) {
        try {
            FileWriter writer = new FileWriter("productos.txt");
            Random random = new Random();

            for (int i = 1; i <= productsCount; i++) {
                int precio = random.nextInt(100) + 1;
                writer.write(i + ";Producto" + i + ";" + precio + "\n");
            }

            writer.close();
            System.out.println("✔ productos.txt creado");

        } catch (IOException e) {
            System.out.println("❌ Error creando productos");
        }
    }

    /**
     * Genera archivo de vendedores
     */
    public static void createSalesManInfoFile(int salesmanCount) {
        try {
            FileWriter writer = new FileWriter("vendedores.txt");

            for (int i = 1; i <= salesmanCount; i++) {
                writer.write("CC;" + i + ";Nombre" + i + ";Apellido" + i + "\n");
            }

            writer.close();
            System.out.println("✔ vendedores.txt creado");

        } catch (IOException e) {
            System.out.println("❌ Error creando vendedores");
        }
    }

    /**
     * Genera archivo de ventas por vendedor
     */
    public static void createSalesMenFile(int randomSalesCount, long id) {
        try {
            FileWriter writer = new FileWriter("ventas_" + id + ".txt");
            Random random = new Random();

            writer.write("CC;" + id + "\n");

            for (int i = 0; i < randomSalesCount; i++) {
                int producto = random.nextInt(10) + 1;
                int cantidad = random.nextInt(5) + 1;

                writer.write(producto + ";" + cantidad + "\n");
            }

            writer.close();
            System.out.println("✔ ventas_" + id + ".txt creado");

        } catch (IOException e) {
            System.out.println("❌ Error creando ventas_" + id);
        }
    }

    /**
     * Método principal
     */
    public static void main(String[] args) {

        System.out.println("=== GENERANDO ARCHIVOS ===");

        createProductsFile(10);
        createSalesManInfoFile(5);

        for (int i = 1; i <= 5; i++) {
            createSalesMenFile(5, i);
        }

        System.out.println("=== ARCHIVOS GENERADOS ===");
    }
}