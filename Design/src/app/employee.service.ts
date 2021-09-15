import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private baseUrl = 'http://localhost:8081/api/emp';

  constructor(private http: HttpClient) {}

  createEmployee(employee: Object) {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  getAllEmployee(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getEmployee(id: number): Observable<any> {
    console.log('in emp method' + id);
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
