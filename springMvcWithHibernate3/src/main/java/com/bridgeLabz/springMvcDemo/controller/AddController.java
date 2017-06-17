package com.bridgeLabz.springMvcDemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "/")
	public String welcome() {
		list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", list);
		return "welcome";
	}

	@RequestMapping("/addCountry")
	public ModelAndView addCountry1() {
		List<Country> list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView("addCountry", "country", new Country());
		mv.addObject("result", list);
		return mv;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add1(@ModelAttribute("country") @Valid Country country, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("addCountry");
			model1.addObject("message", "All fields are mandatory");
			return model1;
		} else {
			try {
				countryService.addCountry(country);
			} catch (DataIntegrityViolationException e) {
				e.printStackTrace();
			}
			List<Country> list = countryService.displayAllCountry();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("addCountry");
			mv.addObject("result", list);
			return mv;
		}
	}

	@RequestMapping("/display")
	public ModelAndView displayAll(Country country) {
		List<Country> list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", list);
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCountry(Country country, HttpServletRequest request, HttpServletResponse response) {
		// String countryName=country.getName();
		int countryid = country.getId();
		HttpSession session = request.getSession();
		session.setAttribute("countryId", countryid);
		List<Country> list = countryService.updateCountryDetails(countryid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit");
		mv.addObject("result", list);
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView editCountry1(@Valid Country country, BindingResult res, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int conId = (Integer) session.getAttribute("countryId");

		country.setId(conId);

		if (res.hasErrors()) {
			ModelAndView model = new ModelAndView("edit");
			model.addObject("message", "All fields are must");
			return model;
		} else {
			countryService.updateCountryInDataBase(country);

			List<Country> list = countryService.displayAllCountry();

			ModelAndView mv = new ModelAndView();
			mv.setViewName("addCountry");
			mv.addObject("result", list);
			return mv;
		}
	}

	@RequestMapping("/delete")
	public ModelAndView deleteCountry(Country country) {
		int deleteId = country.getId();
		System.out.println(deleteId);
		countryService.deleteCountry(deleteId);

		List<Country> list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addCountry");
		mv.addObject("result", list);
		return mv;
	}

}
