import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-brands',
    templateUrl: './brands.component.html',
    styleUrls: ['./brands.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class BrandsComponent implements OnInit {
    brands = BRANDS;

    constructor() {}

    ngOnInit() {}
}

const BRANDS = [
    {id: 1, name: 'Great Value'},
    {id: 2, name: 'McVities'},
    {id: 3, name: 'Beros'},
    {id: 4, name: 'Colgate'}
];
