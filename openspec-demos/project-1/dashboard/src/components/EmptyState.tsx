import { Box, Typography } from '@mui/material';
import { Inbox } from '@mui/icons-material';

interface EmptyStateProps {
  message?: string;
}

export function EmptyState({ message = 'No hay datos disponibles' }: EmptyStateProps) {
  return (
    <Box
      sx={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        py: 8,
        gap: 1
      }}
    >
      <Inbox sx={{ fontSize: 48, color: 'text.disabled' }} />
      <Typography color="text.secondary">{message}</Typography>
    </Box>
  );
}