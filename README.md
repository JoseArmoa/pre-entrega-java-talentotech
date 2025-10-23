🛠️ Gestor de Reparaciones (Aplicación de Consola Java)
📋 Descripción

Esta aplicación simula un sistema de gestión de reparaciones desarrollado en Java como aplicación de consola.
Actualmente, los datos se manejan en memoria mediante listas (ArrayList), sin persistencia en base de datos.

El sistema permite gestionar clientes y reparaciones, diferenciando entre:

Clientes Finales

Clientes de Gremio (con cuenta corriente y saldo acumulable)

⚙️ Características principales
👥 Gestión de Clientes

Crear, listar, actualizar y eliminar clientes.

Diferenciar entre cliente final y cliente gremio.

Manejo de múltiples contactos (teléfono, mail, domicilio).

Actualizar saldo de cuenta corriente (solo para clientes gremio).

🔧 Gestión de Reparaciones

Crear reparaciones asociadas a clientes.

Marcar reparaciones como entregadas.

Si el cliente es de gremio, el costo de la reparación se suma automáticamente a su cuenta corriente.

Listar reparaciones entregadas o pendientes.

Eliminar o actualizar reparaciones.

💻 Interfaz de Consola

Menús dinámicos para cada módulo (Cliente y Reparación).

Entrada de datos validada desde consola.

Estructura CRUD reutilizable con la clase base CrudConsola.
