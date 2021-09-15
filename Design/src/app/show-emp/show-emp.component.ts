import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-emp',
  templateUrl: './show-emp.component.html',
  styleUrls: ['./show-emp.component.css'],
})
export class ShowEmpComponent implements OnInit {
  employee: Observable<Employee[]>;
  emp: Observable<Employee[]>;
  constructor(
    private employeeservice: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.employee = this.employeeservice.getAllEmployee();
  }

  deleteemp(id: number) {
    this.employeeservice.deleteEmployee(id).subscribe(
      (data) => {
        // console.log(data);
        this.router.navigateByUrl('/employee_show');
        // this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  updateemp(id: number, name: String, email: String) {
    //console.log('id mali: ' + id + ' name: ' + name + ' email: ' + email);
    this.employeeservice.getEmployee(id).subscribe((data) => {
      console.log(data);
      this.router.navigateByUrl('/employee');
    });
  }
}
