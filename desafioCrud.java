import static java.lang.IO.*;
void main(){
    String[] nomes = new String[10];
    int[] idades = new int[10];
    String[] cursos = new String[10];
    int totaldeAlunos = 0;
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

                if (totaldeAlunos >= nomes.length) {
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

                nomes[totaldeAlunos] = nome;
                idades[totaldeAlunos] = idade;
                cursos[totaldeAlunos] = curso;

                totaldeAlunos++;

                println("Aluno cadastrado!");
                break;

            case 2:

                println("===== LISTA DE ALUNOS =====");

                if (totaldeAlunos == 0) {
                    println("Nenhum aluno cadastrado.");
                } else {

                    for (int i = 0; i < totaldeAlunos; i++) {

                        println("===== Aluno " + (i + 1)+" =====");
                        println("Nome: " + nomes[i]);
                        println("Idade: " + idades[i]);
                        println("Curso: " + cursos[i]);
                    }
                }

                break;

            case 3:

                if (totaldeAlunos == 0) {
                    println("Nenhum aluno cadastrado.");
                    break;
                }

                print("Digite o nome do aluno: ");
                String nomeparaBuscar = readln();

                boolean encontrar = false;

                for (int i = 0; i < totaldeAlunos; i++) {

                    if (nomes[i].equalsIgnoreCase(nomeparaBuscar)) {

                        println("Aluno encontrado!");
                        println("Nome: " + nomes[i]);
                        println("Idade: " + idades[i]);
                        println("Curso: " + cursos[i]);

                        encontrar = true;
                        break;
                    }
                }

                if (!encontrar) {
                    println("Aluno não encontrado.");
                }

                break;

            case 4:

                if (totaldeAlunos == 0) {
                    println("Nenhum aluno cadastrado.");
                    break;
                }

                print("Digite o nome do aluno que quer remover: ");
                String nomeparaRemover = readln();

                int indice = -1;

                for (int i = 0; i < totaldeAlunos; i++) {

                    if (nomes[i].equalsIgnoreCase(nomeparaRemover)) {
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
                    String confirmar = readln();

                    if (confirmar.equalsIgnoreCase("S")) {

                        for (int i = indice; i < totaldeAlunos - 1; i++) {
                            nomes[i] = nomes[i + 1];
                            idades[i] = idades[i + 1];
                            cursos[i] = cursos[i + 1];
                        }

                        nomes[totaldeAlunos - 1] = null;
                        cursos[totaldeAlunos - 1] = null;
                        idades[totaldeAlunos - 1] = 0;

                        totaldeAlunos--;

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