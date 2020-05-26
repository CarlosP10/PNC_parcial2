package com.uca.labo5.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.labo5.dao.CategoriaDAO;
import com.uca.labo5.dao.LibroDAO;
import com.uca.labo5.domain.Categoria;
import com.uca.labo5.domain.Libro;


@Controller
public class MainController {

	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("save","");
		mav.setViewName("index2");
		return mav;
	}
	
	@RequestMapping("/insertarLibro")
	public ModelAndView inserCate() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = null;
		try {
			categorias = categoriaDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libros", new Libro());
		mav.addObject("categorias",categorias);
		mav.setViewName("agregarLibro");
		return mav;
	}
	
	@RequestMapping("/insertarCate")
	public ModelAndView inserLibro() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categorias", new Categoria());
		mav.setViewName("agregarCategoria");
		return mav;
	}
	
	@PostMapping("/ingresarCat")
	public ModelAndView ingresarCat(@Valid @ModelAttribute Categoria categoria, BindingResult result){
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) { 
			mav.setViewName("agregarCategoria");
		}
		else {
			categoriaDAO.insertar(categoria);
			List<Categoria> categorias = null;
			try {
				categorias = categoriaDAO.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("save","Categoria guardada con exito.");
			mav.addObject("categorias", categorias);
			mav.setViewName("index2");
		}		
		return mav;
	}
	
	@PostMapping("/ingresarLibro")
	public ModelAndView ingresarLibro(@Valid @ModelAttribute Libro libro, BindingResult result){
		ModelAndView mav = new ModelAndView();			
		if(result.hasErrors()) { 
			List<Categoria> impor= null;
			try {
				impor = categoriaDAO.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("categorias",impor);
			mav.setViewName("agregarLibro");
		}
		else {			
			libroDAO.insertar(libro);
			mav.addObject("save","Libro guardado con exito.");
			mav.setViewName("index2");
		}		
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView viewAllLibros(){
		ModelAndView mav = new ModelAndView();
		
		List<Libro> libro = null;
		try {
			libro = libroDAO.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("libros",libro);
		mav.setViewName("verLibros");
		return mav;
	}
}
