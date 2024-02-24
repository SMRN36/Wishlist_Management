package com.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.Model.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

}
