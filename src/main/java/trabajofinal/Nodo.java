/* SEGUNDO TRABAJO:  Sofware registro DESAFIO 2023
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/
package trabajofinal;

public class Nodo 
{
    private Persona persona;
    private Nodo nodo;    
    
    public Nodo(Persona persona)
    {
        this.persona = persona;
        this.nodo = null;
    } 

    public Persona getPersona() 
    {
        return persona;
    }

    public Nodo getNodo() 
    {
        return nodo;
    }

    public void setNodo(Nodo nodo)
    {
        this.nodo = nodo;
    }  
    
}
