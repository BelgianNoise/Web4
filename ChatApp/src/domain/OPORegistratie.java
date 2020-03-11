package domain;

public class OPORegistratie {
  String naam, vak, academiejaar;

  public OPORegistratie(String n, String v, String aca){
    setNaam(n);
    setVak(v);
    setAcademiejaar(aca);
  }

  public String getNaam() {
    return naam;
  }

  public void setNaam(String naam) {
    if(naam == null || naam.trim().isEmpty()){
      throw new IllegalArgumentException("naam mag niet leeg zijn");
    }
    this.naam = naam;
  }

  public String getVak() {
    return vak;
  }

  public void setVak(String vak) {
    if(vak == null || vak.trim().isEmpty()){
      throw new IllegalArgumentException("vak mag niet leeg zijn");

    }
    this.vak = vak;
  }

  public String getAcademiejaar() {
    return academiejaar;
  }

  public void setAcademiejaar(String a) {
    if(a == null || a.trim().isEmpty()){
      throw new IllegalArgumentException("academiejaar mag niet leeg zijn");
    }
    this.academiejaar = a;
  }
}
