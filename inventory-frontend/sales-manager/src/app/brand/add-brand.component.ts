import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    selector: 'app-brand-add',
    templateUrl: 'add-brand.component.html',
    styleUrls: ['./brands.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AddBrandComponent implements OnInit {
    brandDetails = new FormGroup({
        name: new FormControl('')
    });

    constructor() {}

    ngOnInit() {}

    addBrand() {}

    onCancel() {}
}
