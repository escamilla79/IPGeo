package com.examen.evalu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examen.evalu.model.IPGeo;
import com.examen.evalu.service.IPGeoService;

//@RestController
//@RequestMapping("/api/ipgeos")
@Controller
public class IPGeoController {
	
	@Autowired
	private IPGeoService ipgeoService;
	
	@GetMapping("/ipgeos")
	public String getAllIPGeos(Model model){
		 List<IPGeo> ipgeos =ipgeoService.getAllIPGeos();
		 model.addAttribute("ipgeos",ipgeos);
		 return "ipgeos";
	}
	
	@PostMapping("/ipgeos2")
	public String saveIPGeo(IPGeo ipgeo, RedirectAttributes redirectAttributes) {
		System.out.println("Create un nuevo elmento");
		try {
			ipgeoService.saveIPGeo(ipgeo);
		 
			} catch (IllegalArgumentException e) {
	            // Add error message as a flash attribute
	            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
	        }
	        return "redirect:/ipgeos";
		}
	
	/*
	 * @GetMapping("/{ip}") public IPGeo updateIPGeo(@PathVariable long
	 * ip, @RequestBody IPGeo ipgeo) {
	 * 
	 * ipgeo.setIp(ip); ipgeoService.saveIPGeo(ipgeo);
	 * 
	 * }
	 */
	@PostMapping("/ipgeos/delete/{ip}")
	public String deleteIPGeo(@PathVariable Long ip) {
		ipgeoService.delteIPGeo(ip);
		return "redirect:/ipgeos";
	}
	/*
	 * @GetMapping("/{ip}") public IPGeo getUserById(@PathVariable Long ip) { return
	 * ipgeoRepository.findById(ip) .orElseThrow(() -> new
	 * RuntimeException("IP no se encontro: " + ip)); }
	 */
	

}
