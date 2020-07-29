import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  user:any;

  constructor(public userservice:UserserviceService,public router:Router,public activeroute:ActivatedRoute)
   { 
    this.userservice.getDataById(sessionStorage['id']).subscribe((res)=>{
      
      this.user = res;
      
     // alert("User data received by ID:"+sessionStorage['id']);
     if(sessionStorage['email']==undefined)
     {
       this.router.navigate(['login']);
     } 

      },(err)=>{
        alert("Error in getting data by id..");
      })

      if(sessionStorage['email']==undefined)
     {
       this.router.navigate(['login']);
     } 
  }

  ngOnInit() {
  }

  update(myform)
  {
    let data = myform.form.value;
    this.userservice.update(data).subscribe(res=>{
      console.log(data);
      alert("Your profile updated successfully.");
      this.router.navigate(['customerdashboard']);
    },(error)=>{
      console.log(data);
      alert("Something went wrong while updating profile");
      
    })
    
  }
}

