import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

    //Classe responsável pela execução e teste dos exercícios

    //É criado um laço de repetição que pergunta qual exercício o usuário deseja.
    //Enquanto o usuário não digitar 1 ou 2, o programa repetirá a pergunta.
    //Para sair do programa, basta clicar em cancelar.

    String resp;
        do {
            resp = JOptionPane.showInputDialog("Digite o exercício (1 ou 2)");

            if(resp.equals("1"))
                exercicio1();
            else
                exercicio2();

            resp = "0";

        }while(!(resp.equals("1")) && !(resp.equals("2")));
          

    }


    private static void exercicio1() {

        //Instanciação da pilha.
        Pilha pilha = new Pilha();

        //Pergunta a expressão ao usuário
        String resp = JOptionPane.showInputDialog("Digite a expressão");

        //Separa a expressão em caracteres para possibilitar sua análise.
        String[] caracteres = new String[resp.length()];
        caracteres = resp.split("");

        //Laço responsável por percorrer o vetor de caracteres.
        for(String caractere : caracteres) {

            //Para cada caractere serão analisados os seguintes casos:

            /*
             * Caso for "(": Será adicionada uma chamada na pilha.
             * 
             * Caso for ")": O caso se dividirá entre as duas possibilidades.
             *      1- Caso a pilha estiver vazia, será adicionado a ela o caractere ).
             * 
             *      2- Caso já existir um caractere "(" na pilha, este será removido, diminuindo a pilha.
             * 
             *      3- Caso a pilha não estiver vazia, será adicionado o caractere )
             * 
             *      Obs. É necessário tratar o caso 1, pois o programa corre o risco de ArrayOutOfBoundException.
             */

            if(caractere.equals("(")) 
                pilha.push(caractere);
            if(caractere.equals(")")) {

                if(pilha.tamanho() == 0) 
                    pilha.push(")");
                else {
                    if(pilha.top().equals("("))
                        pilha.pop();
                    else if(pilha.top().equals(")"))
                        pilha.push(caractere);  
                }

            }
        }

        //Será verificado se ainda existe algo na pilha. Se não existir, significa que o usuário digitou a
        //expressão corretamente. Caso existir, o usuário esqueceu algum caractere. Pela forma como o código foi
        //escrito, o caractere no topo da pilha será sempre o que foi esquecido.
        if(pilha.tamanho() != 0)  {
            if(pilha.top().equals(")"))
                JOptionPane.showMessageDialog(null, "Esqueceu " + pilha.tamanho() + " (", "Esqueceu", 0);
            else 
                JOptionPane.showMessageDialog(null, "Esqueceu " + pilha.tamanho() + " )", "Esqueceu", 0);
        }else
                JOptionPane.showMessageDialog(null, "Não esqueceu nenhum parenteses", "Correto", 1);

    }

    private static void exercicio2() {

        //Instanciação de 3 pilhas.
        Pilha p1 = new Pilha();
        p1.push("1");
        Pilha p2 = new Pilha();
        p2.push("2");
        Pilha p3 = new Pilha();
        p3.push("3");
        Integer remote = 0;
        Integer add = 0;
        String elemento = null;


        //Laço que prossegue com o programa até o usuário digitar um número negativo (Convencionado como -1).
        do {

            //Pergunta ao usuário qual pilha deve ter o topo removido e qual deve ter o topo incrementado.
            remote = Integer.valueOf(JOptionPane.showInputDialog("Digite a pilha de que deseja remover"));
            add = Integer.valueOf(JOptionPane.showInputDialog("Digite a pilha de que deseja adicionar"));


            //Serão analisadas todas as combinações através do cascateamento da estrutura Switch. É verificado 
            //também simultaneamente se não existe nenhuma pilha vazia, para evitar que o usuário remova o topo
            //inexistente de uma pilha.
            switch (remote) {
                case 1:
                    if(p1.tamanho() == 0) {
                        JOptionPane.showMessageDialog(null, "Essa pilha não possui mais elementos", "Tamanho 0", 0);
                        break;
                    }

                    elemento = p1.pop();

                    switch (add) {
                        case 1:
                            p1.push(elemento);  
                            break;
                        case 2:
                            p2.push(elemento);
                            break;
                        case 3:
                            p3.push(elemento);
                            break;
                    }

                    break;

                case 2:
                    if(p2.tamanho() == 0) {
                        JOptionPane.showMessageDialog(null, "Essa pilha não possui mais elementos", "Tamanho 0", 0);
                        break;
                    }

                    elemento = p2.pop();

                    switch (add) {
                        case 1:
                            p1.push(elemento);  
                            break;
                        case 2:
                            p2.push(elemento);
                            break;
                        case 3:
                            p3.push(elemento);
                            break;
                    }
                    break;

                case 3:
                    if(p3.tamanho() == 0) {
                        JOptionPane.showMessageDialog(null, "Essa pilha não possui mais elementos", "Tamanho 0", 0);
                        break;
                    }

                    elemento = p3.pop();

                    switch (add) {
                        case 1:
                            p1.push(elemento);  
                            break;
                        case 2:
                            p2.push(elemento);
                            break;
                        case 3:
                            p3.push(elemento);
                            break;
                    }
                    break;
            }

        //Interface de saída para com o usuário.
        System.out.println("Pilha 1");
        System.out.println("Topo -> " + p1.toString());
        System.out.println("-------------------------------------");
        System.out.println("Pilha 2");
        System.out.println("Topo -> " + p2.toString());
        System.out.println("-------------------------------------");
        System.out.println("Pilha 3");
        System.out.println("topo -> " + p3.toString());
        System.out.println("-------------------------------------");
        System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-  ");

        }while(Integer.valueOf(JOptionPane.showInputDialog("Deseja continuar (1) para sim e (-1) para não")) > 0);

    }
}
