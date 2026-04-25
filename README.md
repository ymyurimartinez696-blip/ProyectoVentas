 Proyecto de Ventas - Java



Este proyecto en Java permite generar y procesar archivos de ventas, vendedores y productos, creando reportes automáticos en formato CSV.

---

Funcionalidades:

* Generación automática de archivos de prueba
* Lectura de archivos de ventas (`ventas_*.txt`)
* Cálculo de ventas por vendedor
* Cálculo de productos más vendidos
* Generación de reportes:

  * `reporte_vendedores.csv`
  * `reporte_productos.csv`

---

¿Cómo ejecutar el proyecto?

1. Ejecutar primero:

```
GenerateInfoFiles.java
```

2. Luego ejecutar:

```
Main.java
```

---

Estructura del proyecto:

```
src/
 └── proyectoventas/
     ├── Main.java
     ├── GenerateInfoFiles.java
     ├── Producto.java
     └── Conexion.java
```

---

Archivos utilizados:

* `productos.txt`
* `vendedores.txt`
* `ventas_1.txt` ... `ventas_5.txt`

---

Resultados:

El programa genera automáticamente:

* Reporte de vendedores ordenado por ventas
* Reporte de productos más vendidos

Proyecto académico - Programación en Java

