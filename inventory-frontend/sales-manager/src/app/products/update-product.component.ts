import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    selector: 'app-product-update',
    templateUrl: 'update-product.component.html',
    styleUrls: ['products.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class UpdateProductComponent implements OnInit {
    productDetails = new FormGroup({
        id: new FormControl(''),
        name: new FormControl(''),
        category: new FormControl(''),
        brand: new FormControl(''),
        quantity: new FormControl(''),
        price: new FormControl('')
    });

    constructor() {}

    ngOnInit() {}

    updateProduct() {}

    onCancel() {}
}
