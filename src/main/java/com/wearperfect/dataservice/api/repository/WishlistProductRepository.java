package com.wearperfect.dataservice.api.repository;

import com.wearperfect.dataservice.api.entity.WishlistProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WishlistProductRepository extends JpaRepository<WishlistProduct, Long>, JpaSpecificationExecutor<WishlistProduct> {
    Page<WishlistProduct> findByUserId(Long userId, Pageable pageable);

    @Query(value = "SELECT wp FROM WishlistProduct wp " +
            "JOIN WishlistCollectionProduct wcp ON wp.id = wcp.wishlistProductId " +
            "WHERE wcp.wishlistCollectionId =:wishlistCollectionId AND wp.userId =:userId")
    Page<WishlistProduct> findByUserIdAndWishlistCollectionId(@Param("userId") Long userId, @Param("wishlistCollectionId") Long wishlistCollectionId, Pageable pageable);
}