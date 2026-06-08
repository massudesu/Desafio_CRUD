import static java.lang.IO.*;
void main(){
    String[] nomes = new String[10];
    int[] idades = new int[10];
    String[] cursos = new String[10];
    int totalAlunos = 0;
    int opcao;

    do {

        println("===== SISTEMA DE CADASTRO DE ALUNOS =====");
        println("1 - Cadastrar aluno");
        println("2 - Listar alunos");
        println("3 - Buscar aluno pelo nome");
        println("4 - Remover aluno");
        println("5 - Sair");

        print("Escolha uma opção: ");
        opcao = Integer.parseInt(IO.readln());

        switch (opcao) {

            case 1:

                if (totalAlunos >= nomes.length) {
                    println("Limite máximo de alunos atingido.");
                    break;
                }

                String nome;

                do {
                    print("Nome: ");
                    nome = readln().trim();

                    if (nome.isEmpty()) {
                        println("ERRO: o nome do aluno não pode ficar vazio.");
                    }

                } while (nome.isEmpty());

                int idade = Integer.parseInt(IO.readln("Idade: "));

                print("Curso: ");
                String curso = readln();

                nomes[totalAlunos] = nome;
                idades[totalAlunos] = idade;
                cursos[totalAlunos] = curso;

                totalAlunos++;

                println("Aluno cadastrado!");
                break;

            case 2:

                println("===== LISTA DE ALUNOS =====");

                if (totalAlunos == 0) {
                    println("Nenhum aluno cadastrado.");
                } else {

                    for (int i = 0; i < totalAlunos; i++) {

                        println("===== Aluno " + (i + 1)+" =====");
                        println("Nome: " + nomes[i]);
                        println("Idade: " + idades[i]);
                        println("Curso: " + cursos[i]);
                    }
                }

                break;

            case 3:

                if (totalAlunos == 0) {
                    println("Nenhum aluno cadastrado.");
                    break;
                }

                print("Digite o nome do aluno: ");
                String nomeBusca = readln();

                boolean encontrado = false;

                for (int i = 0; i < totalAlunos; i++) {

                    if (nomes[i].equalsIgnoreCase(nomeBusca)) {

                        println("Aluno encontrado!");
                        println("Nome: " + nomes[i]);
                        println("Idade: " + idades[i]);
                        println("Curso: " + cursos[i]);

                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    println("Aluno não encontrado.");
                }

                break;

            case 4:

                if (totalAlunos == 0) {
                    println("Nenhum aluno cadastrado.");
                    break;
                }

                print("Digite o nome do aluno que quer remover: ");
                String nomeRemover = readln();

                int indice = -1;

                for (int i = 0; i < totalAlunos; i++) {

                    if (nomes[i].equalsIgnoreCase(nomeRemover)) {
                        indice = i;
                        break;
                    }
                }

                if (indice == -1) {

                    println("Aluno não encontrado.");

                } else {

                    println("Aluno encontrado:");
                    println("Nome: " + nomes[indice]);
                    println("Idade: " + idades[indice]);
                    println("Curso: " + cursos[indice]);

                    print("Deseja realmente remover este aluno? (S/N): ");
                    String confirmacao = readln();

                    if (confirmacao.equalsIgnoreCase("S")) {

                        for (int i = indice; i < totalAlunos - 1; i++) {
                            nomes[i] = nomes[i + 1];
                            idades[i] = idades[i + 1];
                            cursos[i] = cursos[i + 1];
                        }

                        nomes[totalAlunos - 1] = null;
                        cursos[totalAlunos - 1] = null;
                        idades[totalAlunos - 1] = 0;

                        totalAlunos--;

                        println("Aluno removido!");

                    } else {

                        println("Operação cancelada.");
                    }
                }

                break;

            case 5:

                println("Sistema encerrado.");
                break;
        }

    } while (opcao != 5);
}