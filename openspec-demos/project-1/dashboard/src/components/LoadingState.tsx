import { Box, CircularProgress, Typography } from '@mui/material';

export function LoadingState() {
  return (
    <Box
      sx={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        py: 8,
        gap: 2
      }}
    >
      <CircularProgress />
      <Typography color="text.secondary">Cargando datos...</Typography>
    </Box>
  );
}