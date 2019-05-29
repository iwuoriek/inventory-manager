import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-sales-daily',
    templateUrl: './daily.component.html',
    styleUrls: ['./sales.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class DailyComponent implements OnInit {
    sales = SALES;

    constructor() {}

    ngOnInit() {}
}

const SALES = [
    {date: '10/22/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/22/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/22/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/22/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
    {date: '10/22/2019', item: 'Coke', price: 8.99, quantity: 5, subtotal: 40},
];