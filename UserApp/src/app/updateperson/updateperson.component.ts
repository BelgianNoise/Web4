import { Component, OnInit, Input } from '@angular/core';
import { PersonserviceService} from '../personservice.service';

@Component({
  selector: 'app-updateperson',
  templateUrl: './updateperson.component.html',
  styleUrls: ['./updateperson.component.css']
})
export class UpdatepersonComponent implements OnInit {
    
    @Input() user;
    @Input() service;
    
  constructor() { }

  ngOnInit() {
  }

    update(): void{
    console.log('in update '+this.user.userId +
               this.user.firstname);
    this.service.updatePerson(this.user.userId,
    this.user.firstname,this.user.lastname,
        this.user.geslacht,
        this.user.leeftijd);
        console.log('update sent to service');
    }

}
