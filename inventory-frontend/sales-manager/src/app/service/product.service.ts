import { Injectable } from '@angular/core';
import { Product } from '../model/product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { HttpResource } from './http.resource';

@Injectable({
    providedIn: 'root'
})

export class ProductService {
    private endpoint = 'http://localhost:8080/inventory/product';
    // private endpoint = 'http://spring-boot-inventory-app-dev.us-west-2.elasticbeanstalk.com/inventory/product';

    constructor(private httpClient: HttpClient, private resource: HttpResource) {}

    addProduct(product: Product): Observable<any> {
        return this.httpClient.post<Product>(this.endpoint, JSON.stringify(product), this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('add product successful')),
                catchError(this.resource.handleError<Product>('function "addProduct', null))
            );
    }

    getProduct(id: string): Observable<Product> {
        return this.httpClient.get<Product>(`${this.endpoint}/${id}`)
            .pipe(
                tap(() => this.resource.log('get product successful')),
                catchError(this.resource.handleError<Product>('function "getProduct"', null))
            );
    }

    getProductList(): Observable<Product[]> {
        return this.httpClient.get<Product[]>(this.endpoint)
            .pipe(
                tap(() => this.resource.log('get product list successful')),
                catchError(this.resource.handleError<Product[]>('function "getProductList"', []))
            );
    }



    updateProduct(product: Product): Observable<any> {
        return this.httpClient.put<Product>(`${this.endpoint}/${product.id}`, JSON.stringify(product), this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('update product successful')),
                catchError(this.resource.handleError<Product>('function "updateProduct"', null))
            );
    }

    deleteProduct(id: number): Observable<any> {
        return this.httpClient.delete<any>(`${this.endpoint}/${id}`, this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('delete product successful')),
                catchError(this.resource.handleError<any>('function "deleteProduct"', null))
            );
    }
}
