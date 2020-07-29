import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {

  name:any;
  msg:any;
  constructor(public service:UserserviceService,public router:Router) { }

  ngOnInit() {
  }

  getotp(data)
  {
    console.log(data);
    this.service.GetOtp(data).subscribe((result:string)=>{
      this.msg="change pass";
      console.log(this.msg);
      
    },
    
    error=>{ 
      if(error.status===200){
      this.router.navigate(['setpass']);
    }
    else{
      this.msg="enter valid email"
      }
    })
  }
}
