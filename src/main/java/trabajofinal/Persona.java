/* SEGUNDO TRABAJO:  Sofware registro DESAFIO 2023
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/
package trabajofinal;

public class Persona 
{
    private String nombre;
    private char sexo;
    private int edad;   
    
    public Persona(String nombre, char sexo, int edad)
    {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public char getSexo() 
    {
        return sexo;
    }

    public int getEdad() 
    {
        return edad;
    }  
        
}
