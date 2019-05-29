import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css', '../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})

export class LoginComponent implements OnInit {
    loginValues = new FormGroup({
        ref: new FormControl(''),
        email: new FormControl(''),
        password: new FormControl('')
    });

    registrationValues = new FormGroup({
        cname: new FormControl(''),
        cemail: new FormControl(''),
        street: new FormControl(''),
        city: new FormControl(''),
        pcode: new FormControl(''),
        country: new FormControl(''),
        fname: new FormControl(''),
        sname: new FormControl(''),
        uemail: new FormControl(''),
        pword: new FormControl(''),
        cpword: new FormControl('')
    });

    constructor(private router: Router) {}

    ngOnInit() {
        /*this.loginValues = new FormGroup({
            ref: new FormControl(''),
            email: new FormControl(''),
            password: new FormControl('')
        });*/
    }

    onLogin() {
        const ref = this.loginValues.value.ref;
        const email = this.loginValues.value.email;
        const password = this.loginValues.value.password;
        if (email === 'mail' && password === '1234') {
            this.router.navigate(['/user']);
        } else {
            this.router.navigate(['/login']);
        }
    }

    onRegister(registrationValues) {
        const mail =  registrationValues.value.uemail;
        this.loginValues.setValue({ref: '', email: mail, password: ''});
        console.log(mail);
    }
}
