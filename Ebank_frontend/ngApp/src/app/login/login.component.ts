import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';
import { EmtrService } from '../emtr.service';
//import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  news:any;
  constructor(public router:Router,
              public userservice:UserserviceService,
              public emService:EmtrService) 
              { 
                this.getNews();
              }

              getNews()
              {
                
                this.userservice.getNews().subscribe((res)=>{
                  console.log(res);
                  this.news=res;
                  debugger;
                },
                  (err)=>{
                    console.log(err);
                  })
              }
            

  login(loginForm)
  {
    let data = loginForm.form.value;
    console.log(data);
   this.userservice.login(data).subscribe(res=>{
    sessionStorage['email']=res['email'];
    sessionStorage['role']=res['role'];
    sessionStorage['id']=res['id'];
    sessionStorage['name']=res['name'];
    

      this.emService.logInBtnSwitch(true);
    // this.router.navigate(['dash']);
    if(res['role']==='MANAGER')
    {
      this.router.navigate(['managerdashboard']);
    }

    else if(res['role']==='ADMIN')
    {
      this.router.navigate(['dash']);
    }

    else
    {
      this.router.navigate(['customerdashboard']);
    }

   },(err)=>{

    alert("Invalid username or password");
   })
  }




  ngOnInit() {
  }



}
