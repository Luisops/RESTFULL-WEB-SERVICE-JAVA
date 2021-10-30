package com.grupo.proyectotesina.web.app.controlador;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.proyectotesina.web.app.modelo.Cronograma;
import com.grupo.proyectotesina.web.app.service.FirebaseService;

/********REST CONTROLLER****************************************************************************
 * @author Luis Muñoz Guerra 																*
 * @since 20/10/2021	  																	*
 * @version 1.0																				*	
*********************************************************************************************/

@RestController
public class RestCronograma {

	 @Autowired
	 FirebaseService firebaseServices;
	
	
	 @GetMapping("/getCronogramaDetail") public Cronograma  getCronograma(@RequestHeader() 
	 String Id_Cronograma) throws InterruptedException, ExecutionException{ return 
	 firebaseServices.getCronogramaDeatils(Id_Cronograma);}
	 
	
	
	 @PostMapping("/postCronograma") public String postCronograma(@RequestBody
	 Cronograma crono) throws InterruptedException, ExecutionException{ return
	 firebaseServices.saveCronogramaDetails(crono); }
	 
	@PutMapping("/updateCronograma")
	public String putCronograma(@RequestBody Cronograma cronograma)throws InterruptedException, ExecutionException {
		return firebaseServices.updateUserDetails(cronograma);
	}

	@DeleteMapping("/deleteCronograma")
	public String deleteCronograma(@RequestHeader String Id_Cronograma) throws InterruptedException, ExecutionException{
		return firebaseServices.deletedCronogramaDetails(Id_Cronograma);
	}
	
}
