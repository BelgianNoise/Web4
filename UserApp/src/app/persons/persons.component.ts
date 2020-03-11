import { Component, OnInit } from '@angular/core';
import { PersonComponent} from '../person/person.component';
import { timer} from 'rxjs';
import { PersonserviceService} from '../personservice.service';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  users: PersonComponent[];
    selectedUser: PersonComponent;
    
  constructor(public service: PersonserviceService) { }


  getUsers(): void{
    timer(0,2500)
      .subscribe(() => {
        this.service.getUsers().subscribe(data => this.users = data);
      });
  }
  ngOnInit() {
    this.getUsers();
  }
    select(userr){
        this.selectedUser = userr;
        console.log(this.selectedUser.firstname)
    }
}
