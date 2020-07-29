import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addmanager',
  templateUrl: './addmanager.component.html',
  styleUrls: ['./addmanager.component.css']
})
export class AddmanagerComponent implements OnInit {

  constructor(public userservice:UserserviceService,public router:Router) {
    if(sessionStorage['email']==undefined)
    {
      this.router.navigate(['login']);
    }
   }

  addmanager(myForm)
  {
    let user = myForm.form.value;
    console.log(user);
    this.userservice.register(user).subscribe((res)=>{
      alert("Manager Added successfully...!!!");
    this.router.navigate(['dash']);


    
    },(error)=>{
alert("something went wrong");
    }
)
  }
  ngOnInit() {
  }

}
