/* SEGUNDO TRABAJO:  Sofware registro DESAFIO 2023
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/
package trabajofinal;

public class Pila
{
    private Nodo tope;
    
    public Pila()
    {        
        this.tope = null;
    }
    
    public void apilar(Persona persona)
    {
        Nodo p = new Nodo(persona);
        p.setNodo(this.tope);
        this.tope = p;       
    }
    
    public Persona desapilar()
    {
        if(isPilaVacia()){
            throw new RuntimeException("La pila ya está vacía");
        }
        Persona persona = tope.getPersona();
        tope = tope.getNodo(); 
        return persona;  
    }    
    
    public boolean isPilaVacia()
    {
        return this.tope == null;
    }
    
}
