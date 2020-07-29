import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-setpass',
  templateUrl: './setpass.component.html',
  styleUrls: ['./setpass.component.css']
})
export class SetpassComponent implements OnInit {

  msg:string;
flag:boolean;
  constructor(public service:UserserviceService,public router:Router) { }

 
  updatepass(data)
  {
    this.service.setpass(data).subscribe((result)=>{
      console.log(result);
      if(result){
        this.msg="successfully changed password";
        this.flag=true;
        // this.router.navigate(['login']);
      }
      else{
        this.flag=false
        this.msg="Enter valid OTP";
      }
    })
    console.log("hi");
    console.log(data);
  }

  navigate()
  {
    this.router.navigate(['login']);
  }

  ngOnInit() {
  }


}
