import { Component, OnInit } from '@angular/core';
import {DetailService } from '../detail.service';
import { Observable,Subject } from "rxjs";
import { SharedData } from '../shared.data';
import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-detail-list',
  templateUrl: './detail-list.component.html',
  styleUrls: ['./detail-list.component.css']
})
export class DetailListComponent implements OnInit {

 constructor(private detailService:DetailService, private sharedData:SharedData) { }

  detailArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();

  deleteMessage=false;
  detaillist:any;
  isupdated = false;    
 

  ngOnInit() {
    this.isupdated=false;
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };
     this.detailService.getDescriptionList(this.sharedData.data)
      .subscribe(
        data => {
          this.detaillist=data           
        },
        error => console.log(error));
  }

  changeisUpdate(){
    this.isupdated=false;
  }
}
