export interface Metric {
  id: string;
  label: string;
  value: number;
  change: number;
  prefix?: string;
  suffix?: string;
}

export interface TrendDataPoint {
  date: string;
  value: number;
}

export interface DateRange {
  start: Date;
  end: Date;
}

const generateMetrics = (range: DateRange): Metric[] => {
  const days = Math.ceil((range.end.getTime() - range.start.getTime()) / (1000 * 60 * 60 * 24));
  const factor = Math.max(1, days / 30);
  
  return [
    {
      id: 'users',
      label: 'Usuarios Activos',
      value: Math.floor(1240 * factor),
      change: 12.5,
      suffix: ''
    },
    {
      id: 'revenue',
      label: 'Ingresos',
      value: Math.floor(8540 * factor),
      change: 8.2,
      prefix: '$'
    },
    {
      id: 'sessions',
      label: 'Sesiones',
      value: Math.floor(3200 * factor),
      change: -2.4,
      suffix: ''
    },
    {
      id: 'conversions',
      label: 'Conversiones',
      value: Math.floor(185 * factor),
      change: 15.7,
      suffix: '%'
    }
  ];
};

const generateTrendData = (range: DateRange): TrendDataPoint[] => {
  const data: TrendDataPoint[] = [];
  const current = new Date(range.start);
  const baseValue = 100;
  
  while (current <= range.end) {
    const dayOfWeek = current.getDay();
    const weekendFactor = (dayOfWeek === 0 || dayOfWeek === 6) ? 0.7 : 1;
    const randomFactor = 0.8 + Math.random() * 0.4;
    const value = Math.floor(baseValue * weekendFactor * randomFactor);
    
    data.push({
      date: current.toISOString().split('T')[0],
      value
    });
    
    current.setDate(current.getDate() + 1);
  }
  
  return data;
};

export const getMetrics = async (range: DateRange): Promise<Metric[]> => {
  await new Promise(resolve => setTimeout(resolve, 500));
  return generateMetrics(range);
};

export const getTrendData = async (range: DateRange): Promise<TrendDataPoint[]> => {
  await new Promise(resolve => setTimeout(resolve, 300));
  return generateTrendData(range);
};