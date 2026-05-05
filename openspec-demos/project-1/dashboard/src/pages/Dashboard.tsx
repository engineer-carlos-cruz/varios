import { useState, useEffect, useCallback } from 'react';
import { 
  Container, 
  Grid, 
  Typography, 
  Box, 
  Paper 
} from '@mui/material';
import { MetricCard } from '../components/MetricCard';
import { TrendChart } from '../components/TrendChart';
import { ActivityTable } from '../components/ActivityTable';
import { DateRangeSelector, type DateRangeOption } from '../components/DateRangeSelector';
import { LoadingState } from '../components/LoadingState';
import { EmptyState } from '../components/EmptyState';
import { getMetrics, getTrendData, type Metric, type TrendDataPoint, type DateRange } from '../data/mockMetrics';
import { getActivities, type Activity } from '../data/mockActivities';

function getDateRange(days: number): DateRange {
  const end = new Date();
  const start = new Date();
  start.setDate(start.getDate() - days);
  return { start, end };
}

export function Dashboard() {
  const [dateRangeOption, setDateRangeOption] = useState<DateRangeOption>('30');
  const [loading, setLoading] = useState(true);
  const [metrics, setMetrics] = useState<Metric[]>([]);
  const [trendData, setTrendData] = useState<TrendDataPoint[]>([]);
  const [activities, setActivities] = useState<Activity[]>([]);

  const loadData = useCallback(async () => {
    setLoading(true);
    try {
      const days = parseInt(dateRangeOption, 10);
      const range = getDateRange(days);
      
      const [metricsData, trendResult, activitiesData] = await Promise.all([
        getMetrics(range),
        getTrendData(range),
        getActivities(range)
      ]);

      setMetrics(metricsData);
      setTrendData(trendResult);
      setActivities(activitiesData);
    } catch (error) {
      console.error('Error loading data:', error);
    } finally {
      setLoading(false);
    }
  }, [dateRangeOption]);

  useEffect(() => {
    loadData();
  }, [loadData]);

  const handleDateRangeChange = (option: DateRangeOption) => {
    setDateRangeOption(option);
  };

  return (
    <Container maxWidth="lg" sx={{ py: 4 }}>
      <Paper sx={{ p: 3, mb: 3 }}>
        <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', flexWrap: 'wrap', gap: 2 }}>
          <Typography variant="h4" component="h1" sx={{ fontWeight: 'bold' }}>
            Dashboard
          </Typography>
          <DateRangeSelector value={dateRangeOption} onChange={handleDateRangeChange} />
        </Box>
      </Paper>

      {loading ? (
        <LoadingState />
      ) : (
        <>
          <Grid container spacing={3} sx={{ mb: 3 }}>
            {metrics.length > 0 ? (
              metrics.map((metric) => (
                <Grid size={{ xs: 12, sm: 6, md: 3 }} key={metric.id}>
                  <MetricCard metric={metric} />
                </Grid>
              ))
            ) : (
              <Grid size={12}>
                <EmptyState message="No hay métricas disponibles" />
              </Grid>
            )}
          </Grid>

          <Grid container spacing={3} sx={{ mb: 3 }}>
            <Grid size={{ xs: 12, lg: 8 }}>
              {trendData.length > 0 ? (
                <TrendChart data={trendData} />
              ) : (
                <EmptyState message="No hay datos de tendencia" />
              )}
            </Grid>
            <Grid size={{ xs: 12, lg: 4 }}>
              {activities.length > 0 ? (
                <ActivityTable activities={activities} />
              ) : (
                <EmptyState message="No hay actividad reciente" />
              )}
            </Grid>
          </Grid>
        </>
      )}
    </Container>
  );
}