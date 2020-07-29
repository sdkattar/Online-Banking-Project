import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule,Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';


import { HttpClientModule } from '@angular/common/http';

import { AddComponent } from './add/add.component';
import { LoginComponent } from './login/login.component';
import { NoShowComponent } from './no-show/no-show.component';
import { AboutComponent } from './about/about.component';
import { HelpComponent } from './help/help.component';
import { DashboardComponent } from './dashboard/dashboard.component';

import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { UserserviceService } from './userservice.service';

import { SetpassComponent } from './setpass/setpass.component';
import { ManagerdashboardComponent } from './managerdashboard/managerdashboard.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { AddmanagerComponent } from './addmanager/addmanager.component';
import { CustomerdetailsComponent } from './customerdetails/customerdetails.component';
import { ShowmanagerComponent } from './showmanager/showmanager.component';
import { AddcustomerComponent } from './addcustomer/addcustomer.component';
import { BackupComponent } from './backup/backup.component';
import { PostnewsComponent } from './postnews/postnews.component';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { ShowcustomerrequestComponent } from './showcustomerrequest/showcustomerrequest.component';
import { ShowcardrequestComponent } from './showcardrequest/showcardrequest.component';
import { ShowcustomerdetailsComponent } from './showcustomerdetails/showcustomerdetails.component';
import { CheckbalanceComponent } from './checkbalance/checkbalance.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { FundtransferComponent } from './fundtransfer/fundtransfer.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { EditbyadminComponent } from './editbyadmin/editbyadmin.component';
import { EditmanagerComponent } from './editmanager/editmanager.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
  
    ContactComponent,
    //AuthService,
    AddComponent,
   
  LoginComponent,
    NoShowComponent,
    AboutComponent,
    HelpComponent,
    DashboardComponent,
    
    ForgotpasswordComponent,
    

    
    SetpassComponent,
    
    ManagerdashboardComponent,
    
    CustomerdashboardComponent,
    
    AddmanagerComponent,
    
    CustomerdetailsComponent,
    
    ShowmanagerComponent,
    
    AddcustomerComponent,
    
    BackupComponent,
    
    PostnewsComponent,
    
    LoanrequestComponent,
    
    ShowcustomerrequestComponent,
    
    ShowcardrequestComponent,
    
    ShowcustomerdetailsComponent,
    
    CheckbalanceComponent,
    
    EditprofileComponent,
    
    FundtransferComponent,
    
    CreateaccountComponent,
    
    EditbyadminComponent,
    
    EditmanagerComponent
  ],
  imports: [ 
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
   
    FormsModule,
    RouterModule.forRoot([
      {path: "", component: LoginComponent},
      {path:'home',component:HomeComponent},
      {path:'contact',component:ContactComponent},
      {path:'about',component:AboutComponent},
      {path:'add',component:AddComponent},
      {path:'forgotpassword',component:ForgotpasswordComponent},
      {path:'setpass',component:SetpassComponent},
      {path: 'login', component:LoginComponent},
      {path: 'forgotpassword', component:ForgotpasswordComponent},
      {path:"dash",component:DashboardComponent, children:[{path: 'addmanager', component:AddmanagerComponent},
                                                           {path: 'customerdetails', component:CustomerdetailsComponent},
                                                           {path: 'showcustomerdetails', component:ShowcustomerdetailsComponent},
                                                           {path: 'showmanager', component:ShowmanagerComponent},
                                                           {path: 'addcustomer', component:AddcustomerComponent},
                                                           {path: 'editmanager', component:EditmanagerComponent},
                                                           {path: 'postnews', component:PostnewsComponent},
                                                           {path: 'editbyadmin', component:EditbyadminComponent},
                                                          ]},

      {path: 'managerdashboard', component:ManagerdashboardComponent, children:[{path: 'customerdetails', component:CustomerdetailsComponent},
                                                                                {path: 'loanrequest', component:LoanrequestComponent},
                                                                                {path: 'showcustomerrequest', component:ShowcustomerrequestComponent},
                                                                                {path: 'showcardrequest', component:ShowcardrequestComponent}
                                                                                ]},

      {path: 'customerdashboard', component:CustomerdashboardComponent, children:[{path: 'checkbalance', component:CheckbalanceComponent},
                                                                                {path: 'editprofile', component:EditprofileComponent},
                                                                                {path: 'fundtransfer', component:FundtransferComponent},
                                                                                {path: 'createaccount', component:CreateaccountComponent}
                                                                                ]},

      {path:'**',component:NoShowComponent}
    ])
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor()
  {
//    alert("sdf fdgfc");
    console.log("app module created");
  }
}
