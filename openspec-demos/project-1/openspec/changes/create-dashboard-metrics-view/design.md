## Context

Proyecto frontend 'dashboard' existente que necesita una vista principal de métricas. El usuario quiere una implementación simple con MUI, datos mockeados, y comportamiento interactivo básico al cambiar el rango de fechas.

## Goals / Non-Goals

**Goals:**
- Crear vista de dashboard con header, tarjetas métricas, gráfico y tabla
- Usar MUI para todos los componentes
- Datos mockeados que actualizan al cambiar rango de fecha
- Estados de loading y vacío
- Estructura de componentes clara y reutilizable

**Non-Goals:**
- Autenticación
- Múltiples páginas
- Backend real o API
- Funcionalidades fuera del alcance definido

## Decisions

- **MUI como librería UI**: Utilizar Material UI por requisito del usuario. Componentes: Grid, Card, Typography, Table, Select, TextField.
- **Datos mockeados en cliente**: Los datos serán simulación local en JavaScript, sin llamada a API real.
- **Estado local con useState**: Manejar estado de rango de fechas, loading, y datos en el componente principal.
- **Estructura de componentes**: Dividir en componentes reutilizables (MetricCard, TrendChart, ActivityTable) dentro de /components.

## Risks / Trade-offs

- [Riesgo]: Dados mockeados son estáticos → Mitigación: Generar datos aleatorios basados en rango de fecha para mostrar cambio.
- [Riesgo]: Performance con muchos datos → Mitigación: Mantener datasets pequeños y simples.