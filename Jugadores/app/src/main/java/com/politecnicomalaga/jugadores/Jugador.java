package com.politecnicomalaga.jugadores;


public class Jugador
{
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String DNI;
    private String Email;
    private String Tfno;
    private int dorsal;

    //Constructor

    public Jugador (String Nombre,String Apellido1,String Apellido2,String DNI,String Email,String Tfno,int dorsal){

        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.DNI = DNI;
        this.Email = Email;
        this.Tfno = Tfno;
        this.dorsal = Math.abs(dorsal);


    }


    //Getter

    public String getNombre(){
        return Nombre;
    }
    public String getApellido1(){
        return Apellido1;

    }
    public String getApellido2(){
        return Apellido2;

    }
    public String DNI(){
        return DNI;

    }
    public String getEmail(){
        return Email;

    }
    public String getTfno(){
        return Tfno;

    }
    public int getdorsal(){
        return dorsal;
    }

    //Setter

    public void setNombre (String Nombre){
        this.Nombre = Nombre;

    }
    public void setApellido1(String Apellido1){
        this.Apellido1 = Apellido1;
    }
    public void setApellido2(String Apellido2){
        this.Apellido2 = Apellido2;
    }
    public void setDNI (String DNI){

        this.DNI = DNI;
    }
    public void setEmail (String Email){

        this.Email = Email;
    }
    public void setTfno (String Tfno){

        this.Tfno = Tfno;
    }
    public void setdorsal (int dorsal){

        this.dorsal =Math.abs(dorsal);
    }
    @Override
    public String toString(){
        String str = Nombre+",";
        str+=Apellido1+",";
        str+=Apellido2+",";
        str+=DNI+",";
        str+=Email+",";
        str+=Tfno+",";
        str+=dorsal;
        return str;
    }
}