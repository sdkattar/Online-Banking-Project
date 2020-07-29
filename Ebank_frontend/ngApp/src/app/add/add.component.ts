import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

 

  constructor(public userservice:UserserviceService,public router:Router) {
    
   }

   register(myForm){

    let user = myForm.form.value;
    console.log(user);

let a=myForm.form.value.password;
   let b=myForm.form.value.confirmpassword;

   if(a!=b){
     document.getElementById("messages").innerHTML="password and confirm password doesn't match...";
   }

else{
    this.userservice.register(user).subscribe((res)=>{
      alert("Registration successfull...!!!");
    this.router.navigate(['login']);
    
    

    
    },(error)=>{
alert("something went wrong");
    }
)

   
  }
  }

  // checkpassword()
  //   {
  //     if(myForm.password==myForm.confirmpassword)
  //     {
  //     }
  //     else
  //     alert("Password does not match...!!!");
  //   }

  ngOnInit() {
  }
}
