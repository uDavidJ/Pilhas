import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

    String resp;
        do {
            resp = JOptionPane.showInputDialog("Digite o exercício");

            if(resp.equals("1"))
                exercicio1();
            else
                exercicio2();

        }while(!(resp.equals("1")) && !(resp.equals("2")));
          

    }


    private static void exercicio1() {
        Pilha pilha = new Pilha();

        String resp = JOptionPane.showInputDialog("Digite a expressão");

        String[] caracteres = new String[resp.length()];
        caracteres = resp.split("");

        for(String caractere : caracteres) {
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

        if(pilha.tamanho() != 0)  {
            if(pilha.top().equals(")"))
                JOptionPane.showMessageDialog(null, "Esqueceu " + pilha.tamanho() + " (", "Esqueceu", 0);
            else 
                JOptionPane.showMessageDialog(null, "Esqueceu " + pilha.tamanho() + " )", "Esqueceu", 0);
        }else
                JOptionPane.showMessageDialog(null, "Esqueceu nada bro", "Esqueceu", 1);

    }

    private static void exercicio2() {
        Pilha p1 = new Pilha();
        p1.push("1");
        Pilha p2 = new Pilha();
        p2.push("2");
        Pilha p3 = new Pilha();
        p3.push("3");
        Integer remote = 0;
        Integer add = 0;
        String elemento = null;

        do {
            remote = Integer.valueOf(JOptionPane.showInputDialog("Digite a pilha de que deseja remover"));
            add = Integer.valueOf(JOptionPane.showInputDialog("Digite a pilha de que deseja adicionar"));

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
