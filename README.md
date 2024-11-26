
*🏧  de Cajero Automático

📋 ##Descripción del Proyecto
Este proyecto es una simulación de un sistema de cajero automático que permite realizar **retiros de efectivo**. 
El cajero tiene una cantidad fija de dinero al inicio del día y dispensa las denominaciones correspondientes al 
monto solicitado por el usuario.

El sistema no admite recargas de efectivo ni funcionalidades adicionales; su único propósito es manejar retiros 
de manera práctica, segura y funcional.

🎯 ##Objetivo
- Crear un sistema que simule un cajero automático sencillo.
- Mostrar las cantidades y denominaciones con las cuales se entregará el monto solicitado por el usuario.

🏗️ ##Estructura del Proyecto

Tablas de la Base de Datos
denominaciones
| ID | Tipo     | Cantidad Inicial | Denominación ($) |
|----|----------|------------------|-------------------|
| 1  | Billete  | 2                | 1000              |
| 2  | Billete  | 5                | 500               |
| 3  | Billete  | 10               | 200               |
| 4  | Billete  | 20               | 100               |
| 5  | Billete  | 30               | 50                |
| 6  | Billete  | 40               | 20                |
| 7  | Moneda   | 50               | 10                |
| 8  | Moneda   | 100              | 5                 |
| 9  | Moneda   | 200              | 2                 |
| 10 | Moneda   | 300              | 1                 |
| 11 | Moneda   | 100              | 0.50              |

##Flujo del Programa

1. Inicio del Día:
   - El cajero comienza con una cantidad fija de **$12,550** dividida en las denominaciones mencionadas.

2. Interfaz de Usuario:
   - El usuario ingresa la cantidad que desea retirar.
   - El sistema valida que la cantidad esté disponible en el cajero.
   - Si es posible, muestra las denominaciones con las que se entregará el monto.

3. Restricciones:
   - No se aceptan cantidades superiores a las disponibles en el cajero.
   - No se permite recargar efectivo.

🛠️ ##Requerimientos Técnicos
- Lenguaje de Programación: [Java/Python/Node.js/etc.]
- Base de Datos: [MySQL/PostgreSQL/etc.]
- Interfaz de Usuario: Libre (consola, web o móvil).
- Frameworks/Dependencias: Según elección del desarrollador.

🖥️ ##Ejecución del Proyecto

1. Configurar la Base de Datos:
   - Crear una tabla con los datos mencionados en `denominaciones`.
2. Iniciar la Aplicación:
   - Asegúrate de tener configurado el entorno para el lenguaje elegido.
3. Retirar Efectivo:
   - Ingresar la cantidad deseada.
   - Ver el desglose de las denominaciones entregadas.

⚙️ ##Ejemplo de Ejecución

Entrada:
El usuario solicita retirar **$2750**.

Salida:
El sistema entrega:
- 2 billetes de $1000
- 3 billetes de $500
- 1 billete de $200
- 1 billete de $50

📂 Estructura del Proyecto
📁 cajero-automatico  
├── 📂 src  
│   ├── Main.java  
│   ├── Dispensador.java  
│   ├── BDConexion.java  
│   └── DenominacionesDAO.java  
├── 📂 resources  
│   └── schema.sql  
├── README.md  
└── pom.xml / package.json (según la tecnología utilizada)


🚀 ##Futuras Mejoras
- Agregar soporte para depósitos.
- Implementar autenticación de usuarios (pines o tarjetas).
- Mejorar la interfaz gráfica.
