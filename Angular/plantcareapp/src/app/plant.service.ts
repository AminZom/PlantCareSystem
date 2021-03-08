import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Plant } from './plant';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class PlantService {
    private apiServerUrl = environment.apiUrl;

    constructor(private http: HttpClient) { }


    public getPlants(): Observable<Plant[]> {
        return this.http.get<Plant[]>(`${this.apiServerUrl}/plants/all`);
    }

    public addNewPlants(plants: String): Observable<String> {
        console.log(plants);
        return this.http.post<String>(`${this.apiServerUrl}/plants/add`, plants);
    }
}