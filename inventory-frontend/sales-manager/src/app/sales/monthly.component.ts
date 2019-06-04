import {Component, OnInit} from '@angular/core';
import { SalesService } from '../service/sales.service';
import { Sales } from '../model/sales';

@Component({
    selector: 'app-sales-month',
    templateUrl: './monthly.component.html',
    styleUrls: ['./sales.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class MonthlyComponent implements OnInit {
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
            salesList.forEach(sales => {
                if (this.isCurrentMonth(sales.date)) {
                    mySales.push(sales);
                    total = total + sales.total;
                }
            });
            this.sales = mySales;
            this.totalSale = total.toFixed(2);
        });
    }

    isCurrentMonth(date: string): boolean {
        const currentMonth = new Date().getMonth();
        const currentYear = new Date().getFullYear();
        const dateMonth = new Date(date).getMonth();
        const dateYear = new Date(date).getFullYear();
        if (dateYear === currentYear && dateMonth === currentMonth) {
            return true;
        } else {
            return false;
        }
    }

    formatDate(date: string): string {
        return new Date(date).toDateString();
    }
}
