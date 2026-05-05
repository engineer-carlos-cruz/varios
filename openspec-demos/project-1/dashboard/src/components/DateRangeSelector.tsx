import { 
  FormControl, 
  InputLabel, 
  Select, 
  MenuItem, 
} from '@mui/material';
import type { SelectChangeEvent } from '@mui/material';

export type DateRangeOption = '7' | '14' | '30' | '90';

interface DateRangeSelectorProps {
  value: DateRangeOption;
  onChange: (value: DateRangeOption) => void;
}

export function DateRangeSelector({ value, onChange }: DateRangeSelectorProps) {
  const handleChange = (event: SelectChangeEvent) => {
    onChange(event.target.value as DateRangeOption);
  };

  return (
    <FormControl size="small" sx={{ minWidth: 150 }}>
      <InputLabel>Rango de Fecha</InputLabel>
      <Select value={value} label="Rango de Fecha" onChange={handleChange}>
        <MenuItem value="7">Últimos 7 días</MenuItem>
        <MenuItem value="14">Últimos 14 días</MenuItem>
        <MenuItem value="30">Últimos 30 días</MenuItem>
        <MenuItem value="90">Últimos 90 días</MenuItem>
      </Select>
    </FormControl>
  );
}