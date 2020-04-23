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
  title = 'Home';

  constructor(private detailService:DetailService, private sharedData: SharedData) { }

  dropdownSettings = {};
  items=[{id:1, title:'Categories', xpandStatus:false, dataList:[], selectedItems: new Map<string, Array<any>>()}];
  isDisabled = true;
  displayLogic = function(id){
    if(this.items[0].selectedItems[1].length >0 && this.items.length==1){
      this.detailService.getKeywords(this.items[0].selectedItems[1]).subscribe(data =>{
          this.items.push({id:2, title:'Items', xpandStatus:false, dataList:data, selectedItems: new Map<string, Array<any>>()});
      })
    } else if(this.items[0].selectedItems[1].length==0 && this.items.length==2){
      this.items.pop();
      this.isDisabled = true;
    } else if( id==1 && this.items.length==2 ){
      this.items[1].selectedItems = new Map<string, Array<any>>();
      this.detailService.getKeywords(this.items[0].selectedItems[1]).subscribe(data =>{
        this.items[1].dataList = data;
      })
    } else if(id==2 && this.items[1].selectedItems[2].length>0){
      this.isDisabled = false;
      this.sharedData.data = this.items[1].selectedItems[2];
    }
  };
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
