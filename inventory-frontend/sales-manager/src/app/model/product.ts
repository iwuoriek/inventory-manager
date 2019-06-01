import { Brand } from './brand';
import { Category } from './category'

export class Product{
    id: number;
    name: string;
    brandDto: Brand;
    categoryDto: Category;
    quantity: number;
    price: number
}