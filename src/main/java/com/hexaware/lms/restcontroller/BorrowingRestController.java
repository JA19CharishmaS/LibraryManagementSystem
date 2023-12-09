package com.hexaware.lms.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.lms.dto.BorrowingDTO;
import com.hexaware.lms.entities.Borrowing;
import com.hexaware.lms.exceptions.BookNotFoundException;
import com.hexaware.lms.exceptions.BorrowingNotFoundException;
import com.hexaware.lms.service.IBorrowingService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/librarymanagementsystem/borrowing")
public class BorrowingRestController {
	
	
	private IBorrowingService service;
	@Autowired
	public BorrowingRestController(IBorrowingService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public Borrowing addBorrowing(@RequestBody @Valid BorrowingDTO borrowingDTO) {
		

		return service.addBorrowing(borrowingDTO);
	}
	
	@DeleteMapping("/delete/{borrowingid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String deleteById(@PathVariable Long borrowingid) {

		// returns void
        service.deleteBorrowingById(borrowingid); 
        
		return "Record Deleted";
	}
	
	@GetMapping("/getbyborrowingid/{borrowingid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public BorrowingDTO  getBorrowingById(@PathVariable @Valid Long borrowingid) throws BorrowingNotFoundException{
		
		BorrowingDTO borrowingDTO = service.getBorrowingById(borrowingid);
		
		if(borrowingDTO.getBorrowingid() == 0) {
			
			throw new BorrowingNotFoundException(HttpStatus.BAD_REQUEST,"Borrowing Not Found for id : "+borrowingid);
		}
		
		return borrowingDTO;
		
		
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<Borrowing> getAllBorrowing(){
		
		return service.getAllBorrowing();
	}
	 @PutMapping("/return")
	 @PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public Borrowing returnBorrowing( @RequestBody BorrowingDTO borrowingDTO)
	{
              return   service.returnBorrowing(borrowingDTO);
	}

}
