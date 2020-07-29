import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserserviceService {


  constructor(private http:HttpClient) { }

   //a:string="localhost";
  // a:string="a";
  register(user)
  {

    return this.http.post("http://localhost:8080/webProj1/user/signup",user);

  }


  login(user)
  {
    return this.http.post("http://localhost:8080/webProj1/user/login",user);
  }


  forgot(user)
  {
    return this.http.post("http://localhost:8080/webProj1/user/forgot",user);
  }

  GetOtp(email:string)
  {
    console.log(email.toString())
    return this.http.post("http://localhost:8080/webProj1/user/forgot/"+email,null);
  }

  setpass(data)
  {
    return this.http.post("http://localhost:8080/webProj1/user/setpass/",data);
  }

  getData()
  {
    return this.http.get("http://localhost:8080/webProj1/user");
    
  }

  getNews()
  {
    return this.http.get("http://localhost:8080/webProj1/user/news");
  }

  checkBalance(uid)
  {
    console.log("From Service: "+uid);
    // return this.http.get("http://192.168.43.136:8089/webProj1/user/account/"+uid);
    return this.http.get("http://localhost:8080/webProj1/user/allaccounts?uid="+uid);
  }

  getDataById(uid)
  {
    return this.http.get("http://localhost:8080/webProj1/user/getdatabyid?id="+uid);
  }
     
  update(user)
  {
    return this.http.put("http://localhost:8080/webProj1/user/update?id="+sessionStorage['id'],user);
  }

  createAccount(user)
  {
    return this.http.put("http://localhost:8080/webProj1/user/createaccount?id="+sessionStorage['id'],user);
  }

  deleteData(uid)
  {
    return this.http.delete("http://localhost:8080/webProj1/user/"+uid);
  }

  edit(user)
  {
    return this.http.put("http://localhost:8080/webProj1/user/editbyadmin?id="+user.id,user);
  }

  transfermoney(user)
  {
    console.log(user);
  return this.http.post("http://localhost:8080/webProj1/user/accountTransfer",user);
  }

  getManagers()
  {
    return this.http.get("http://localhost:8080/webProj1/user/showManagers");
  }
  
}
