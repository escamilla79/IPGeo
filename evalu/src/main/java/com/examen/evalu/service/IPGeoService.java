package com.examen.evalu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.evalu.model.IPGeo;
import com.examen.evalu.repository.IPGeoRepository;

@Service
public class IPGeoService {

	@Autowired
	private IPGeoRepository ipgeoRepository;
	
	public List<IPGeo> getAllIPGeos(){
		return ipgeoRepository.findAll();
	}
	
	public void saveIPGeo(IPGeo ipgeo) {
		
		if (ipgeoRepository.existsById(ipgeo.getIp())) {
            throw new IllegalArgumentException("Ya existe una IP en BD!");
        }
		ipgeoRepository.save(ipgeo);
		
	}
	public void delteIPGeo(Long ip) {
		ipgeoRepository.deleteById(ip);
	}
	
}
