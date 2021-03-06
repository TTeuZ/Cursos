package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StringId = request.getParameter("id");
		int id = Integer.parseInt(StringId);
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresa(id);
		
		request.setAttribute("empresa", empresa);
//		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
//		rd.forward(request, response);
		
		return "forward:formAlteraEmpresa.jsp";
	}
}
