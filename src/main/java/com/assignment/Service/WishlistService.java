package com.assignment.Service;

import com.assignment.Exception.ProductException;
import com.assignment.Exception.UserException;
import com.assignment.Exception.WishlistException;
import com.assignment.Model.Wishlist;

public interface WishlistService {
	
	public Wishlist addProductToWishlist(Integer ProductId) throws WishlistException,UserException,ProductException;
	
	public Wishlist deleteProductFromWishlist(Integer ProductId) throws WishlistException,UserException,ProductException;
	
	public Wishlist getLoggedInUserWishlist() throws WishlistException,UserException,ProductException; 

}
