import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    selector: 'app-category-update',
    templateUrl: 'update-category.component.html',
    styleUrls: ['./category.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class UpdateCategoryComponent implements OnInit {
    categoryDetails = new FormGroup({
        id: new FormControl(''),
        name: new FormControl('')
    });

    constructor() {}

    ngOnInit() {}

    updateCategory() {}

    onCancel() {}
}
