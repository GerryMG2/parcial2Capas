package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	serviceLibro libo = new serviceLibro();
	
	@Autowired
	categoriaService categoria = new categoriaService();
	
	
	@GetMapping(path = "/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
			
		mav.setViewName("index");
		
		
		return mav;
	}
	
	
	@GetMapping(path = "/libro")
	public ModelAndView registrolibro(libro lib) {
		ModelAndView mav = new ModelAndView();
			
		mav.setViewName("formularioLibro");
		mav.addObject("lista", categoria.getAll());
		
		
		return mav;
	}
	
	
	@PostMapping(path = "/libro")
	public ModelAndView registrar(@ModelAttribute libro est, BindingResult result) {
	
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("formularioLibro");
		}else {
			Boolean resolve = libo.save(est);
			if(resolve) {
				mav.setViewName("index");
				mav.addObject("msg", "el libro se guardo con exito!");
			}else {
				mav.setViewName("index");
				mav.addObject("msg", "hubo un problema al guardar el libro");
			}
		}
		
		
		return mav;
	}
	

	@GetMapping(path = "/categoria")
	public ModelAndView registrocategoria(categoria cat) {
		ModelAndView mav = new ModelAndView();
			
		mav.setViewName("formularioCategoria");
		
		
		
		return mav;
	}
	
	
	@PostMapping(path = "/categoria")
	public ModelAndView postcategoria(@ModelAttribute categoria est, BindingResult result) {
	
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("formularioCategoria");
		}else {
			Boolean resolve = categoria.save(est);
			if(resolve) {
				mav.setViewName("index");
				mav.addObject("msg", "la categoria se guardo con exito!");
			}else {
				mav.setViewName("index");
				mav.addObject("msg", "hubo un problema al guardar la categoria");
			}
		}
		
		
		return mav;
	}
	
	
	
	@GetMapping(path = "/verlibros")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listadolibros");
		try {
			System.out.println("entra al try");
			
			List<fakelibro> listanueva = new ArrayList<fakelibro>();
			for (libro l : libo.getLibros()) {
				for(categoria cat: categoria.getAll()) {
					if(l.getCategoria() == cat.getCodigo()) {
						fakelibro a = new fakelibro(l, cat.getCategoria());
						listanueva.add(a);
					}
				}
			}
			mav.addObject("listalibros", listanueva);
		
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return mav;
	}


}
