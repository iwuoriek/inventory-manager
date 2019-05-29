import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-product-list',
    templateUrl: 'products.component.html',
    styleUrls: ['products.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class ProductsComponent implements OnInit {
    products = PRODUCTS;
    constructor() {}

    ngOnInit() {}
}

const PRODUCTS = [
    {id: 1, name: 'Coke', category: 'Drinks', brand: 'Coca-cola', quantity: 20, price: 14},
    {id: 2, name: 'Fanta', category: 'Drinks', brand: 'Coca-cola', quantity: 20, price: 14},
    {id: 3, name: 'Pepsi', category: 'Drinks', brand: 'Coca-cola', quantity: 10, price: 14},
    {id: 4, name: 'Sprite', category: 'Drinks', brand: 'Coca-cola', quantity: 30, price: 15},
    {id: 5, name: 'Digestive', category: 'Snacks', brand: 'McVities', quantity: 15, price: 24},
    {id: 6, name: 'Short Bread', category: 'Snacks', brand: 'McVities', quantity: 10, price: 24},
    {id: 7, name: 'Coco puffs', category: 'Cereal', brand: 'Kellogs', quantity: 9, price: 64},
    {id: 8, name: 'Oats', category: 'Cereal', brand: 'Great Value', quantity: 21, price: 44},
    {id: 9, name: 'Nutella', category: 'Spread', brand: 'Great Value', quantity: 25, price: 35},
    {id: 10, name: 'Flour', category: 'Baking', brand: 'Great Value', quantity: 11, price: 25}
];
