import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './registration/login.component';
import { SalesComponent } from './sales/sales.component';
import { DailyComponent } from './sales/daily.component';
import { WeeklyComponent } from './sales/weekly.component';
import { MonthlyComponent } from './sales/monthly.component';
import { AnnualComponent } from './sales/annual.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductsComponent } from './products/products.component';
import { AddProductComponent } from './products/add-product.component';
import { UpdateProductComponent } from './products/update-product.component';
import { BrandsComponent } from './brand/brands.component';
import { AddBrandComponent } from './brand/add-brand.component';
import { UpdateBrandComponent } from './brand/update-brand.component';
import { CategoryComponent } from './category/category.component';
import { AddCategoryComponent } from './category/add-category.component';
import { UpdateCategoryComponent } from './category/update-category.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'user', component: DashboardComponent, children: [
    {path: '', redirectTo: 'sales', pathMatch: 'full'},
    {path: 'sales', component: SalesComponent, children: [
      {path: '', redirectTo: 'daily', pathMatch: 'full'},
      {path: 'daily', component: DailyComponent},
      {path: 'weekly', component: WeeklyComponent},
      {path: 'monthly', component: MonthlyComponent},
      {path: 'yearly', component: AnnualComponent}
    ]},
    {path: 'products', component: ProductsComponent, children: [
      {path: 'add', component: AddProductComponent},
      {path: 'update', component: UpdateProductComponent}
    ]},
    {path: 'brands', component: BrandsComponent, children: [
      {path: 'add', component: AddBrandComponent},
      {path: 'update', component: UpdateBrandComponent}
    ]},
    {path: 'categories', component: CategoryComponent, children: [
      {path: 'add', component: AddCategoryComponent},
      {path: 'update', component: UpdateCategoryComponent}
    ]}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
