## Context

El proyecto es un dashboard de métricas frontend simple construido con React y TypeScript. No hay backend, todos los datos son mockeados. El objetivo es crear una pantalla única que muestre métricas clave del producto.

## Goals / Non-Goals

**Goals:**
- Crear pantalla de dashboard con header, selector de fechas, tarjetas de métricas, gráfico de tendencia y tabla de actividad reciente
- Implementar cambio de rango de fechas que actualice los datos mockeados
- Mostrar estados de loading y vacío apropiadamente
- Mantener estructura de componentes clara y código simple

**Non-Goals:**
- No implementar autenticación
- No conectar a backend real
- No crear múltiples páginas
- No agregar funcionalidades fuera del alcance definido (export, filtros avanzados, etc.)

## Decisions

- **React con TypeScript**: Tecnología definida en el proyecto
- **Sin librería de gráficos externa**: Usar implementación simple de gráfico de barras/líneas con CSS o SVG básico para mantener dependencias mínimas
- **Estado local con useState**: No需要一个状态管理库，因为只有一个屏幕
- **Componentes pequeños y focaleados**: Separar Header, MetricCard, TrendChart, ActivityTable para mejor mantenimiento

## Risks / Trade-offs

- [Riesgo] Datos mockeados limitados → Mitigation: Crear utilería de datos que permita expandir fácilmente
- [Riesgo] Sin backend real → Mitigation: Documentar que es demo y los datos son de ejemplo