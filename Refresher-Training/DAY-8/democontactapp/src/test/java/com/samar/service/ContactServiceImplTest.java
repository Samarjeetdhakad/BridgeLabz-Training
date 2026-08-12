	package com.samar.service;

	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.samar.dto.ContactRequestDTO;
import com.samar.dto.ContactResponseDTO;
import com.samar.entity.Contacts;
import com.samar.exception.ContactNotFoundException;
import com.samar.repository.ContactRepository;
	
@ExtendWith(MockitoExtension.class)
public class ContactServiceImplTest {
	
		@Mock
		private ContactRepository contactRepository;

		@InjectMocks
		private ContactServiceImpl contactService;
		
		@Test
		 void contactShouldCreate() {
			
			ContactRequestDTO request = new ContactRequestDTO(
					"samar",
					"dhakad",
					"samar@gmail.com",
					"9898989898",
					"8989898989"
					);
			
			Contacts savedContact = new Contacts();
			savedContact.setId(1L);
			savedContact.setFirstName("samar");
			savedContact.setLastName("dhakad");
			savedContact.setEmail("samar@gmail.com");
			savedContact.setPhone("9898989898");
			savedContact.setAlternatePhone("8989898989");
			
			when(contactRepository.save(any(Contacts.class))).
			thenReturn(savedContact);
			
			ContactResponseDTO response = contactService.createContact(request);
			
			assertNotNull(response);
			
			assertEquals(1L, response.getId());
			assertEquals("samar", response.getFirstName());
		    assertEquals("dhakad", response.getLastName());
		    assertEquals("samar@gmail.com", response.getEmail());

		    
			verify(contactRepository, times(1)).save(any(Contacts.class));		
		}
		
		@Test
		void allContact() {
			
			Contacts contact1 = new Contacts();
			contact1.setId(1L);
		    contact1.setFirstName("samar");
		    contact1.setLastName("dhakad");
		    contact1.setEmail("samar@example.com");
		    contact1.setPhone("9039311323");
		    contact1.setAlternatePhone("9876543210");
		    
		    Contacts contact2 = new Contacts();
		    contact2.setId(2L);
		    contact2.setFirstName("Rahul");
		    contact2.setLastName("Sharma");
		    contact2.setEmail("rahul@example.com");
		    contact2.setPhone("9999999999");
		    contact2.setAlternatePhone("8888888888");
		    
		    
		    when(contactRepository.findAll()).thenReturn(Arrays.asList(contact1, contact2));
		    
		    List<ContactResponseDTO>  response = contactService.getAllContacts();
		    
		    assertNotNull(response);
		    assertEquals(2, response.size());	
		    assertEquals("samar", response.get(0).getFirstName());
		    assertEquals("Rahul", response.get(1).getFirstName());

		    verify(contactRepository, times(1)).findAll();
		    }
		
		void getContactById() {
			
			Contacts contact = new Contacts();
			
			contact.setId(1L);
			contact.setFirstName("Samar");
			contact.setLastName("dhakad");
	     	contact.setEmail("samar@example.com");
		    contact.setPhone("9039311323");
			contact.setAlternatePhone("9876543210");
			
			when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));
			
			ContactResponseDTO response = contactService.getContactById(1L);
			
			assertNotNull(response);

		    assertEquals(1L, response.getId());
		    assertEquals("samar", response.getFirstName());
		    assertEquals("samar@example.com", response.getEmail());


		    verify(contactRepository, times(1))
		            .findById(1L);

		}
		
		//exception
		@Test 
		void throwExceptionWhenContactNotFound() {
			
			when(contactRepository.findById(99L)).thenReturn(Optional.empty());
			
			ContactNotFoundException exception = assertThrows
					(ContactNotFoundException.class , () -> contactService.getContactById(99L));	
			
			assertEquals("contact not found for this id 99",
		            exception.getMessage());
			
			verify(contactRepository,times(1)).findById(99L);
		}
		
		@Test
		void updateContact() {
			
			 ContactRequestDTO request =
			            new ContactRequestDTO(
			                    "Updated",
			                    "User",
			                    "updated@example.com",
			                    "1111111111",
			                    "2222222222"
			            );
			 
			
			Contacts existingContact = new Contacts();

			existingContact.setId(1L);
			existingContact.setFirstName("Samar");
			existingContact.setLastName("dhakad");
	     	existingContact.setEmail("samar@example.com");
		    existingContact.setPhone("9039311323");
			existingContact.setAlternatePhone("9876543210");
			
			when(contactRepository.findById(1L)).thenReturn(Optional.of(existingContact));
			
			when(contactRepository.save(any(Contacts.class))).thenReturn(existingContact);
			
			ContactResponseDTO response = contactService.updateContact(1L, request);
			
			assertNotNull(response);
			
				assertEquals("Updated", response.getFirstName());
			    assertEquals("User", response.getLastName());
			    assertEquals("updated@example.com", response.getEmail());
			    assertEquals("1111111111", response.getPhone());
			    assertEquals("2222222222", response.getAlternatePhone());			
			
			    verify(contactRepository, times(1)).findById(1L);
			    verify(contactRepository, times(1)).save(existingContact);
		}
		
		//exception
		@Test
		void throwExceptionWhenUpdatingNonExistingContact() {
			
		    ContactRequestDTO request =
		            new ContactRequestDTO(
		                    "Updated",
		                    "User",
		                    "updated@example.com",
		                    "1111111111",
		                    "2222222222"
		            );

		    when(contactRepository.findById(99L))
		            .thenReturn(Optional.empty());

		    assertThrows(
		            ContactNotFoundException.class,
		            () -> contactService.updateContact(99L, request)
		    );

		    verify(contactRepository, times(1))
		            .findById(99L);

		    verify(contactRepository, never())
		            .save(any(Contacts.class));
		}
		
		@Test
		void deleteContactbyId() {
			Contacts contact = new Contacts (
					1L,
					"samar",
					"dhakad",
					"samar@gmail.com",
					"9898989898",
					"8989898989"
					);
			
			when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));
			
			 contactService.deleteContact(1L);
			 
			 verify(contactRepository, times(1)).findById(1L);
			 verify(contactRepository, times(1)).delete(contact);	
		}
		
		//excpetion
		   @Test
		    void throwExceptionWhenDeletingNonExistingContact() {
		        when(contactRepository.findById(99L))
		                .thenReturn(Optional.empty());

		        assertThrows(
		                ContactNotFoundException.class,
		                () -> contactService.deleteContact(99L)
		        );

		        verify(contactRepository, times(1))
		                .findById(99L);

		        verify(contactRepository, never())
		                .delete(any(Contacts.class));
		    }
	}
