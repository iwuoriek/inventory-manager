import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-sales-annual',
    templateUrl: './annual.component.html',
    styleUrls: ['./sales.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AnnualComponent implements OnInit {
    sales = SALES;

    constructor() {}

    ngOnInit() {}
}

const SALES = [
    {date: '10/22/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/23/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/24/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/25/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/26/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
];