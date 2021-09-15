import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Observable } from 'rxjs';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-emp',
  templateUrl: './update-emp.component.html',
  styles: [],
})
export class UpdateEmpComponent implements OnInit {
  emp: Observable<Employee[]>;
  constructor(
    private employeeservice: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  updateemp(id: number) {
    console.log(id);
    this.emp = this.employeeservice.getEmployee(id);
  }
}
