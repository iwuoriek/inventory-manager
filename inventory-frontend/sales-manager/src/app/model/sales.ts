import { SalesEntry } from './sales.entry';

export class Sales {
    id: string;
    date: string;
    entryDtos: SalesEntry[];
    total: number;
}
