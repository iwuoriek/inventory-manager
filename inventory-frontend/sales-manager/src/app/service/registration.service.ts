import { Injectable } from '@angular/core';
import { UserAccount } from '../model/user.account';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { HttpResource } from './http.resource';

@Injectable({
    providedIn: 'root'
})

export class RegistrationService {
    private endpoint = 'http://localhost:8080/inventory/user';
    // private endpoint = 'http://spring-boot-inventory-app-dev.us-west-2.elasticbeanstalk.com/inventory/user';

    constructor(private httpClient: HttpClient, private resource: HttpResource) {}

    registerUser(user: UserAccount): Observable<any> {
        console.log(user);
        return this.httpClient.post<UserAccount>(this.endpoint, JSON.stringify(user), this.resource.httpOption)
            .pipe(
                tap(() => this.resource.log(`sign up successful for user: ${user}`)),
                catchError(this.resource.handleError<UserAccount>('Method: "registerUser"', null))
            );
    }

    loginUser(username: string): Observable<UserAccount> {
        return this.httpClient.get<UserAccount>(`${this.endpoint}/${username}`)
            .pipe(
                tap(() => this.resource.log(`fetched entity for user with id: ${username}`)),
                catchError(this.resource.handleError<UserAccount>('Method: "loginUser"', null))
            );
    }
}

