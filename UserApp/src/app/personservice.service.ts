import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { PersonComponent} from './person/person.component';

@Injectable({
  providedIn: 'root'
})
export class PersonserviceService {

  private getusersUrl = 'http://localhost:8080/Controller?action=getUsers';
  private updateUser = 'http://localhost:8080/Controller?action=updateUser';


  constructor(private http: HttpClient) { }

  getUsers(): Observable<PersonComponent[]>{
      return this.http.get<PersonComponent[]>(this.getusersUrl);
  }
    updatePerson(userId, firstname, lastname, geslacht, leeftijd) {
        console.log(''+ userId +firstname);
        console.log('in serivce');
        var linkie = 'http://localhost:8080/Controller?action=updateUser&userId='+
userId+'&firstname='+firstname+'&lastname='+lastname+'&geslacht='+geslacht+'&leeftijd='+leeftijd;
        console.log(linkie);
        this.http.post(linkie, '')
        .subscribe(res => {
            console.log('epische post werkt');
        }, err => {
            console.log('error bij epische post');
        });
    }

}
