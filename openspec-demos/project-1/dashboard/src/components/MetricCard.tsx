import type { Metric } from '../data/mockMetrics';

interface MetricCardProps {
  metric: Metric;
  loading?: boolean;
}

import { Card, CardContent, Typography, Box, Skeleton } from '@mui/material';
import { TrendingUp, TrendingDown } from '@mui/icons-material';

export function MetricCard({ metric, loading }: MetricCardProps) {
  if (loading) {
    return (
      <Card sx={{ height: '100%' }}>
        <CardContent>
          <Skeleton width="60%" />
          <Skeleton width="40%" />
          <Skeleton width="30%" />
        </CardContent>
      </Card>
    );
  }

  const isPositive = metric.change >= 0;

  return (
    <Card sx={{ height: '100%' }}>
      <CardContent>
        <Typography color="text.secondary" gutterBottom>
          {metric.label}
        </Typography>
        <Typography variant="h4" component="div" sx={{ fontWeight: 'bold', mb: 1 }}>
          {metric.prefix}{metric.value.toLocaleString()}{metric.suffix}
        </Typography>
        <Box sx={{ display: 'flex', alignItems: 'center' }}>
          {isPositive ? (
            <TrendingUp sx={{ color: 'success.main', mr: 0.5 }} />
          ) : (
            <TrendingDown sx={{ color: 'error.main', mr: 0.5 }} />
          )}
          <Typography
            variant="body2"
            sx={{ color: isPositive ? 'success.main' : 'error.main' }}
          >
            {Math.abs(metric.change)}%
          </Typography>
          <Typography variant="body2" color="text.secondary" sx={{ ml: 0.5 }}>
            vs período anterior
          </Typography>
        </Box>
      </CardContent>
    </Card>
  );
}