import dao.ProdutoDAO;
import model.Produto;

public class Main {
    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();

// listar antes
        dao.listar();

// deletar
        dao.deletar(1); // usa o ID que apareceu pra você

// listar depois
        dao.listar();

    }
}