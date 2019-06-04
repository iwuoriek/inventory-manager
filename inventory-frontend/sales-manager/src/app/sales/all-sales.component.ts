import {Component, OnInit} from '@angular/core';
import { SalesService } from '../service/sales.service';
import { Sales } from '../model/sales';

@Component({
    selector: 'app-sales-all',
    templateUrl: './all-sales.component.html',
    styleUrls: ['./sales.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class AllSalesComponent implements OnInit {
    sales: Sales[];
    totalSale: string;

    constructor(private service: SalesService) {}

    ngOnInit() {
        this.getSales();
    }

    getSales() {
        const mySales: Sales[] = [];
        let total = 0;
        this.service.getSalesList().subscribe(salesList => {
            salesList.forEach(sale => {
                total = total + sale.total;
            });
            this.sales = salesList;
            this.totalSale = total.toFixed(2);
        });
    }

    formatDate(date: string): string {
        return new Date(date).toDateString();
    }
}
