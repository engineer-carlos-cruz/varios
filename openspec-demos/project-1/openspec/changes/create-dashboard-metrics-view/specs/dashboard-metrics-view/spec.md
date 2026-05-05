## ADDED Requirements

### Requirement: Dashboard principal con métricas
El sistema debe mostrar una vista principal de dashboard que presente métricas clave del negocio de manera visual y ordenada.

#### Scenario: Visualización de métricas principales
- **WHEN** el usuario accede al dashboard
- **THEN** se muestran tarjetas con métricas principales (usuarios activos, ingresos, sesiones, conversions)

### Requirement: Selector de rango de fecha
El sistema debe permitir al usuario seleccionar un rango de fecha para filtrar los datos mostrados.

#### Scenario: Cambio de rango de fecha
- **WHEN** el usuario selecciona un nuevo rango de fecha y confirma
- **THEN** los datos de métricas, gráfico y tabla se actualizan para reflejar el período seleccionado

#### Scenario: Rango de fecha válido
- **WHEN** el usuario selecciona fecha inicio menor a fecha fin
- **THEN** el sistema acepta el rango como válido

### Requirement: Gráfico de tendencia
El sistema debe mostrar un gráfico de tendencia que represente la evolución de una métrica en el tiempo.

#### Scenario: Visualización de tendencia
- **WHEN** el dashboard se carga con datos disponibles
- **THEN** se muestra un gráfico de línea con la tendencia de la métrica principal

### Requirement: Tabla de actividad reciente
El sistema debe mostrar una tabla con las actividades más recientes.

#### Scenario: Actividad reciente visible
- **WHEN** existen actividades en el período seleccionado
- **THEN** se muestra una tabla con las últimas actividades, ordenadas por fecha

#### Scenario: Sin actividad reciente
- **WHEN** no hay actividades en el período seleccionado
- **THEN** se muestra un estado vacío con mensaje apropiado

### Requirement: Estado de carga
El sistema debe mostrar indicators de carga mientras obtiene datos.

#### Scenario: Mostrando estado de carga
- **WHEN** los datos están siendo preparados
- **THEN** se muestra un indicator de carga (skeleton o spinner)

#### Scenario: Datos cargados
- **WHEN** los datos están disponibles
- **THEN** se oculta el indicator de carga y se muestran los datos

### Requirement: Actualización de datos mockeados
Los datos mockeados deben actualizarse dinámicamente según el rango de fecha seleccionado.

#### Scenario: Datos diferentes por rango
- **WHEN** el usuario cambia el rango de fecha
- **THEN** los valores de métricas y entradas de tabla reflejan el período seleccionado