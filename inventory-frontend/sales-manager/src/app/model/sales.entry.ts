import { Product } from './product';

export class SalesEntry {
    id: number;
    productDto: Product;
    quantity: number;
    total: number;
}
