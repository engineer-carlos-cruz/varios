## Why

Se necesita crear una vista principal de dashboard que muestre métricas clave del negocio de manera visual y ordenada. Esto permitirá a los usuarios monitoreo rápido de indicadores importantes sin necesidad de consultar múltiples fuentes. Es la primera iteración del sistema de métricas.

## What Changes

- Crear pantalla principal de dashboard con componentes MUI
- Integrar dentro del proyecto frontend existente 'dashboard'
- Implementar header con título y selector de rango de fecha
- Mostrar tarjetas de métricas principales con valores numéricos
- Incluir gráfico de tendencia simple
- Agregar tabla de actividad reciente
- Manejar estados de loading y vacío
- Actualizar datos mockeados al cambiar rango de fecha

## Capabilities

### New Capabilities

- `dashboard-metrics-view`: Vista principal del dashboard que incluye header con selector de fechas, tarjetas de métricas, gráfico de tendencia y tabla de actividad reciente

### Modified Capabilities

(No hay capacidades existentes que modificar - es una nueva implementación)

## Impact

- Proyecto frontend 'dashboard' - nueva vista única
- Dependencias: MUI (Material UI)
- Sin cambios en autenticación ni backend