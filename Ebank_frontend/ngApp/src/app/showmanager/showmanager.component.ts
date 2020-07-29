import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-showmanager',
  templateUrl: './showmanager.component.html',
  styleUrls: ['./showmanager.component.css']
})
export class ShowmanagerComponent implements OnInit {
  managers: any;
  constructor(public userservice:UserserviceService, public router:Router) 
  { 
    this.getManagers();
    if(sessionStorage['email']==undefined)
    {
      this.router.navigate(['login']);
    }
  }

  ngOnInit() {
  }

  getManagers()
  {
    this.userservice.getManagers().subscribe((res)=>{
      console.log(res);
      this.managers=res;
    }, (err)=>{
      console.log(err);
    })
  }

  editUser(id)
  {
    alert(id);
    this.router.navigate(['dash/editmanager'],{queryParams:{"id":id}});
  }
}
