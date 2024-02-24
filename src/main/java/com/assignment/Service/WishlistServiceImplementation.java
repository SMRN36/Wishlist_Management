package com.assignment.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.assignment.Exception.ProductException;
import com.assignment.Exception.UserException;
import com.assignment.Exception.WishlistException;
import com.assignment.Model.Product;
import com.assignment.Model.Users;
import com.assignment.Model.Wishlist;
import com.assignment.Repository.ProductRepository;
import com.assignment.Repository.UserRepository;
import com.assignment.Repository.WishlistRepository;

@Service
public class WishlistServiceImplementation implements WishlistService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;

	@Override
	public Wishlist addProductToWishlist(Integer ProductId) throws WishlistException,UserException,ProductException {
		String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
		if(opt.isEmpty()) {
			throw new UserException("User not found");
		}
		
		Optional<Product> optProduct = productRepository.findById(ProductId);
		if(optProduct.isEmpty()) {
			throw new ProductException("Product not found");
		}
		Product product = optProduct.get();
		Users loggedInUser = opt.get();
		
		Wishlist wishlist = loggedInUser.getWishlist();
        if (wishlist == null) {
            wishlist = new Wishlist();
            wishlistRepository.save(wishlist);
            loggedInUser.setWishlist(wishlist);
        }
        wishlist.getListOfProducts().add(product);
        userRepository.save(loggedInUser); 
        return wishlist;
	}

	@Override
	public Wishlist deleteProductFromWishlist(Integer ProductId) throws WishlistException,UserException,ProductException {
		String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
		if(opt.isEmpty()) {
			throw new UserException("User not found");
		}
		
		Optional<Product> optProduct = productRepository.findById(ProductId);
		if(optProduct.isEmpty()) {
			throw new ProductException("Product not found");
		}
		
		Product product = optProduct.get();
		Users loggedInUser = opt.get();
		
		Wishlist wishlist = loggedInUser.getWishlist();
	    if (wishlist == null) {
	        throw new WishlistException("Wishlist not found");
	    }
	    
	    wishlist.getListOfProducts().remove(product);
	    
	    userRepository.save(loggedInUser);
	    
	    return wishlist;
	    
	}

	@Override
	public Wishlist getLoggedInUserWishlist() throws WishlistException, UserException, ProductException {
		String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
		if(opt.isEmpty()) {
			throw new UserException("User not found");
		}
		Users loggedInUser = opt.get();
		
		Wishlist wishlist = loggedInUser.getWishlist();
		return wishlist;
	}

}
