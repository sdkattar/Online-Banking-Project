import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerdetails',
  templateUrl: './customerdetails.component.html',
  styleUrls: ['./customerdetails.component.css']
})
export class CustomerdetailsComponent implements OnInit {

  
  customers:any;
  constructor(public userservice:UserserviceService, public router:Router) { 
    this.getcustomers();
    if(sessionStorage['email']==undefined)
    {
      this.router.navigate(['login']);
    }


  }
  uid=sessionStorage['id'];
  
  getcustomers()
  {
    this.userservice.getData().subscribe((res)=>{
      console.log(res);
      this.customers=res;
      debugger;
    },
      (err)=>{
        console.log(err);
      })
  }

  deleteUser(uid)
  {
    this.userservice.deleteData(uid).subscribe((res)=>{
      console.log(res);
      alert("User Deleted...!!!");
      debugger;
    },
      (err)=>{
        console.log(err);
      })
  }

  editUser(id)
  {
    alert(id);
    this.router.navigate(['dash/editbyadmin'],{queryParams:{"id":id}});
  }

  ngOnInit()
  {
  }

}
