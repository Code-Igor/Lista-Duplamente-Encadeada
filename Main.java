public class Main {
    public static void main(String[] args) {

        // testando lista duplamente encadeada
        ListaEncadeada lista = new ListaEncadeada();

        // inserindo no inicio
        lista.inserirInicio(20);
        lista.inserirInicio(10);
        lista.exibir();

        // inserindo no fim
        lista.inserirFim(30);
        lista.inserirFim(40);
        lista.exibir();

        // testando busca
        No noBuscado = lista.buscar(30);
        if (noBuscado != null) {
            System.out.println("valor encontrado: " + noBuscado.valor);
        } else {
            System.out.println("valor nao encontrado");
        }

        // inserindo apos um valor
        lista.inserirApos(20, 25);
        lista.exibir();

        // removendo inicio
        lista.removerInicio();
        lista.exibir();

        // removendo fim
        lista.removerFim();
        lista.exibir();

        // removendo valor especifico
        lista.remover(25);
        lista.exibir();

        // testando tamanho
        System.out.println("tamanho da lista: " + lista.tamanho());

        // testando se esta vazia
        System.out.println("lista esta vazia? " + lista.estaVazia());
    }
}
