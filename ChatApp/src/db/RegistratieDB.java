package db;

import domain.OPORegistratie;

import java.util.ArrayList;
import java.util.List;

public class RegistratieDB {
  List<OPORegistratie> opos;

  public RegistratieDB(){
    opos = new ArrayList<>();
    opos.add(new OPORegistratie("Elke",
            "Web4", "2018-2019"));
  }
  public List<OPORegistratie> getAll(){
    return this.opos;
  }
  public void addRegistratie(OPORegistratie opo){
    this.opos.add(opo);
  }
}
