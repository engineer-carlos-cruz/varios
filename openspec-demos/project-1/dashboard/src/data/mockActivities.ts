export interface Activity {
  id: string;
  user: string;
  action: string;
  timestamp: Date;
}

const activityTypes = [
  { action: 'creó un reporte', user: 'Ana García' },
  { action: 'actualizó información', user: 'Carlos López' },
  { action: 'envió mensaje', user: 'María Rodriguez' },
  { action: 'descargó archivo', user: 'José Martínez' },
  { action: 'creó dashboard', user: 'Laura Sánchez' },
  { action: 'compartió reporte', user: 'Pedro Torres' },
  { action: 'modificó configuración', user: 'Sofia Hernández' },
  { action: 'exportó datos', user: 'Miguel González' }
];

const generateActivities = (range: { start: Date; end: Date }): Activity[] => {
  const activities: Activity[] = [];
  const days = Math.ceil((range.end.getTime() - range.start.getTime()) / (1000 * 60 * 60 * 24));
  const count = Math.min(10, Math.max(3, Math.floor(days / 3)));
  
  for (let i = 0; i < count; i++) {
    const randomDays = Math.floor(Math.random() * days);
    const randomHours = Math.floor(Math.random() * 24);
    const timestamp = new Date(range.start);
    timestamp.setDate(timestamp.getDate() + randomDays);
    timestamp.setHours(randomHours, Math.floor(Math.random() * 60));
    
    const activityType = activityTypes[Math.floor(Math.random() * activityTypes.length)];
    
    activities.push({
      id: `activity-${i + 1}`,
      user: activityType.user,
      action: activityType.action,
      timestamp
    });
  }
  
  return activities.sort((a, b) => b.timestamp.getTime() - a.timestamp.getTime());
};

export const getActivities = async (range: { start: Date; end: Date }): Promise<Activity[]> => {
  await new Promise(resolve => setTimeout(resolve, 400));
  return generateActivities(range);
};