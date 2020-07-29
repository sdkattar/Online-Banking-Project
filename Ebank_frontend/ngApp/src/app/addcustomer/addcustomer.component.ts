import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addcustomer',
  templateUrl: './addcustomer.component.html',
  styleUrls: ['./addcustomer.component.css']
})
export class AddcustomerComponent implements OnInit {

  constructor(public userservice:UserserviceService,public router:Router) { }

  addCustomer(myForm)
  {
    let user = myForm.form.value;
    console.log(user);
    this.userservice.register(user).subscribe((res)=>{
      alert("Customer Added successfully...!!!");
    this.router.navigate(['dash']);


    
    },(error)=>{
alert("something went wrong");
    }
)
  }

  ngOnInit() {
  }

}
