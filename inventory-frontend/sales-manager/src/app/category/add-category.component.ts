import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    selector: 'app-category-add',
    templateUrl: 'add-category.component.html',
    styleUrls: ['./category.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AddCategoryComponent implements OnInit {
    categoryDetails = new FormGroup({
        name: new FormControl('')
    });

    constructor() {}

    ngOnInit() {}

    addCategory() {}

    onCancel() {}
}
