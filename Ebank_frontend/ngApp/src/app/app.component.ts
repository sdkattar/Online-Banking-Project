import { Component } from '@angular/core';
import { EmtrService } from './emtr.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 
  isLogin:boolean;

  constructor(private emservice:EmtrService,public router:Router)
  {
    if(sessionStorage['id']!=undefined)
    {
      this.isLogin=true;
    }

  }

  ngOnInit() {

    this.emservice.getEmittedValueForLogbtnSwitch()
      .subscribe(item => this.isLogin=item);
   
  }

  

  logout(){
    alert("Do you want to logout ?");
    this.isLogin=false;
   
    delete sessionStorage['email'];
    delete sessionStorage['role'];
    delete sessionStorage['id'];
    delete sessionStorage['name'];
    this.router.navigate(['login']);
    
  }
  
}
