import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './registration/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SalesComponent } from './sales/sales.component';
import { AllSalesComponent } from './sales/all-sales.component';
import { MonthlyComponent } from './sales/monthly.component';
import { AnnualComponent } from './sales/annual.component';
import { ProductsComponent } from './products/products.component';
import { AddProductComponent } from './products/add-product.component';
import { UpdateProductComponent } from './products/update-product.component';
import { BrandsComponent } from './brand/brands.component';
import { AddBrandComponent } from './brand/add-brand.component';
import { UpdateBrandComponent } from './brand/update-brand.component';
import { CategoryComponent } from './category/category.component';
import { AddCategoryComponent } from './category/add-category.component';
import { UpdateCategoryComponent } from './category/update-category.component';
import { PurchaseComponent } from './sales/puchase.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    SalesComponent,
    AllSalesComponent,
    MonthlyComponent,
    AnnualComponent,
    ProductsComponent,
    AddProductComponent,
    UpdateProductComponent,
    BrandsComponent,
    AddBrandComponent,
    UpdateBrandComponent,
    CategoryComponent,
    AddCategoryComponent,
    UpdateCategoryComponent,
    PurchaseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
