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
import com.uca.labo5.dao.ContrubyenteDAO;
import com.uca.labo5.dao.ImportanciaDAO;
import com.uca.labo5.dao.LibroDAO;
import com.uca.labo5.domain.Categoria;
import com.uca.labo5.domain.Contribuyente;
import com.uca.labo5.domain.Importancia;
import com.uca.labo5.domain.Libro;


@Controller
public class MainController {
//
//	@Autowired
//	private ImportanciaDAO impoDao;
//	
//	@Autowired
//	private ContrubyenteDAO contriDao;
//	
	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		Libro libro = new Libro();
		mav.addObject("categorias",categoria);
		mav.addObject("libros",libro);
//		mav.addObject("contribuyente",contri);
//		mav.addObject("importancias",impor);
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
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			libro.setIngreso(date);
			libroDAO.insertar(libro);
			System.out.println(libro.getEstado());
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

//	@PostMapping("/procesar")
//	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contri, BindingResult result){
//		ModelAndView mav = new ModelAndView();			
//		if(result.hasErrors()) { 
//			List<Importancia> impor= null;
//			try {
//				impor = impoDao.findAll();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			mav.addObject("importancias",impor);
//			mav.setViewName("index");
//		}
//		else {
//			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
//			Date date = new Date(System.currentTimeMillis());
//			contri.setDate(date);
//			contriDao.insertar(contri);
//			mav.setViewName("guardado");
//		}		
//		return mav;
//	}
//	
//	@RequestMapping("/listado")
//	public ModelAndView viewAll(){
//		ModelAndView mav = new ModelAndView();
//		
//		List<Contribuyente> contri = null;
//		try {
//			contri = contriDao.findAll();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		mav.addObject("contribuyentes",contri);
//		mav.setViewName("main");
//		return mav;
//	}

}
