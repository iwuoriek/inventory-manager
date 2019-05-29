import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './registration/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SalesComponent } from './sales/sales.component';
import { DailyComponent } from './sales/daily.component';
import { WeeklyComponent } from './sales/weekly.component';
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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    SalesComponent,
    DailyComponent,
    WeeklyComponent,
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
    UpdateCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
