package com.bridgeLabz.springMvcDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.bridgeLabz.springMvcDemo.model.Country;
import com.bridgeLabz.springMvcDemo.service.CountryService;

@Controller
public class AddController {
	
	List<Country> list;
	
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/")
	public String welcome(){
	    list=countryService.displayAllCountry();
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",list);
		return "welcome";
	}
	
	@RequestMapping("/addCountry")
	public ModelAndView addCountry1(){
		
		List<Country> list=countryService.displayAllCountry();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addCountry");
		mv.addObject("result",list);
		
		return mv;
		
	}
	
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public ModelAndView add(@Valid Country country,BindingResult res) {
		
//		if(country.getName() == "" || country.getName() == null ||country.getCorrency()=="" ||country.getPopulation()=="" ||country.getSpeciality()==""){
//			ModelAndView model=new ModelAndView("addCountry");
//			model.addObject("message", "All fields are must");
//			return model;
//		}
//		else{
//			countryService.addCountry(country);
//			List<Country> list=countryService.displayAllCountry();
//			ModelAndView mv=new ModelAndView();
//			mv.setViewName("addCountry");
//			mv.addObject("result",list);
//			
//			return mv;
//		}
		ModelAndView mv=new ModelAndView();
		try {
			countryService.addCountry(country);
			
		} catch (Exception e) {
			
			mv.addObject("error",e.getMessage());
			
		}
		
		List<Country> list=countryService.displayAllCountry();
		
		mv.setViewName("addCountry");
		mv.addObject("result",list);
		System.out.println(mv);
		return mv;
		
	}
	
	@RequestMapping("/display")
	public ModelAndView displayAll(Country country) {
		List<Country> list=countryService.displayAllCountry();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",list);
		return mv;
	}
}
