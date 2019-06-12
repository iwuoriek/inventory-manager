import { Injectable } from '@angular/core';
import { Brand } from '../model/brand';
import { Category } from '../model/category';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { HttpResource } from './http.resource';

@Injectable({
    providedIn: 'root'
})

export class BrandAndCategoryService {
    // private categoryEndpoint = 'http://localhost:8080/inventory/category';
    private categoryEndpoint = 'http://spring-boot-inventory-app-dev.us-west-2.elasticbeanstalk.com/inventory/category';

    // private brandEndpoint = 'http://localhost:8080/inventory/brand';
    private brandEndpoint = 'http://spring-boot-inventory-app-dev.us-west-2.elasticbeanstalk.com/inventory/brand';

    constructor(private httpClient: HttpClient, private resource: HttpResource) {}

    addBrand(brand: Brand): Observable<any> {
        return this.httpClient.post<Brand>(this.brandEndpoint, JSON.stringify(brand), this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('add brand successful')),
                catchError(this.resource.handleError<Brand>('function "addBrand', null))
            );
    }

    getBrandList(): Observable<Brand[]> {
        return this.httpClient.get<Brand[]>(this.brandEndpoint)
            .pipe(
                tap(() => this.resource.log('get brand list successful')),
                catchError(this.resource.handleError<Brand[]>('function "getBrandList"', []))
            );
    }

    deleteBrand(id: number): Observable<any> {
        return this.httpClient.delete<any>(`${this.brandEndpoint}/${id}`, this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('delete brand successful')),
                catchError(this.resource.handleError<any>('function "deleteBrand"', null))
            );
    }

    addCategory(category: Category): Observable<any> {
        return this.httpClient.post<Category>(this.categoryEndpoint, JSON.stringify(category), this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('add category successful')),
                catchError(this.resource.handleError<Category>('function "addCategory', null))
            );
    }

    getCategoryList(): Observable<Category[]> {
        return this.httpClient.get<Category[]>(this.categoryEndpoint)
            .pipe(
                tap(() => this.resource.log('get category list successful')),
                catchError(this.resource.handleError<Category[]>('function "getCategoryList"', []))
            );
    }

    deleteCategory(id: number): Observable<any> {
        return this.httpClient.delete<any>(`${this.categoryEndpoint}/${id}`, this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log('delete category successful')),
                catchError(this.resource.handleError<any>('function "deleteCategory"', null))
            );
    }
}
