/* SEGUNDO TRABAJO:  Sofware registro DESAFIO 2023
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/
package trabajofinal;

import javax.swing.JOptionPane;

public class Lista 
{
    private Nodo cabeza;
    
    public Lista()
    {
        this.cabeza = null;
    }
    
    public void agregarPersona(Persona persona)
    {
        Nodo p = new Nodo(persona);
        if (this.cabeza == null || persona.getEdad() < this.cabeza.getPersona().getEdad())
        {
            p.setNodo(this.cabeza);
            this.cabeza = p;
        } else 
            {
                Nodo x = this.cabeza;
                while(x.getNodo()!= null && persona.getEdad() >= x.getNodo().getPersona().getEdad())
                {
                    x = x.getNodo();
                }
                p.setNodo(x.getNodo());
                x.setNodo(p);
            }
    }
    
    public void imprimiListaPorConsola()
    {
        Nodo p = this.cabeza;
        String datosParticipantes = "";
        if (p != null) 
        {
            while(p != null)
            {   
                datosParticipantes= datosParticipantes + "* "+ "Nombre: "+ p.getPersona().getNombre()
                 + "  Sexo: " + p.getPersona().getSexo()+ "  Edad: " + p.getPersona().getEdad() + "\n";
                p = p.getNodo();
            }
            JOptionPane.showMessageDialog(null, "LISTA DE PARTICIPANTES POR EDAD\n" + "\n"+ 
                    datosParticipantes,"Lista ascendente de Participantes",
            JOptionPane.INFORMATION_MESSAGE);
        }
        else
             {
              JOptionPane.showMessageDialog(null,"No hay participantes registrados",
                 "Registro vacío", JOptionPane.INFORMATION_MESSAGE);
             }
    }
    
    public boolean isParidadDeGenero()
    {
        return cantidadPersonasPorSexo('M') == cantidadPersonasPorSexo('H');
    } 
    
    public int cantidadPersonasPorSexo(char sexo)
    {
        Nodo p = this.cabeza;
        int cantidadPersonas = 0;
        while(p != null){
            if(p.getPersona().getSexo() == sexo){cantidadPersonas++;}
            p = p.getNodo();
        }
        return cantidadPersonas;
    }

    public Pila obtenerPilaPersonasPorSexo(char sexo)
    {
        Nodo p = this.cabeza;
        Pila pila = new Pila();
        while(p != null){
            if(p.getPersona().getSexo() == sexo){
                pila.apilar(p.getPersona());
            }
            p = p.getNodo();
        }
        return pila;
    }
    
}

