/**
 * 
 */
package com.mitienda.clientes.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mitienda.clientes.dao.IClienteDAO;
import com.mitienda.clientes.model.Cliente;

import lombok.RequiredArgsConstructor;

/**
 * @author Edgar Chimarro
 *
 */
@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })

public class ClienteController {
    
    private static final String ATRIBUTO_CLIENTES = "clientes";

    @Autowired
    private IClienteDAO clienteDao;

    @GetMapping
    public String inicio(Model model, @PageableDefault(size = 3) Pageable pageable) {
	Page<Cliente> clientes = clienteDao.findAll(pageable);
	model.addAttribute(ATRIBUTO_CLIENTES, clientes);
	return "index";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
	model.addAttribute(ATRIBUTO_CLIENTES, new Cliente());
	return "form";
    }

    @PostMapping("/guardar")
    public String crear(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date, Cliente cliente) {
	clienteDao.save(cliente);
	return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Long id) {
	Optional<Cliente> clientes = clienteDao.findById(id);
	model.addAttribute(ATRIBUTO_CLIENTES, clientes);
	return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Model model, @PathVariable Long id) {
	clienteDao.deleteById(id);
	return "redirect:/";
    }

}
