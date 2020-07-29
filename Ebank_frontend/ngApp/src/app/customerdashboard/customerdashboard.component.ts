import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent implements OnInit {

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
