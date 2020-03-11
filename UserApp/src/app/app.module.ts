import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonComponent } from './person/person.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PersonsComponent } from './persons/persons.component';
import { UpdatepersonComponent } from './updateperson/updateperson.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    NavbarComponent,
    PersonsComponent,
    UpdatepersonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
      HttpClientModule,
      FormsModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
