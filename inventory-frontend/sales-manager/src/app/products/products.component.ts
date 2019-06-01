import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product';

@Component({
    selector: 'app-product-list',
    templateUrl: 'products.component.html',
    styleUrls: ['products.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class ProductsComponent implements OnInit {
    products: Product[];

    constructor(private service: ProductService) {}

    ngOnInit() {
        this.getProducts();
    }

    getProducts() {
        this.service.getProductList().subscribe(products => this.products = products);
    }

    deleteProduct(id: number){
        this.service.deleteProduct(id).subscribe(() => {
            this.getProducts();
        });
    }

}
