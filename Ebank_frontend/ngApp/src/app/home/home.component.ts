import { Component, OnInit } from '@angular/core';

import { Router,ActivatedRoute } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
 
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  news:any;
  constructor(public router:Router,
    public userservice:UserserviceService,
    ) { 
this.getNews();
    
  }

  getNews()
  {
    
    this.userservice.getNews().subscribe((res)=>{
      console.log(res);
      this.news=res;
      debugger;
    },
      (err)=>{
        console.log(err);
      })
  }

  ngOnInit() 
  {
   
 
  }

  

 

  


}
