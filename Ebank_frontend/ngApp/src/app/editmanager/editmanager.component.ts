import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-editmanager',
  templateUrl: './editmanager.component.html',
  styleUrls: ['./editmanager.component.css']
})
export class EditmanagerComponent implements OnInit {
 id:any;
 user:any;
  constructor(public userservice:UserserviceService,public router:Router, public route:ActivatedRoute) 
  { 
    route.queryParams.subscribe((params)=>{
      this.id=params.id;
      alert(this.id);
    })

    this.userservice.getDataById(this.id).subscribe((res)=>{
      
      this.user = res;
      
     // alert("User data received by ID:"+sessionStorage['id']);
      
      },(err)=>{
        alert("Error in getting data by id..");
      })
  }

  ngOnInit() {
  }

  editManager(myform)
  {
    let data = myform.form.value;
    this.userservice.edit(data).subscribe(res=>{
      console.log(data);
      alert("User profile updated successfully....");
      this.router.navigate(['dash/showmanager']);
    },(error)=>{
      console.log(data);
      alert("Something went wrong while updating profile");
      
    })
  }

}
