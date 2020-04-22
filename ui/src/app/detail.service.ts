import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class DetailService {

  private baseUrl = '/api/';

  constructor(private http:HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'categoriesList');
  }

  getKeywords(categoriesList: object[]): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'KeyWordsByCategories', categoriesList);
  }

  getDescriptionList(keywordsList: object[]): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'scenarious', keywordsList);
  }
  
}                                           
