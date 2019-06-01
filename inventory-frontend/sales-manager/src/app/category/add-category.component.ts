import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { BrandAndCategoryService } from '../service/bc.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../model/category';

@Component({
    selector: 'app-category-add',
    templateUrl: 'add-category.component.html',
    styleUrls: ['./category.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AddCategoryComponent implements OnInit {
    categoryDetails = new FormGroup({
        name: new FormControl('')
    });

    constructor(private service: BrandAndCategoryService, private route: ActivatedRoute, private router: Router) {}

    ngOnInit() {}

    addCategory(values: FormGroup) {
        const category: Category = {
            id: 0,
            name: values.value.name
        };
        if (category) {
            this.service.addCategory(category).subscribe(() => {
                this.router.navigate(['../../categories'], {relativeTo: this.route});
            });
        }
    }

    onCancel() {
        this.router.navigate(['../'], {relativeTo: this.route});
    }
}
