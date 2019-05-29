import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    selector: 'app-brand-update',
    templateUrl: 'update-brand.component.html',
    styleUrls: ['./brands.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class UpdateBrandComponent implements OnInit {
    brandDetails = new FormGroup({
        id: new FormControl(''),
        name: new FormControl('')
    });

    constructor() {}

    ngOnInit() {}

    updateBrand() {}

    onCancel() {}
}
