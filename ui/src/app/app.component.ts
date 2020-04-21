import { Component, Input } from '@angular/core';
import {FormControl} from '@angular/forms';
import {DetailService } from './detail.service';
import {SharedData} from './shared.data'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FormSubmit';

  constructor(private detailService:DetailService, private sharedData: SharedData) { }

  dropdownSettings = {};
  items=[{id:1, title:'Categories', xpandStatus:false, dataList:[], selectedItems: new Map<string, Array<any>>()}];
  displayLogic = function(){
    if(this.items[0].selectedItems[1].length >0 && this.items.length==1){
      this.detailService.getKeywords(this.items[0].selectedItems[1]).subscribe(data =>{
          this.items.push({id:2, title:'Items', xpandStatus:false, dataList:data, selectedItems: new Map<string, Array<any>>()});
      })
    } else if(this.items[0].selectedItems[1].length==0 && this.items.length==2){
      this.items.pop();
    } else{
      this.sharedData.data = this.items[1].selectedItems[2];
    }
  };
  ngOnInit(){
      //this.selectedCatItems = new Map<string, Array<any>>();
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

      //console.log(this.selectedCatItems)          
    }

    

    onItemSelect(ii:any){
       this.displayLogic();
    }
    OnItemDeSelect(ii:any){
       this.displayLogic();
    }
    onSelectAll(ii: any){
        this.displayLogic();
    }
    onDeSelectAll(ii: any){
        this.displayLogic();
    }
}
