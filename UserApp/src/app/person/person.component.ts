import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
  userId: string;
  firstname: string;
  lastname: string;
  geslacht: string;
  leeftijd: number;

  constructor() { }

  ngOnInit() {
  }

}
