/**
 * 
 */
package com.mitienda.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mitienda.clientes.dao.IClienteDAO;
import com.mitienda.clientes.model.Cliente;

import lombok.RequiredArgsConstructor;

/**
 * @author Edgar Chimarro
 *
 */
@Controller
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private IClienteDAO clienteDao;

    @GetMapping
    public String inicio(Model model, @PageableDefault(size = 3) Pageable pageable) {
	List<Cliente> clientes = clienteDao.findAll();
	System.out.println("clientes:" + clientes.toString());
	model.addAttribute("clientes", clientes);
	return "index";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
	model.addAttribute("clientes", new Cliente());
	return "form";
    }

    @PostMapping("/nuevo")
    public String crear(Cliente cliente) {
	clienteDao.save(cliente);
	return "redirect:/";
    }

}
