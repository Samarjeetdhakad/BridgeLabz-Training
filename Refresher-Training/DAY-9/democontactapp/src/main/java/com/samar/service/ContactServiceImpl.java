package com.samar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samar.dto.ContactRequestDTO;
import com.samar.dto.ContactResponseDTO;
import com.samar.entity.Contacts;
import com.samar.exception.ContactNotFoundException;
import com.samar.repository.ContactRepository;

import jakarta.validation.Valid;

@Service
public class ContactServiceImpl implements ContactsService{

	private final ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {	
		this.contactRepository = contactRepository;
	}
	
	@Override
	public ContactResponseDTO createContact(@Valid ContactRequestDTO request) {
		Contacts contact = new Contacts();
		contact.setFirstName(request.getFirstName());
		 contact.setLastName(request.getLastName());
	     contact.setEmail(request.getEmail());
	     contact.setPhone(request.getPhone());
	     contact.setAlternatePhone(request.getAlternatePhone());
	     
	        Contacts savedContact = contactRepository.save(contact);
		return convertToResponseDTO(savedContact);	
	}
	
	@Override
	public List<ContactResponseDTO> getAllContacts(){
		return contactRepository.findAll().
				stream().
				map(this::convertToResponseDTO).
				toList();
	}

	@Override
	public ContactResponseDTO getContactById(Long id) {
	     
		Contacts contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("contact not found for this id " + id ));
		return convertToResponseDTO(contact);
	}
	
	@Override
	public ContactResponseDTO updateContact(Long id, ContactRequestDTO request) {
		  Contacts contact = contactRepository.findById(id)
	        		.orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));
		  
		    contact.setFirstName(request.getFirstName());
	        contact.setLastName(request.getLastName());
	        contact.setEmail(request.getEmail());
	        contact.setPhone(request.getPhone());
	        contact.setAlternatePhone(request.getAlternatePhone());
		  
	        Contacts updatedContact = contactRepository.save(contact);
		  return convertToResponseDTO(updatedContact);
	}
	
	@Override
	public void deleteContact(Long id) {
		Contacts contact = contactRepository.findById(id).
				orElseThrow(()-> new ContactNotFoundException("contact not found for id " + id));
		
		contactRepository.delete(contact);		
	}
	
	
	
	@Override
    public List<ContactResponseDTO> searchContacts(String name) {
        return contactRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name)
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }
    
	@Override
    public void toggleFavourite(Long id) {

        Contacts contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));

       contact.setFavourite(!contact.isFavourite());

        contactRepository.save(contact);
    }
    

	  @Override
	    public List<ContactResponseDTO> getFavouriteContacts() {

	        return contactRepository.findByFavouriteTrue()
	                .stream()
	                .map(this::convertToResponseDTO)
	                .toList();
	    }
	
	// for conversion to response DTO
		private ContactResponseDTO convertToResponseDTO(Contacts savedContact) {
			 return new ContactResponseDTO(
		                savedContact.getId(),
		                savedContact.getFirstName(),
		                savedContact.getLastName(),
		                savedContact.getEmail(),
		                savedContact.getPhone(),
		                savedContact.getAlternatePhone(),
		                savedContact.isFavourite()
		        );
		    }

		
		
		

	
	}

