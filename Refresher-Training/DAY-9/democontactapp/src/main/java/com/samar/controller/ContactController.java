package com.samar.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samar.dto.ContactRequestDTO;
import com.samar.dto.ContactResponseDTO;
import com.samar.service.ContactsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

	private final ContactsService contactService;
	
	
	public ContactController(ContactsService contactService) {
		this.contactService = contactService;
	}

	// add 
	@PostMapping
	public ResponseEntity<ContactResponseDTO> createContact(@Valid @RequestBody ContactRequestDTO request) {
		ContactResponseDTO response = contactService.createContact(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//see
	@GetMapping
	public ResponseEntity<List<ContactResponseDTO>> getAllContacts(){
		List<ContactResponseDTO> contacts = contactService.getAllContacts();
		return ResponseEntity.ok(contacts);
		
	}
	
	//search by id 
	@GetMapping("/{id}")
	public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable Long id){
		ContactResponseDTO contacts = contactService.getContactById(id);
		return ResponseEntity.ok(contacts);	
	}
	
	// search BY name
    @GetMapping("/search")
    public ResponseEntity<List<ContactResponseDTO>> searchContacts(@RequestParam String name) {
        List<ContactResponseDTO> contacts = contactService.searchContacts(name);
        return ResponseEntity.ok(contacts);
    }

	
	//update 
	@PutMapping("{id}")
	public ResponseEntity<ContactResponseDTO> updateContact(@PathVariable Long id , @Valid @RequestBody ContactRequestDTO request){
		ContactResponseDTO response = contactService.updateContact(id, request); 
		return ResponseEntity.ok(response);	
	}
	
	 // FAVORITE TOGGLE
    @PatchMapping("/{id}/favourite")
    public ResponseEntity<Void> toggleFavorite(@PathVariable Long id) {
        contactService.toggleFavourite(id);
        return ResponseEntity.noContent().build();
    }
    
    // FAVORITE LIST
    @GetMapping("/favourites")
    public ResponseEntity<List<ContactResponseDTO>> getFavoriteContacts() {
        List<ContactResponseDTO> contacts = contactService.getFavouriteContacts();
        return ResponseEntity.ok(contacts);
    }
    
	
	//delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id){
		contactService.deleteContact(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
