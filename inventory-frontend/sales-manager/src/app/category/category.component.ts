import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-category',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class CategoryComponent implements OnInit {
    categories = CATEGORIES;

    constructor() {}

    ngOnInit() {}
}

const CATEGORIES = [
    {id: 1, name: 'Drinks'},
    {id: 2, name: 'Biscuits'},
    {id: 3, name: 'Baking'},
    {id: 4, name: 'Cereal'}
];
