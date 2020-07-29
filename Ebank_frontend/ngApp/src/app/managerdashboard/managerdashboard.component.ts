import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-managerdashboard',
  templateUrl: './managerdashboard.component.html',
  styleUrls: ['./managerdashboard.component.css']
})
export class ManagerdashboardComponent implements OnInit {

  constructor(public router:Router) {

    if(sessionStorage['email']==undefined)
  {
    this.router.navigate(['login']);
  }
   }

   name = sessionStorage['name'];

  ngOnInit() {
  }

}
