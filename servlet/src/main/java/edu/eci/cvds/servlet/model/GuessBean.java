
package edu.eci.cvds.servlet.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.SessionScoped;

@Component
@ManagedBean(name = "guessBean")
@SessionScoped
public class GuessBean implements Serializable{
    @Autowired
    ConfigurationService configurationService;
    public ArrayList<Integer> historial;
    private int premioBase;
    private int premioActual;
    private String estado;
    private Random random;
    private int numeroAdivinar;
    private int numeroIntentos;
    private int intento;


    public GuessBean(){
        estado = "Sin Ganador";
    }
    public int getPremioActual(){return premioActual;}
    public int getPremioBase() {
        return premioBase;
    }
    public String getEstado() {
        return estado;
    }
    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }
    public int getNumeroIntentos(){
        return this.numeroIntentos;
    }
    public int getIntento(){
        return intento;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }
    public void setIntento(int a){
        this.intento = a;
    }

    public ArrayList<Integer> getHistorial(){
        return historial;
    }
    public void setHistorial(ArrayList<Integer> historial) {
        this.historial = historial;
    }

    public void guess(){
        if(numeroIntentos == 0){
            estado = "Comienza";
        }
        if(estado.equals("Comienza")){
            if(numeroAdivinar == intento){
                estado = "Gano: " + premioActual;
                restart();
            }
            else{
                premioActual -= 1000;
                estado = "Comienza";
                historial.add(0,premioActual);
                if (premioActual <= 0){
                    estado = "Perdiste Vulvelo a intentar";
                    restart();
                }
            }
            numeroIntentos++;
        }
   }
   @Bean
   public CommandLineRunner premio(){
        return args -> {
            configurationService.addConfiguration(new Configuration("Premio","100000"));
            configurationService.getAllConfiguration().forEach(configuration -> System.out.println(configuration));
            premioBase = Integer.parseInt(configurationService.getConfiguration("Premio").getValor());
            restart();
        };
   }
    public void restart(){
        random = new Random();
        numeroAdivinar = random.nextInt(16) ;
        numeroIntentos = 0;
        intento = 0;
        premioActual = premioBase;
        historial = new ArrayList<>();
    }

}
