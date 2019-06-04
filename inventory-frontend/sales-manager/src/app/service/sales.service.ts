import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpResource } from './http.resource';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Sales } from '../model/sales';

@Injectable({
    providedIn: 'root'
})

export class SalesService {
    private endpoint = 'http://localhost:8080/inventory/sales';
    // private endpoint = 'http://spring-boot-inventory-app-dev.us-west-2.elasticbeanstalk.com/inventory/sales';

    constructor(private httpClient: HttpClient, private resource: HttpResource) {}

    addSales(sales: Sales): Observable<any> {
        return this.httpClient.post<Sales>(this.endpoint, JSON.stringify(sales), this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('add sales successful')),
                catchError(this.resource.handleError<Sales>('function "addSales"', null))
            );
    }

    getSales(id: string): Observable<Sales> {
        return this.httpClient.get<Sales>(`${this.endpoint}/${id}`)
            .pipe(
                tap(() => this.resource.log('get sales successful')),
                catchError(this.resource.handleError<Sales>('function "getSales"', null))
            );
    }

    getSalesList(): Observable<Sales[]> {
        return this.httpClient.get<Sales[]>(this.endpoint)
            .pipe(
                tap(() => this.resource.log('get sales list successful')),
                catchError(this.resource.handleError<Sales[]>('function "getSalesList"', []))
            );
    }
}