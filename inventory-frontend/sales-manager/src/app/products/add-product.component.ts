import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    selector: 'app-product-add',
    templateUrl: 'add-product.component.html',
    styleUrls: ['products.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AddProductComponent implements OnInit {
    productDetails = new FormGroup({
        name: new FormControl(''),
        category: new FormControl(''),
        brand: new FormControl(''),
        quantity: new FormControl(''),
        price: new FormControl('')
    });

    constructor(private router: Router, private location: Location) {}

    ngOnInit() {}

    addProduct() {}

    onCancel() {
        this.router.navigate(['/user/products']);
        // this.location.back();
    }
}
