import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import { RegistrationService } from '../service/registration.service';
import { UserAccount } from '../model/user.account';
import { Location } from '@angular/common';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class LoginComponent implements OnInit {
    user: UserAccount;
    message: string;

    loginValues = new FormGroup({
        username: new FormControl(''),
        password: new FormControl('')
    });

    registrationValues = new FormGroup({
        cname: new FormControl(''),
        cemail: new FormControl(''),
        date: new FormControl(''),
        fname: new FormControl(''),
        sname: new FormControl(''),
        uemail: new FormControl(''),
        role: new FormControl(''),
        pword: new FormControl(''),
        cpword: new FormControl('')
    });

    constructor(private router: Router, private regService: RegistrationService, private location: Location) {}

    ngOnInit() {
        /*this.loginValues = new FormGroup({
            ref: new FormControl(''),
            email: new FormControl(''),
            password: new FormControl('')
        });*/
    }

    onLogin(values: FormGroup) {
        const username = values.value.username;
        const password = values.value.password;
        this.regService.loginUser(username).subscribe(user => this.user = user);
        if (this.user && password === this.user.password) {
            console.log('valid');
            this.message = '';
            this.router.navigate([`/user/${username}`]);
        } else {
            this.message = 'Invalid user login';
            console.log('invalid');
            this.router.navigate(['/login']);
        }
    }

    onRegister(values: FormGroup) {
        const userDetails: UserAccount = {
            username: '',
            firstName: values.value.fname,
            lastName: values.value.sname,
            businessDto: {
                id: 0,
                reference: '',
                name: values.value.cname,
                dateEstablished: values.value.date,
                email: values.value.cemail
            },
            role: values.value.role,
            password: values.value.pword
        };
        this.regService.registerUser(userDetails).subscribe(res => {
            this.clearValues();
        }, error => {
            console.error(`LoginComponent.onRegister ${error}`);
        });
    }

    private clearValues() {
        this.registrationValues = new FormGroup({
            cname: new FormControl(''),
            cemail: new FormControl(''),
            date: new FormControl(''),
            fname: new FormControl(''),
            sname: new FormControl(''),
            uemail: new FormControl(''),
            role: new FormControl(''),
            pword: new FormControl(''),
            cpword: new FormControl('')
        });
    }
}
