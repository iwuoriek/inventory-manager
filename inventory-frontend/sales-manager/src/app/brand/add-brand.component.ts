import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { BrandAndCategoryService } from '../service/bc.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Brand } from '../model/brand';

@Component({
    selector: 'app-brand-add',
    templateUrl: 'add-brand.component.html',
    styleUrls: ['./brands.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AddBrandComponent implements OnInit {
    brandDetails = new FormGroup({
        name: new FormControl('')
    });

    constructor(private service: BrandAndCategoryService, private route: ActivatedRoute, private router: Router) {}

    ngOnInit() {}

    addBrand(values: FormGroup) {
        const brand: Brand = {
            id: 0,
            name: values.value.name
        };
        if (brand) {
            this.service.addBrand(brand).subscribe(() => {
                this.router.navigate(['../../brands'], {relativeTo: this.route});
            });
        } else {
            console.log('No addhock function');
        }
    }

    onCancel() {
        this.router.navigate(['../'], {relativeTo: this.route});
    }
}
