# Sistema de Gestión de Dispositivos Electrónicos (PROG05)

Este proyecto es una aplicación de consola desarrollada en Java como tarea final de la unidad **PROG05**. El sistema permite gestionar un inventario de dispositivos electrónicos y registrar sus sesiones de uso, calculando estadísticas de rendimiento y consumo.

## 🚀 Características

- **Gestión de Inventario**: Permite dar de alta hasta 30 dispositivos electrónicos con un código único, nombre y tipo.
- **Registro de Sesiones**: Posibilidad de añadir múltiples sesiones de uso a cada dispositivo, registrando:
  - Horas de uso.
  - Consumo de batería (%).
  - Temperatura máxima alcanzada.
- **Estadísticas Detalladas**:
  - Consulta de información individual por dispositivo (medias de consumo, temperatura y total de horas).
  - Listado completo de dispositivos registrados.
  - Estadísticas globales: Media de consumo de todos los dispositivos e identificación del dispositivo más usado.
- **Robustez**: Validación de entradas mediante expresiones regulares (Regex) y control de excepciones (try-catch) para evitar cierres inesperados.

## 🛠️ Tecnologías y Estructuras de Datos

El proyecto implementa diversos conceptos avanzados de programación en Java:

- **Arrays Estáticos**: Uso de un array de tamaño fijo (30) para el almacenamiento principal del inventario (`AlmacenDispositivos`).
- **ArrayList (Estructuras Dinámicas)**: Cada dispositivo gestiona su historial de sesiones mediante una lista dinámica.
- **HashMap**: Implementación de un índice por código para búsquedas rápidas de dispositivos.
- **POO (Programación Orientada a Objetos)**: Uso de encapsulación, constructores sobrecargados, métodos `toString`, `equals` y `hashCode`.
- **Validación de Datos**: Clase de utilidades con patrones Regex para asegurar la integridad de la información introducida.

## 📁 Estructura del Proyecto

- `Principal.java`: Clase de entrada que contiene el menú interactivo y la lógica de interfaz de usuario.
- `AlmacenDispositivos.java`: Gestor del inventario que combina arrays y HashMaps.
- `Dispositivo.java`: Representa un dispositivo electrónico y gestiona sus sesiones de uso.
- `SesionUso.java`: Clase que almacena los datos de una sesión individual.
- `Utilidades.java`: Métodos estáticos para la validación de strings y números.


## 💻 Instrucciones de Ejecución

1. Asegúrate de tener instalado el **JDK 8** o superior.
2. Compila los archivos `.java`:
   ```bash
   javac -encoding UTF-8 Principal.java
   ```
3. Ejecuta la aplicación:
   ```bash
   java Principal
   ```

## 📋 Requisitos del Proyecto (PDF)

El desarrollo sigue estrictamente las directrices marcadas en el documento "Tarea Final de la Unidad PROG05_25_26.pdf", incluyendo:
- Limite de 30 dispositivos en el array.
- Uso obligatorio de HashMap para búsquedas.
- Validación de horas (>0) y consumos (>=0).
- Manejo de duplicados por código de dispositivo.

---
*Proyecto desarrollado por Kamal Majaiti para el módulo de Programación.*
