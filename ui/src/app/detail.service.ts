import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class DetailService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http:HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'categoriesList');
  }

  getKeywords(categoriesList: object[]): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'KeyWordsByCategories', categoriesList);
  }

  getDescriptionList(keywordsList: object[]): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'scenariousByKeyIds', keywordsList);
  }

  getDescriptionListByPattern(pattern: String): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'scenariousByKeyIdNamesLike', pattern);
  }

  getGenerateXml(idList: object[]): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'generateXml', idList);
  }
}
