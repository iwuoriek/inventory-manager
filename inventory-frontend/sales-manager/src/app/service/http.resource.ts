import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class HttpResource {
    httpOption = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };

    log(message: string){
        console.log(message);
    }


    handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            this.log(`${operation} failed: ${error.message}`);
            return of(result as T);
        };
    }
}
