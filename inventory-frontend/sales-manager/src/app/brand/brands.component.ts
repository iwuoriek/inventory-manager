import { Component, OnInit } from '@angular/core';
import { BrandAndCategoryService } from '../service/bc.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Brand } from '../model/brand';

@Component({
    selector: 'app-brands',
    templateUrl: './brands.component.html',
    styleUrls: ['./brands.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class BrandsComponent implements OnInit {
    brands: Brand[];

    constructor(private service: BrandAndCategoryService, private route: ActivatedRoute, private router: Router) {}

    ngOnInit() {
        this.getBrands();
    }

    getBrands() {
        this.service.getBrandList().subscribe(brandsList => this.brands = brandsList);
    }

    deleteBrand(id: number) {
        this.service.deleteBrand(id).subscribe(() => this.getBrands());
    }
}
