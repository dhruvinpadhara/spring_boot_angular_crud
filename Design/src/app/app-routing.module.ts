import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { ShowEmpComponent } from './show-emp/show-emp.component';
import { UpdateEmpComponent } from './update-emp/update-emp.component';

const routes: Routes = [
  { path: 'employee', component: EmployeeComponent },
  { path: 'employee_show', component: ShowEmpComponent },
  { path: 'emp_update', component: UpdateEmpComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
