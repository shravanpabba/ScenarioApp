import { Component, Input } from '@angular/core';
import {DetailService } from './detail.service';
import { Subject } from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Home';

  constructor(private detailService:DetailService) { }

  detailArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();
  deleteMessage=false;
  detaillist:any[] = [];
  isupdated = false;  
  hideDetail = true;
  pattern:any;
  checkBoxList: any[] = [];
  clickCheckBox = function(id){
    this.checkBoxList.push(id)
  }
  checkEnable = function(){
    if(this.pattern.length>0 || this.items[0].selectedItems[1].length>0 ){
      this.isDisabled=false;
    }else{
      this.isDisabled=true;
    }
  }
  dropdownSettings = {};
  items=[{id:1, title:'Categories', xpandStatus:false, dataList:[], selectedItems: new Map<string, Array<any>>()}];
  isDisabled = true;
  displayLogic = function(id){
    if(this.items[0].selectedItems[1].length >0 && this.items.length==1){
      this.detailService.getKeywords(this.items[0].selectedItems[1]).subscribe(data =>{
          this.items.push({id:2, title:'Keywords', xpandStatus:false, dataList:data, selectedItems: new Map<string, Array<any>>()});
      })
    } else if(this.items[0].selectedItems[1].length==0 && this.items.length==2){
      this.items.pop();
      // this.isDisabled = true;
      this.checkEnable();
    } else if( id==1 && this.items.length==2 ){
      this.items[1].selectedItems = new Map<string, Array<any>>();
      this.detailService.getKeywords(this.items[0].selectedItems[1]).subscribe(data =>{
        this.items[1].dataList = data;
      })
    } else if(id==2 && this.items[1].selectedItems[2].length>0){
      this.isDisabled = false;
    }
  };
  viewDetail = function() {
    this.checkBoxList=[];
      if(this.pattern && this.pattern.length>0 && this.items[1] && this.items[1].selectedItems[2] && this.items[1].selectedItems[2].length>0)
      {
       window.alert("Since you have selected both options so wild search is prioritised");
      }
    this.hideDetail = true 
    if(this.pattern && this.pattern.length >0){
      this.detailService.getDescriptionListByPattern(this.pattern)
        .subscribe(
          data => {
            this.detaillist = data    
            this.hideDetail = false       
          },
        error => console.log(error));
    } else {
      this.detailService.getDescriptionList(this.items[1].selectedItems[2])
        .subscribe(
          data => {
            this.detaillist = data    
            this.hideDetail = false       
          },
        error => console.log(error));
    }
  }

  generateXml = function() {
    this.detailService.getGenerateXml(this.checkBoxList)
      .subscribe(
        data => {
         console.log(data);      
        },
      error => console.log(error));
  
}
  ngOnInit(){
      this.items
      this.detailService.getCategories().subscribe(data =>{
          this.items[0].dataList = data;
      })

      this.dropdownSettings = {
          singleSelection: false,
          text:"Select",
          selectAllText:'Select All',
          unSelectAllText:'UnSelect All',
          enableSearchFilter: true,
          classes:"myclass custom-class"
      };

      this.isupdated=false;
      this.hideDetail = true;
      this.dtOptions = {
        pageLength: 6,
        stateSave:true,
        lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
        processing: true
      };
    }

    onItemSelect(ii:any, id){
       this.displayLogic(id);
    }
    OnItemDeSelect(ii:any, id){
       this.displayLogic(id);
    }
    onSelectAll(ii: any, id){
        this.displayLogic(id);
    }
    onDeSelectAll(ii: any, id){
        this.displayLogic(id);
    }
}
