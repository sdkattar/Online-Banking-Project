import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkbalance',
  templateUrl: './checkbalance.component.html',
  styleUrls: ['./checkbalance.component.css']
})
export class CheckbalanceComponent implements OnInit {
 uid=sessionStorage['id'];

  constructor(public userservice:UserserviceService,public router:Router)
   {
    this.getBalance(this.uid);
    if(sessionStorage['email']==undefined)
    {
      this.router.navigate(['login']);
    }
   }
customers:any;

  getBalance(uid)
  {
  
    this.userservice.checkBalance(uid).subscribe((res)=>{
      console.log("RES: "+res);
      this.customers=res;
      console.log(this.customers);
      alert("check Balance executed...");
    },
      (err)=>{
        console.log(err);
      })
  }
  
  goBack()
  {
    this.router.navigate(['customerdashboard']);
  }

  ngOnInit() 
  {
  }

}


