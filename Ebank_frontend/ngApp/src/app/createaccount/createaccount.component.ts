import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-createaccount',
  templateUrl: './createaccount.component.html',
  styleUrls: ['./createaccount.component.css']
})

export class CreateaccountComponent implements OnInit {
  uid=sessionStorage['id'];
  

  constructor(public router:Router, public userservice:UserserviceService) {
    if(sessionStorage['email']==undefined)
    {
      this.router.navigate(['login']);
    }
   }

  ngOnInit() {
  }

  createAccount(myForm){

    let user = myForm.form.value;
    console.log(user);
    this.userservice.createAccount(user).subscribe((res)=>{
      alert("Account Created");
    this.router.navigate(['customerdashboard']);


    
    },(error)=>{
alert("something went wrong");
    }
)

   

  }

}
