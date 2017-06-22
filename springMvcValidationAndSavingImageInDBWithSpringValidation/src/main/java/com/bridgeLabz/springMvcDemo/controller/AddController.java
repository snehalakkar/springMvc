package com.bridgeLabz.springMvcDemo.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeLabz.springMvcDemo.model.Country;
import com.bridgeLabz.springMvcDemo.service.CountryService;

@Controller
public class AddController {

	List<Country> list;

	@Autowired
	CountryService countryService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(byte[].class, "file", new ByteArrayMultipartFileEditor());
	}

	@RequestMapping(value = "/")
	public String welcome() {
		list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", list);
		return "welcome";
	}

	@RequestMapping(value = "/wel", method = RequestMethod.GET)
	public String welcome1() {
		return "welcome";
	}

	@RequestMapping(value = "/passing", method = RequestMethod.GET)
	public ModelAndView passsingUrl() {
		List<Country> list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView("addCountry", "country", new Country());
		mv.addObject("result", list);
		return mv;
	}

	@RequestMapping("/addCountry")
	public ModelAndView addCountry1() {
		List<Country> list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView("addCountry", "country", new Country());
		mv.addObject("result", list);
		return mv;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add1(@RequestParam("file") CommonsMultipartFile file,
			@ModelAttribute("country") @Valid Country country, BindingResult result) throws IOException {

		String fname = file.getOriginalFilename();
		country.setFileName(fname);
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("addCountry");
			model1.addObject("message", "All fields are mandatory");
			return model1;
		} else {
			countryService.addCountry(country, file);
			// List<Country> list = countryService.displayAllCountry();
			return new ModelAndView("redirect:passing");

		}
	}

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public void getImage(@ModelAttribute("id") int id, HttpServletResponse response) throws IOException {

		byte[] bytes = countryService.getImageById(id);

		if (bytes != null) {

			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");
			ServletOutputStream responseOutputStream = response.getOutputStream();
			responseOutputStream.write(bytes);
			responseOutputStream.flush();
			responseOutputStream.close();
			System.out.println(bytes.length);

		} else {
			System.out.println("no upload found............");
			response.getWriter().println("no upload found...");
		}
	}

	@RequestMapping(value = "/deleteImage", method = RequestMethod.GET)
	public ModelAndView deleteImage(@ModelAttribute("id") int id, HttpServletResponse response) {

		countryService.deleteImageById(id);
		List<Country> list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", list);
		return mv;
	}

	@RequestMapping("/display")
	public ModelAndView displayAll(Country country) {
		List<Country> list = countryService.displayAllCountry();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", list);
		return mv;
	}

	@RequestMapping(value = "/edit11", method = RequestMethod.GET)
	public ModelAndView editCountry(Country country, HttpServletRequest request, HttpServletResponse response) {
		// String countryName=country.getName();
		int countryid = country.getId();
		byte[] imagebytes = null;
		HttpSession session = request.getSession();
		session.setAttribute("countryId", countryid);
		List<Country> list = countryService.updateCountryDetails(countryid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit");
		mv.addObject("result", list);
		System.out.println("lllllllllllllllllllllllllllll" + list);
		Iterator<Country> itr = list.iterator();
		if (itr.hasNext()) {
			Country c1 = itr.next();
			imagebytes = c1.getfile();
			c1.setfile(imagebytes);
		}
		System.out.println("bytes of img :" + imagebytes);
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView editCountry1(@RequestParam("file") CommonsMultipartFile file,
			@ModelAttribute("country") @Valid Country country, BindingResult res, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int conId = (Integer) session.getAttribute("countryId");
		country.setId(conId);
		String fname = file.getOriginalFilename();
		country.setFileName(fname);
		if (res.hasErrors()) {
			System.out.println("errors......................");
			ModelAndView model = new ModelAndView("redirect:edit11");
			model.addObject("id", country.getId());
			return model;
		} else {
			countryService.updateCountryInDataBase(country);

			List<Country> list = countryService.displayAllCountry();

			ModelAndView mv = new ModelAndView();
			mv.setViewName("display");
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
