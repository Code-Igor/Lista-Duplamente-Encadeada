public class ListaEncadeada {

    No inicio;
    No fim;

    public ListaEncadeada() {}

    public void inserirInicio(int valor) {
        No novoNo = new No(valor);

        // se for a insercao do primeiro elemento, o novono vai ser o inicio e o final
        // o no já comeca por padrao com o proximo e anterior nulos
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            //
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }

    }

      // Insere no final da lista
    public void inserirFim(int valor) {
        No novoNo = new No(valor);

        // se a lista estiver vazia, o novo no sera o inicio e o fim
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            // o fim atual aponta para o novo no
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    // Procura o valor e insere um novo no logo depois dele
    public void inserirApos(int valorProcurado, int valorInserido) {

        No noEncontrado = buscar(valorProcurado);

        // se nao encontrar o valor, nao insere
        if (noEncontrado == null) {
            System.out.println("valor nao encontrado");
            return;
        }

        No novoNo = new No(valorInserido);

        // se o no encontrado for o ultimo, basta inserir no fim
        if (noEncontrado == fim) {
            noEncontrado.proximo = novoNo;
            novoNo.anterior = noEncontrado;
            fim = novoNo;
        } else {
            // guarda o proximo do no encontrado
            No proximoNo = noEncontrado.proximo;

            // conecta o novo no entre os dois nos
            noEncontrado.proximo = novoNo;
            novoNo.anterior = noEncontrado;
            novoNo.proximo = proximoNo;
            proximoNo.anterior = novoNo;
        }
    }

    // Percorre no por no e retorna o no encontrado; null se nao encontrar
    public No buscar(int valor) {
        No atual = inicio;

        while (atual != null) {
            if (atual.valor == valor) {
                return atual;
            }
            atual = atual.proximo;
        }

        return null;
    }

    // Remove o primeiro elemento da lista
    public void removerInicio() {

        // se a lista estiver vazia nao ha o que remover
        if (inicio == null) {
            return;
        }

        // se houver apenas um elemento, a lista fica vazia
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
    }

    // Remove o ultimo elemento da lista
    public void removerFim() {

        // se a lista estiver vazia nao ha o que remover
        if (fim == null) {
            return;
        }

        // se houver apenas um elemento, a lista fica vazia
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
    }


    // Procura o valor e remove o no correspondente
    public void remover(int valor) {

        No noRemovido = buscar(valor);

        // se nao encontrar o valor nao remove nada
        if (noRemovido == null) {
            System.out.println("valor nao encontrado");
            return;
        }

        // se for o primeiro elemento
        if (noRemovido == inicio) {
            removerInicio();
        }
        // se for o ultimo elemento
        else if (noRemovido == fim) {
            removerFim();
        }
        // se estiver no meio da lista
        else {
            noRemovido.anterior.proximo = noRemovido.proximo;
            noRemovido.proximo.anterior = noRemovido.anterior;
        }
    }

    public boolean estaVazia() {
        if (inicio == null || fim==null) {return true;}
        return false;
    }

    // Percorre a lista e conta quantos elementos existem
    public int tamanho() {

        int quantidade = 0;
        No atual = inicio;

        while (atual != null) {
            quantidade++;
            atual = atual.proximo;
        }

        return quantidade;
    }

    // Printa elemento por elemento da lista
    public void exibir() {

        No atual = inicio;

        System.out.println("lista encadeada:");
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
        System.out.println("---");
    }
}
