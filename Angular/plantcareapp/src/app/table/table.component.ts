import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Plant } from '../plant';
import { PlantService } from '../plant.service';

@Component({
    selector: 'plant-table',
    templateUrl: './table.component.html',
    styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit{

    public plants: Plant[] = [];

    constructor(private plantService: PlantService) {}

    ngOnInit() {
        this.getPlants();
    }

    public getPlants(): void {
        this.plantService.getPlants().subscribe(
            (response: Plant[]) => {
                this.plants = response;
                this.plants.sort((a, b) => this.compareStatus(a, b) ? 1 : -1);
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        );
    }

    public addNewPlants(file): void {
        let dataFile = file.target.files[0];
        let reader = new FileReader();
        reader.readAsText(dataFile);
        let JSONstr = null;
        let localService = this.plantService;
        reader.onload = function() {
            JSONstr = reader.result;
            localService.addNewPlants(JSONstr).subscribe(
                (response: String) => {
                    window.location.reload();
                },
                (error: HttpErrorResponse) => {
                    alert(error.message);
                }
            );
        }  
    }

    public compareStatus(a: Plant, b: Plant) {
        let a_lastWateredDay = parseInt(a.lastWateredDate.split(" ")[0]);
        let a_wateringFreq = parseInt(a.wateringFreq.split(" ")[1]);
        let a_difference = a_lastWateredDay - a_wateringFreq;

        let b_lastWateredDay = parseInt(b.lastWateredDate.split(" ")[0]);
        let b_wateringFreq = parseInt(b.wateringFreq.split(" ")[1]);
        let b_difference = b_lastWateredDay - b_wateringFreq;

        return a_difference < b_difference;
    }
}