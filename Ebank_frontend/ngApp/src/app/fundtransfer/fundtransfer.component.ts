import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fundtransfer',
  templateUrl: './fundtransfer.component.html',
  styleUrls: ['./fundtransfer.component.css']
})
export class FundtransferComponent implements OnInit {
user:any;
customers:any;

  constructor(public userservice:UserserviceService,public router:Router) 
  { 
    this.getAccount(sessionStorage['id']);
    if(sessionStorage['email']==undefined)
    {
      this.router.navigate(['login']);
    }
  }

  ngOnInit() {
  }

  getAccount(uid)
  {
  
    this.userservice.checkBalance(uid).subscribe((res)=>{
      console.log("RES: "+res);
      this.customers=res;
      console.log(this.customers);
    },
      (err)=>{
        console.log(err);
      })
  }

  transfermoney(myform)
  {
    let data = myform.form.value;
    alert(data);
    console.log(data);
    this.userservice.transfermoney(data).subscribe(res=>{
      console.log(res);
      alert("Money transfered successfully...");
      this.router.navigate(['customerdashboard']);
    },(error)=>{
      console.log(error);
      alert("Something went wrong while money transfer");
      
    })
    
  }

}
