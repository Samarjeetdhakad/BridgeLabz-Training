package com.samar.service;

import java.util.List;


import com.samar.dto.ContactRequestDTO;
import com.samar.dto.ContactResponseDTO;


public interface ContactsService {

	 ContactResponseDTO createContact(ContactRequestDTO reuquest);

	List<ContactResponseDTO>  getAllContacts( );
	
	List<ContactResponseDTO> searchContacts(String name);
	
	ContactResponseDTO getContactById(Long id);
	
	ContactResponseDTO updateContact(Long id, ContactRequestDTO request);
	
	void deleteContact(Long id);
	
	void toggleFavourite(Long id);

	List<ContactResponseDTO> getFavouriteContacts();
	

}
