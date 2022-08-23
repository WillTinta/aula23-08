
import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author aluno
 */
public class TesteProdutoCategoria {
        private static ProdutoDAO produtaDAO = new ProdutoDAO();
        private static CategoriaDAO categoriaDAO = new CategoriaDAO();

    public static void main(String[] args) {
        adicionarProdutos();
        reajustarPreco(new BigDecimal(5.0));

    }
    
    private static void teste(){
        Categoria categoria = new Categoria();
        categoria.setDescricao("Informatica");
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.inserir(categoria);

        Produto produto = new Produto();
        produto.setDescricao("Teclado");
        produto.setPreco(new BigDecimal(60.0));
        produto.setQuantidade(100);

        produto.setCategoria(categoria);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);
        

        //em.persist(categoria);
        
        //JPQL
        //Sempre pensar em classe
        //SELECT p FROM Produto p

   
        for (Produto p : produtoDAO.buscar()) {
            System.out.println("Descricao: " + p.getDescricao());
        }
    }
    
    private static void adicionarProdutos(){        
        
        for(int i = 0; i < 10; i++){
            Categoria categoria = new Categoria();
            categoria.setDescricao("Categoria " + i);
            categoriaDAO.inserir(categoria);
            
            Produto produto = new Produto();
            produto.setDescricao("Produto " + i);
            produto.setPreco(new BigDecimal(60.0 * (i+1)));
            produto.setQuantidade(100);

            produto.setCategoria(categoria);
            
            produtaDAO.inserir(produto);
        }
    }
    
    private static void reajustarPreco(BigDecimal percentual){
        System.out.println(produtaDAO.buscar());
    }
}
