package com.wearperfect.dataservice.api.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.wearperfect.dataservice.api.entities.Post;
import com.wearperfect.dataservice.api.entities.PostItem;
import com.wearperfect.dataservice.api.entities.Post_;

public class PostDetailsSpecification {

	/**
	 * @param userId: used to fetch posts by active user id
	 * @return list of user posts.
	 */	
	public static Specification<Post> postsByUserIdPredicate(final long userId) {

		   return new Specification<Post>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				
				//root.fetch(Post_.postItems);
				Predicate userPostsPredicate=cq.where(
						cb.and(
						cb.equal(root.get(Post_.createdBy), userId),
			    		cb.equal(root.get(Post_.active), true))
						).getRestriction();
							    
				return userPostsPredicate;
			}
			   
		};
	   
	}
	
	/**
	 * @param username	: used to fetch posts by active user id and post id
	 * @return user post.
	 */	
	public static Specification<Post> postByUserIdAndPostIdPredicate(final long userId, final long postId) {

		   return new Specification<Post>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				
								
				Predicate userPostsPredicate=cq.where(
						cb.and(
						cb.equal(root.get(Post_.id), postId),
						cb.equal(root.get(Post_.createdBy), userId),
			    		cb.equal(root.get(Post_.active), true))
						).getRestriction();
							    
				return userPostsPredicate;
			}
			   
		};
	   
	}
}