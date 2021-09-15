import { EmployeeService } from './../employee.service';
import { Employee } from './../employee';
import { Component, OnInit } from '@angular/core';
import { ShowEmpComponent } from './../show-emp/show-emp.component';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
})
export class EmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  submitted = false;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {}

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService.createEmployee(this.employee).subscribe(
      (data) => {
        console.log(data);
      },
      (error) => console.log(error)
    );
    this.employee = new Employee();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
