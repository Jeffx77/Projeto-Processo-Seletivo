package Candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo{
    public static void main(String[] args) {
        String[]candidatos ={"JEFFERSON","GABRIELE","GUILHERME","MARCOS","CRISTIANO"};
        for (String candidato:candidatos){
            entrandoContato(candidato);
            imprimirSelecionados();
            selecaoCandidatos();
            
            // NENHUM DOS METODOS ESTAO ANINHADOS OBJETIVO APENAS DE ENTENDER O CASE

        }
    
    }
    static void entrandoContato(String candidato){
        int tentativasRealizadas = 1 ;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu=atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato Realizado com Sucessso !");


        }
        while(continuarTentando && tentativasRealizadas < 3);
        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM" + candidato + " NA " + tentativasRealizadas + "TENTATIVA" );
        else
            System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidato+ ", NUMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas);
    }
    //metodo auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String[]candidatos ={"JEFFERSON","GABRIELE","GUILHERME","MARCOS","CRISTIANO"};
        for (String candidato:candidatos){
            System.out.println("o candidato selecionado foi " + candidato);
        }

    }
    public static void selecaoCandidatos() {
        //Array com a lista de candidatos

        String[]candidatos ={"JEFFERSON","GABRIELE","GUILHERME","MARCOS","CRISTIANO","JHONATAN","LUCIANO","ROGERIO","WELLINGTON","RAFAEL"};
        int candidatosSelecionados=0;
        int candidatoAtual = 0;
        double salarioBase=2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato=candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato " + candidato + " Solicitou esse valor de salario " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O Candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados ++ ;
            }
            candidatoAtual++;

        }
        
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        else if(salarioBase == salarioPretendido){
            System.out.println("FAZER UMA CONTRA PROPOSTA");    
        }
        else{ 
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}