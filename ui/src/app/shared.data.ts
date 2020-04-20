import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class SharedData {
    public data: any;
    constructor() {
        this.data = [];
    }
}
