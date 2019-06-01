import { Component, OnInit } from '@angular/core';
import { BrandAndCategoryService } from '../service/bc.service';
import { Category } from '../model/category';

@Component({
    selector: 'app-category',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class CategoryComponent implements OnInit {
    categories: Category[];

    constructor(private service: BrandAndCategoryService) {}

    ngOnInit() {
        this.getCategories();
    }

    getCategories() {
        this.service.getCategoryList().subscribe(categoryList => this.categories = categoryList);
    }

    deleteCategory(id: number) {
        this.service.deleteCategory(id).subscribe(() => {
            this.getCategories();
        });
    }
}

const CATEGORIES = [
    {id: 1, name: 'Drinks'},
    {id: 2, name: 'Biscuits'},
    {id: 3, name: 'Baking'},
    {id: 4, name: 'Cereal'}
];
