/* SEGUNDO TRABAJO:  Sofware registro DESAFIO 2023
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/
package trabajofinal;

import javax.swing.JOptionPane;

public class Programa 
{
  
    private Lista lista;
    private Pila mujeres;
    private Pila hombres;
    private Pila hombresAuxiliar;
    
    public Programa()
    {
        this.lista = new Lista();
        this.mujeres = null;
        this.hombres = null;
        this.hombresAuxiliar = null;
    }
    
    public void run()
    {
        int opcion = 0;
        String nombre; 
        char sexo;
        int edad;
       
       do
       {
          try
          {
              opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                      "INSCRIPCIONES DESAFIO 2023\n" + "\n"+
                      "1. Registrar participante\n"
                               + "2. Imprimir lista de participantes\n"
                               + "3. Imprimir las parejas formadas\n"
                               + "4. Salir\n" + "\n"
                               + "¿Qué deseas hacer?", "Registro audiciones DESAFIO 2023",
                               JOptionPane.INFORMATION_MESSAGE));
              switch(opcion)
              {
                  case 1: 
                         edad = Integer.parseInt(JOptionPane.showInputDialog(null,
                                 "Ingrese la edad del participante","Registro de Participante",
                                 JOptionPane.INFORMATION_MESSAGE));
                         if (edad>=18)
                                 {                                    
                                       nombre = (JOptionPane.showInputDialog(null,
                                            "Ingresa el nombre del participante", "Nombre Agregado",
                                            JOptionPane.INFORMATION_MESSAGE));
                                       sexo = (JOptionPane.showInputDialog(null,
                                               "Seleccione el sexo del participante", "Selección de Sexo: ",
                                               JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Hombre", "Mujer"},
                                               "Hombre")).toString().charAt(0);
                                       lista.agregarPersona(new Persona(nombre,sexo,edad));
                                     
                                 } else {
                                            JOptionPane.showMessageDialog(null,"El participante es menor de edad: "
                                            + edad +" años" + "\n" + "Inténtalo en próximos DESAFIOS", "Error - Validación de Edad", JOptionPane.INFORMATION_MESSAGE);
                                        }           
                        break;
                  case 2:
                        lista.imprimiListaPorConsola();                  
                        break;                 
                  case 3:
                      
                          if(lista.isParidadDeGenero())
                          {
                                this.mujeres = lista.obtenerPilaPersonasPorSexo('M');
                                this.hombres = lista.obtenerPilaPersonasPorSexo('H');
                                this.generarPilaHombresAuxiliar();
                                imprimirResultadoParejas();
                          } else 
                                {
                                    JOptionPane.showMessageDialog(null,"La lista no contiene paridad de género\n"+ "\n"
                                       + "Hombres = " + lista.cantidadPersonasPorSexo('H')+ "\n"
                                        + "Mujeres = " + lista.cantidadPersonasPorSexo('M')+ "\n\n"
                                        + "Por favor Ingrese el participante del sexo faltante","Error de Paridad",
                                    JOptionPane.INFORMATION_MESSAGE);
                                }
                      
                        break;
                  case 4:
                      JOptionPane.showMessageDialog(null,"Aplicación finalizada",
                              "Salir del programa", JOptionPane.INFORMATION_MESSAGE);
                         break;
                     
                    default:
                        JOptionPane.showMessageDialog(null,"La opción seleccionada no es valida\n" + "\n"
                                + "Intente nuevamente", "Error - Intente nuevamente", JOptionPane.INFORMATION_MESSAGE);         
                 }
            } catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null,"La opción seleccionada no es valida\n" + "\n"
                                + "Intente nuevamente","Opción invalida", JOptionPane.INFORMATION_MESSAGE);
                    }
        } while (opcion != 4);
    }
    
    private void generarPilaHombresAuxiliar()
    {
        this.hombresAuxiliar = new Pila();
        while (!hombres.isPilaVacia())
        {
            this.hombresAuxiliar.apilar(hombres.desapilar());
        }
    }    
    
    private void imprimirResultadoParejas()
    {   
        String parejas ="";
        if (!hombresAuxiliar.isPilaVacia())
        {
            while (!hombresAuxiliar.isPilaVacia())
            {
                parejas = parejas + "* " + this.hombresAuxiliar.desapilar().getNombre() + " con "
                        + this.mujeres.desapilar().getNombre() + "\n";
            }
            JOptionPane.showMessageDialog(null, "PAREJAS DE PARTICIPANTES\n"+ "\n"
             + parejas,"Parejas conformadas", JOptionPane.INFORMATION_MESSAGE);
        }
        else
             {
                 JOptionPane.showMessageDialog(null,"No hay participantes registrados",
                "Registro vacío", JOptionPane.INFORMATION_MESSAGE);
             }
    }
    
    
}    
        
       

    
    