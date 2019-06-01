import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { ProductService } from '../service/product.service';
import { BrandAndCategoryService } from '../service/bc.service';
import { Brand } from '../model/brand';
import { Category } from '../model/category';
import { Product } from '../model/product';

@Component({
    selector: 'app-product-add',
    templateUrl: 'add-product.component.html',
    styleUrls: ['products.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AddProductComponent implements OnInit {

    brands: Brand[];

    categories: Category[];

    productDetails = new FormGroup({
        id: new FormControl(''),
        name: new FormControl(''),
        category: new FormControl(''),
        brand: new FormControl(''),
        quantity: new FormControl(''),
        price: new FormControl('')
    });

    constructor(private router: Router, private route: ActivatedRoute,
// tslint:disable-next-line: align
        private service: ProductService,
// tslint:disable-next-line: align
        private bncService: BrandAndCategoryService) { }

    ngOnInit() {
        this.bncService.getBrandList().subscribe(brandList => this.brands = brandList);
        this.bncService.getCategoryList().subscribe(catList => this.categories = catList);
    }

    addProduct(values: FormGroup) {
// tslint:disable-next-line: radix
        const brandId = Number.parseInt(values.value.brand);
        const brand = this.getEntity<Brand>(this.brands, brandId);
// tslint:disable-next-line: radix
        const catId = Number.parseInt(values.value.category);
        const category = this.getEntity<Category>(this.categories, catId);

        const product: Product = {
            id: values.value.id,
            name: values.value.name,
            brandDto: brand,
            categoryDto: category,
            quantity: values.value.quantity,
            price: values.value.price
        };

        this.service.addProduct(product).subscribe(() => {
            this.router.navigate(['../'], {relativeTo: this.route});
        });
    }

    private getEntity<T>(entities: T[], id: number): T {
        for (const entity of entities) {
            if (entity.id === id) {
                return entity;
            }
        }
    }

    onCancel() {
        this.router.navigate(['../../products'], { relativeTo: this.route });
    }
}
