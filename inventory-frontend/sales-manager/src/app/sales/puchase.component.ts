import {Component, OnInit} from '@angular/core';
import { SalesService } from '../service/sales.service';
import { Sales } from '../model/sales';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';
import { FormGroup, FormControl } from '@angular/forms';
import { SalesEntry } from '../model/sales.entry';

@Component({
    selector: 'app-purchase',
    templateUrl: './purchase.component.html',
    styleUrls: ['./sales.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class PurchaseComponent implements OnInit {
    date: string;
    salesTotal = 0;
    productList: Product[];
    salesEntryList: SalesEntry[] = [];

    productDetail = new FormGroup({
        amount: new FormControl('')
    });

    constructor(private productService: ProductService, private salesService: SalesService) {}

    ngOnInit() {
        const ddate = new Date();
        this.date = `${ddate.getFullYear()}-${this.format(ddate.getMonth() + 1)}-${this.format(ddate.getDate())}`;
        this.productService.getProductList().subscribe(products => this.productList = products);
    }

    addProduct(product: Product) {
        const quant = this.productDetail.value.amount;
        const tot = product.price * quant;
        const productQuantity = product.quantity - quant;
        product.quantity = productQuantity;
        const entry: SalesEntry = {
            id: 0,
            productDto: product,
            quantity: quant,
            total: tot
        };
        this.salesEntryList.push(entry);
        this.salesTotal = this.getTotal(this.salesEntryList);
    }

    makePurchase() {
        const sales: Sales = {
            id: '',
            entryDtos: this.salesEntryList,
            date: this.date,
            total: this.salesTotal
        };
        this.salesService.addSales(sales).subscribe(() => {
            this.salesTotal = 0;
            this.salesEntryList = [];
        });
    }

    format(val: number): string {
        if (val < 10) {
            return `0${val}`;
        } else {
            return `${val}`;
        }
    }

    getTotal(entryList: SalesEntry[]): number {
        let total = 0;
        entryList.forEach(entry => {
            total = total + entry.total;
        });
        return total;
    }
}
